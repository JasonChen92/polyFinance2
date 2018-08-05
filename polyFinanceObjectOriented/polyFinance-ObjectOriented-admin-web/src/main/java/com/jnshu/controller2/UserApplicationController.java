package com.jnshu.controller2;

import com.jnshu.Domain2.DomainApplication;
import com.jnshu.dto2.ApplicationListRPO;
import com.jnshu.entity.RealNameApplication;
import com.jnshu.service.UserApplicationService;
import com.jnshu.service.UserService;
import com.jnshu.utils.CAM;
import com.jnshu.utils.TokenUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//实名认证
@RestController
public class UserApplicationController {

    private static Logger logger = Logger.getLogger(UserApplicationController.class);
    private TokenUtil tokenUtil = new TokenUtil();

    @Autowired
    UserApplicationService userApplicationService;
    @Autowired
    UserService userService;

    //实名列表
    @RequestMapping(value = "/a/u/applications")
    public Object getApplications(@RequestParam(defaultValue = "1") int pageNum,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @ModelAttribute ApplicationListRPO rpo,
                                  HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        List<Object> result = new ArrayList<>();

        if (null !=rpo.getCreateAt1() || null != rpo.getCreateAt2()){

            if (null ==rpo.getCreateAt1() || null == rpo.getCreateAt2()){
                cam.setCode(-1);
                cam.setMessage("通过日期查询，两个日期都要有值。");
                result.add(cam);
                return result;
            }
        }

        List<DomainApplication> userApplications = null;
        try {
            userApplications = userApplicationService.getAllUser(pageNum, pageSize,rpo);
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setMessage("服务器错误");
            cam.setErrorMessage("获取实名列表时出错。");
            logger.info("业务管理--实名认证管理--实名列表出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+rpo);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        //获取列表总数

        Integer total = null;
        try {
            total = userApplicationService.getCount();
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setMessage("服务器错误");
            cam.setErrorMessage("获取实名列表总数时出错。");
            logger.info("业务管理--实名认证管理--实名列表总数出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+rpo);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        result.add(cam);
        result.add(total);
        result.add(userApplications);
        if (null != rpo){
            result.remove(total);
        }
        logger.info("业务管理--实名认证管理--实名列表成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+rpo);
        return result;
    }

    //实名详情
    @RequestMapping(value = "/a/u/applications/{id}" ,method = RequestMethod.GET)
    public Object getApplicationInfo(@PathVariable long id,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        List<Object> result = new ArrayList<>();

        DomainApplication userApplication = null;
        try {
            userApplication = userApplicationService.getApplicationById(id);
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setMessage("服务器错误");
            cam.setErrorMessage("获取实名详情出错。");
            logger.info("业务管理--实名认证管理--实名详情出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        cam.setMessage("实名详情查询成功。");
        result.add(cam);
        result.add(userApplication);
        logger.info("业务管理--实名认证管理--实名列表。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id);

        return result;
    }

    //取消实名
    @RequestMapping(value = "/a/u/applications/{id}/cancel",method = RequestMethod.PUT)
    public Object handAppliStatus(@PathVariable Long id, @RequestParam Integer applicationStatus,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        List<Object> result = new ArrayList<>();

        //参数验证。
        if (null == applicationStatus || 3 != applicationStatus){
            cam.setCode(-1);
            cam.setMessage("applicationStatus错误");
            cam.setErrorMessage("非法参数。");
            result.add(cam);
            return result;
        }

        RealNameApplication realNameApplication = new RealNameApplication();
        realNameApplication.setId(id);
        realNameApplication.setApplicationStatus(applicationStatus);
        realNameApplication.setUpdateAt(System.currentTimeMillis());
        realNameApplication.setUpdateBy((Long) account.get("uid"));

        Boolean update = false;

        //业务处理。
        try {
            update = userApplicationService.cancelApplicationStatus(realNameApplication);
            if (update){
                CAM cam1 = new CAM(0,"取消实名成功。");
                result.add(cam1);
                logger.info("业务管理--实名认证管理--实名列表取消实名成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus);
            }else {
                CAM cam1 = new CAM(-1,"取消实名失败。原因：实名申请本身未认证。只有认证用户才可以取消实名。");
                result.add(cam1);
                return result;
            }
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setMessage("服务器错误");
            cam.setErrorMessage("取消实名出错。");
            logger.info("业务管理--实名认证管理--实名列表取消实名出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        //同时修改用户表对应id记录和对应银行卡表中对应记录。
        if (update){
            DomainApplication domainApplication =null;
            try {
                domainApplication = userApplicationService.getApplicationById(id);
            } catch (Exception e) {
                cam.setCode(-1);
                cam.setMessage("服务器错误");
                cam.setErrorMessage("取消实名时，获取用户记录时服务器出错。");
                logger.info("服务器错误。业务管理--实名认证管理--实名列表取消实名出错时，获取用户记录时服务器出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id);
                e.printStackTrace();
                result.add(cam);
                return result;
            }
            if (null == domainApplication){
                CAM cam1 = new CAM(-1,"拒绝实名申请后，获取实名信息出错。用户记录不存在。");
                cam1.setErrorMessage("拒绝实名申请后，获取实名信息出错。用户记录不存在。");
                result.add(cam1);
                return result;
            }

            //更新user表取消实名
            com.jnshu.entity.User user1 = new com.jnshu.entity.User();
            user1.setId(domainApplication.getUserId());
            user1.setRealStatus(0);
            user1.setUpdateBy((Long) account.get("uid"));
            user1.setUpdateAt(System.currentTimeMillis());

            Boolean cancelReal = false;
            try {
                System.out.println(user1);
                cancelReal = userService.updateUserFrontRealStatus(user1);
                if (cancelReal){
                    cam.setMessage("实名审核取消实名成功。");
                    result.add(cam);
                    logger.info("业务管理--实名认证管理--实名列表取消实名成功后更新用户表成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。");
                }else {
                    cam.setMessage("本身未实名或用户id已经不存在或。");
                    result.add(cam);
                }
            } catch (Exception e) {
                cam.setErrorMessage("服务器取消用户实名出错。");
                logger.info("服务器错误。业务管理--实名认证管理--实名列表取消实名成功后更新用户表失败。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。");
                e.printStackTrace();
                result.add(cam);
                return result;
            }

            //更新完user表后更新银行卡表。
            if (cancelReal){
                try {
                    Integer deleteCardNum = userService.deleteUserBankCard(user1.getId());
                    CAM cam1 = new CAM();
                    if (0 == deleteCardNum){
                        cam1.setMessage("当前用户没有银行卡。");
                    }else {
                        cam1.setMessage("删除"+deleteCardNum+"张银行卡。");
                        logger.info("业务管理--实名认证管理--实名列表取消实名成功后更新用户表成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。"+"并取消银行卡。");
                    }
                    result.add(cam1);
                } catch (Exception e) {
                    cam.setCode(-1);
                    cam.setMessage("服务器错误。");
                    cam.setErrorMessage("取消实名时，服务器删除id:"+id + "用户的银行卡时出错。");
                    logger.info("服务器错误。业务管理--实名认证管理--实名列表取消实名成功后更新用户表成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。"+"并取消银行卡。");
                    e.printStackTrace();
                    result.add(cam);
                    return result;
                }
            }
        }

        return result;
    }

    //审核申请并更新用户表。
    @RequestMapping(value = "/a/u/applications/{id}/verify",method = RequestMethod.PUT)
    public Object handAppli(@PathVariable Long id, @RequestParam Integer applicationStatus, @RequestParam(required = false) String refuseReason,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        List<Object> result = new ArrayList<>();

        if (null == id){
            cam.setCode(-1);
            cam.setMessage("非法参数.");
            cam.setErrorMessage("非法参数。");
            result.add(cam);
            return result;
        }

        if (2 != applicationStatus && 1 != applicationStatus){
            cam.setCode(-1);
            cam.setMessage("非法参数。");
            cam.setErrorMessage("非法参数。");
            result.add(cam);
            return result;
        }

        if (2 == applicationStatus && null == refuseReason){
            cam.setCode(-1);
            cam.setMessage("拒绝申请时，拒绝理由必填。");
            cam.setErrorMessage("拒绝申请时，拒绝理由必填。");
            result.add(cam);
            return result;
        }
        RealNameApplication realNameApplication = new RealNameApplication();
        realNameApplication.setId(id);
        realNameApplication.setUpdateBy((Long) account.get("uid"));
        realNameApplication.setUpdateAt(System.currentTimeMillis());
        realNameApplication.setApplicationStatus(applicationStatus);
        realNameApplication.setRefuseReason(refuseReason);


        //拒绝
        if (2 == applicationStatus && null != refuseReason){
            Boolean x = false;
            try {
                x = userApplicationService.reviewApplication(realNameApplication);
                if (x){
                    CAM cam1 = new CAM(0,"审核拒绝成功。");
                    result.add(cam1);
                    logger.info("业务管理--实名认证管理--实名列表拒绝实名申请成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);
                    return result;
                }else {
                    CAM cam1 = new CAM(-1,"审核拒绝失败。申请为“已认证等其他状态”。");
                    result.add(cam1);
                    return result;
                }
            } catch (Exception e) {
                cam.setCode(-1);
                cam.setMessage("服务器错误");
                cam.setErrorMessage("拒绝实名申请出错。");
                logger.info("业务管理--实名认证管理--实名列表拒绝实名申请出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);
                e.printStackTrace();
                result.add(cam);
                return result;
            }
        }

        //通过
        Boolean r= false;
        if (1 == applicationStatus && null == refuseReason){
            try {
                realNameApplication.setRefuseReason("");
                r = userApplicationService.reviewApplication(realNameApplication);
                if(r){
                    CAM cam1 = new CAM(0,"通过实名申请成功。");
                    result.add(cam1);
                    logger.info("业务管理--实名认证管理--实名列表拒绝实名申请成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);

                }else {
                    CAM cam1 = new CAM(-1,"通过实名申请失败。申请记录为”非申请状态“");
                    result.add(cam1);
                }
            } catch (Exception e) {
                cam.setCode(-1);
                cam.setMessage("服务器错误");
                cam.setErrorMessage("通过实名申请出错。");
                logger.info("业务管理--实名认证管理--实名列表通过实名申请出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);
                result.add(cam);
                return result;
            }
        }


        if (r){
            Boolean i = false;
            try {
                i = userApplicationService.updateUserFrontAfterApplication(id);
                if (i){
                    CAM cam1 = new CAM(0,"审核通过成功，并更新了user表实名信息。");
                    result.add(cam1);
                    logger.info("业务管理--实名认证管理--实名列表通过实名申请并更新user表实名信息记录成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);
                    return result;
                }else {
                    CAM cam1 = new CAM(-1,"审核通过成功，但更新user表实名信息失败。");
                    cam1.setErrorMessage("审核通过，更新uers表失败。当前用户记录状态非“未实名状态”。");
                    result.add(cam1);
                    return result;
                }
            } catch (Exception e) {
                CAM cam1 = new CAM(-1,"服务器错误。");
                cam1.setErrorMessage("审核通过成功。但更新user表时，服务器错误");
                result.add(cam1);
                logger.info("业务管理--实名认证管理--实名列表通过实名申请并更新user表实名信息记录。服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+id+", applicationStatus="+applicationStatus + ", refuseReason:"+refuseReason);
                return result;
            }
        }

        cam.setCode(-1);
        cam.setMessage("链接成功。参数错误");
        cam.setErrorMessage("参数错误。");
        return result;
    }

}