package com.jnshu.controller2;

import com.auth0.jwt.interfaces.Claim;
import com.jnshu.Domain2.DomainUserFront;
import com.jnshu.Domain2.DomainUserFrontDetail;
import com.jnshu.Domain2.UserBankCard;
import com.jnshu.dto2.UserFrontListRPO;
import com.jnshu.model.module.ListModule;
import com.jnshu.model.module.Module;
import com.jnshu.model.module.ModuleListInit;
import com.jnshu.model.module.ModuleProduce;
import com.jnshu.model.user.LoginBack;
import com.jnshu.model.user.User;
import com.jnshu.model.user.UserInfo;
import com.jnshu.service.UserService;
import com.jnshu.utils.CAM;
import com.jnshu.utils.TokenUtil;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class FrontUserController {

    private static Logger logger = Logger.getLogger(FrontUserController.class);

    private static TokenUtil tokenUtil = new TokenUtil();
    @Autowired
    UserService userService;

    /**
     * 用户管理
     */
    //用户列表
    @RequestMapping(value = "/a/u/users",method = RequestMethod.GET)
    public Object userList(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,
                           @ModelAttribute UserFrontListRPO userFrontListRPO,
                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        if (null !=userFrontListRPO.getCreateAt1() || null != userFrontListRPO.getCreateAt2()){

            if (null ==userFrontListRPO.getCreateAt1() || null == userFrontListRPO.getCreateAt2()){
                cam.setCode(-1);
                cam.setMessage("通过日期查询时，两个日期都要有值。");
                result.add(cam);
                return result;
            }
        }

        List<DomainUserFront> users = null;
        Integer total =null;

        try {
            users = userService.getAllUser(pageNum, pageSize,userFrontListRPO);
            total =userService.getCount();
            logger.info("后台 业务管理--用户列表。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+userFrontListRPO);
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setErrorMessage("获取用户列表失败。");
            logger.info("获取用户列表失败。账户id="+account.get("uid"));
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        Map<String,Integer> s = new HashMap<>();
        s.put("total", total);
        s.put("pageNum", pageNum);
        s.put("pageSize", pageSize);
        if (!userFrontListRPO.equals(null)){
            s.remove("total");
        }
        result.add(s);

        if (0 == users.size()){
            cam.setCode(-1);
            cam.setErrorMessage("没有符合条件记录。");
            result.add(cam);
            return result;
        }
        result.add(cam);
        result.add(users);
        return result;
    }

    //用户详情
    @RequestMapping(value = "/a/u/users/{id}",method = RequestMethod.GET)
    public Object userInfo(@PathVariable long id, HttpServletRequest request,HttpServletResponse response){
        CAM cam = new CAM();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);

        List<Object> result = new ArrayList<>();
        DomainUserFrontDetail user =null;
        try {
             user = userService.getUserFrontById(id);
            if (null == user){
                cam.setCode(-1);
                cam.setErrorMessage("id超出范围。");
                result.add(cam);
            }
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setErrorMessage("后端获取id="+id+", 时出错。请重试。");
            logger.info("用户详情。服务器获取id="+id+"详情出错错误。账户id="+account.get("uid")+", 被操作用户id="+id);
            e.printStackTrace();
            return result;
        }

        //获取银行卡
        List<UserBankCard> bankCards=null;
        try {
            bankCards = userService.getUserFrontBankCardsById(id);
            if (0 == bankCards.size()){
                cam.setMessage("该用户没有银行卡");
            }
            result.add(cam);
        } catch (Exception e) {
            cam.setErrorMessage("服务器获取id="+id+"银行卡出错错误");
            logger.info("用户详情。服务器获取id="+id+"银行卡出错错误。账户id="+account.get("uid")+", 被操作用户id="+id);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        result.add(user);
        result.add(bankCards);
        logger.info("后台 业务管理--用户详情。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id);
        return result;
    }

    //用户列表-冻结/解冻
    @RequestMapping(value = "/a/u/users/{id}/status",method = RequestMethod.PUT)
    public Object userStatus(@PathVariable BigDecimal id, @RequestParam Integer status,HttpServletRequest request,HttpServletResponse response){

        CAM cam = new CAM();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);
        List<Object> result = new ArrayList<>();

        //参数验证
        if (null == status){
            cam.setCode(-1);
            cam.setErrorMessage("status不能为空。");
            result.add(cam);
            return result;
        }

        if (0 != status && 1 !=status){
            cam.setCode(-1);
            cam.setErrorMessage("status值错误。");
            result.add(cam);
            return result;
        }

        //业务处理
        com.jnshu.entity.User user = new com.jnshu.entity.User();
        user.setId(id.longValue());
        user.setStatus(status);
        user.setUpdateBy((Long) account.get("uid"));
        user.setUpdateAt(System.currentTimeMillis());
        String sta = null;
        try {
            if (userService.updateUserStatus(user)){
                if (status ==0) {
                    cam.setMessage("解冻成功。");
                    sta = "解冻";
                }
                if (status ==1){
                    cam.setMessage("冻结成功。");
                    sta = "冻结";
                }
                result.add(cam);
            }else {
                cam.setCode(-1);
                cam.setErrorMessage("参数错误。");
            }
            logger.info("后台 业务管理--用户冻结-解冻。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数id= "+id+"，操作="+sta+"成功。");

            result.add(cam);
            return result;

        } catch (Exception e) {
            cam.setCode(-1);
            cam.setErrorMessage("服务器错误。");
            logger.info("用户详情--"+sta+"失败。服务器出错。账户id="+account.get("uid")+", 被操作用户id="+id);
            result.add(cam);
            e.printStackTrace();
            return result;
        }
    }

    //修改手机
    @RequestMapping(value = "/a/u/users/{id}/phone",method = RequestMethod.PUT)
    public Object userPhone(@PathVariable long id, @RequestParam String phoneNumber,HttpServletRequest request, HttpServletResponse response){
        CAM cam = new CAM();
        List<Object> result = new ArrayList<>();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);

        //参数验证。
        if (null == phoneNumber){
            cam.setCode(-1);
            cam.setErrorMessage("手机号不能为空。");
        }

        if (phoneNumber.matches("^(1[345789]d{9})")){
            cam.setCode(-1);
            cam.setErrorMessage("请正确填写手机号。");
        }

        //业务处理
        com.jnshu.entity.User user = new com.jnshu.entity.User();
        user.setId(id);
        user.setPhoneNumber(phoneNumber);
        user.setUpdateBy((Long) account.get("uid"));
        user.setUpdateAt(System.currentTimeMillis());

        try {
            if (userService.updateUserPhone(user)){
                cam.setMessage("修改成功。");
            }else {
                cam.setCode(-1);
                cam.setMessage("修改失败。");
                cam.setErrorMessage("手机号相同");
            }
        } catch (Exception e) {
            cam.setErrorMessage("服务器修改手机号出错。");
            e.printStackTrace();
            result.add(cam);
            logger.info("服务器修改手机号出错。账户id="+account.get("uid")+", 被操作用户id="+id);
            return result;
        }

        result.add(cam);
        logger.info("后台 业务管理--用户详情-修改手机。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。修改成功。请求参数id= "+id+"，phoneNumber="+phoneNumber +"，修改成功。");
        return result;
    }

    //修改理财经理
    @RequestMapping(value = "/a/u/users/{id}/referrer",method = RequestMethod.PUT)
    public Object userReferrer(@PathVariable long id, @RequestParam String referrerId,HttpServletRequest request, HttpServletResponse response){
        CAM cam = new CAM();
        List<Object> result = new ArrayList<>();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);

        //参数验证
        if (null == referrerId){
            cam.setCode(-1);
            cam.setErrorMessage("referrerId不能为空。");
            result.add(cam);
            return result;
        }

        //业务处理
        com.jnshu.entity.User user = new com.jnshu.entity.User();
        user.setId(id);
        user.setReferrerId(referrerId);
        user.setUpdateBy((Long) account.get("uid"));
        user.setUpdateAt(System.currentTimeMillis());

        try {
            if (userService.updateUserFrontReferrerId(user)){
                cam.setMessage("修改成功。");
            }else {
                cam.setCode(-1);
                cam.setErrorMessage("修改失败。理财经理工号相同。");
                return result;
            }
        } catch (Exception e) {
            cam.setErrorMessage("服务器修改理财经理出错。");
            logger.info("服务器修改理财经理出错。账户id="+account.get("uid")+", 被操作用户id="+id);
            e.printStackTrace();
        }
        result.add(cam);
        logger.info("后台 业务管理--用户详情-更换理财经理。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 的理财经理工号修改成功。");
        return result;
    }

    //取消实名
    @RequestMapping(value = "/a/u/users/{id}/realStatus",method = RequestMethod.PUT)
    public Object userRealStatus(@PathVariable long id, @RequestParam Integer realStatus,HttpServletRequest request, HttpServletResponse response){
        CAM cam = new CAM();
        List<Object> result = new ArrayList<>();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);

        //参数验证
        if (null == realStatus){
            cam.setCode(-1);
            cam.setErrorMessage("realStatus不能为空。");
            result.add(cam);
            return result;
        }

        if (0 != realStatus){
            cam.setCode(-1);
            cam.setErrorMessage("非法参数。滚蛋。");
            result.add(cam);
            return result;
        }

        //业务处理
        com.jnshu.entity.User user = new com.jnshu.entity.User();
        user.setId(id);
        user.setRealStatus(realStatus);
        user.setUpdateBy((Long) account.get("uid"));
        user.setUpdateAt(System.currentTimeMillis());

        Boolean cancelReal = false;
        try {
            System.out.println(user);
            System.out.println(userService);
            cancelReal = userService.updateUserFrontRealStatus(user);
            if (cancelReal){
                cam.setMessage("取消实名成功。");
                result.add(cam);
                logger.info("后台 业务管理--用户详情-取消实名。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。");
            }else {
                cam.setMessage("id不存在或者本身未实名。");
                result.add(cam);
            }
        } catch (Exception e) {
            cam.setErrorMessage("服务器取消用户实名出错。");
            logger.info("服务器取消用户实名出错。账户id="+account.get("uid")+", 被操作用户id="+id);
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        if (cancelReal){
            try {
                Integer deleteCardNum = userService.deleteUserBankCard(user.getId());
                CAM cam1 = new CAM();
                if (0 == deleteCardNum){
                    cam1.setMessage("当前用户没有银行卡。");
                }else {
                    cam1.setMessage("删除"+deleteCardNum+"张银行卡。");
                    logger.info("后台 业务管理--用户详情-取消实名。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。"+"用户id="+id+", 实名取消成功。"+"并取消银行卡。");
                }
                result.add(cam1);
            } catch (Exception e) {
                cam.setCode(-1);
                cam.setMessage("服务器错误。");
                cam.setErrorMessage("取消实名时，服务器删除id:"+id + "用户的银行卡时出错。");
                logger.info("取消实名时，服务器删除id:"+id + "用户的银行卡时出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。");
                e.printStackTrace();
                result.add(cam);
                return result;
            }
        }



        return result;
    }

    //解绑银行卡
    @RequestMapping(value = "/a/u/users/{id}/bankCard",method = RequestMethod.PUT)
    public Object userBankCard(@PathVariable long id,@RequestParam Long defaultCard , @RequestParam Long bankId,HttpServletRequest request, HttpServletResponse response){
        CAM cam = new CAM();
        List<Object> result = new ArrayList<>();
        Map<String, Object> account = new HashMap<>();
        account = tokenUtil.getAccount(request);

        //参数验证
        if (null == bankId){
            cam.setCode(-1);
            cam.setErrorMessage("bankId不能为空。");
            result.add(cam);
            return result;
        }

        //业务处理
        DomainUserFrontDetail user =null;
        try {
            user = userService.getUserFrontById(id);
            if (null == user){
                cam.setCode(-1);
                cam.setMessage("id错误");
                cam.setErrorMessage("没有当前用户。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            cam.setCode(-1);
            cam.setMessage("服务器错误。");
            cam.setErrorMessage("解绑银行卡时，服务器获取用户id为："+id + "信息时出错。");
            logger.info("解绑银行卡时，服务器删除id:"+id + "用户的银行卡时出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。");
            e.printStackTrace();
            result.add(cam);
            return result;
        }

        if (defaultCard != user.getDefaultCard()){
            cam.setCode(-1);
            cam.setMessage("defaultCard错误");
            cam.setErrorMessage("非当前用户默认银行卡。");
            result.add(cam);
            return result;
        }

        //获取银行卡
        List<UserBankCard> bankCards=null;
        try {
            bankCards = userService.getUserFrontBankCardsById(id);
            if (0 == bankCards.size()){
                cam.setCode(-1);
                cam.setMessage("该用户没有绑定银行卡。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            cam.setErrorMessage("服务器获取id="+id+"银行卡出错错误");
            logger.info("解绑银行卡。服务器获取id="+id+"银行卡出错错误。账户id="+account.get("uid")+", 被操作用户id="+id);
            e.printStackTrace();
            result.add(cam);
            return result;
        }


        //新的默认银行卡id。
        Long newDefaultBankCardId = null;
        for (UserBankCard card : bankCards){
            if (bankId != card.getCardId()){
                newDefaultBankCardId = card.getCardId();
            }
        }
        System.out.println("newDefaultBankCardId："+newDefaultBankCardId);
        Boolean up = false;
        try {
            up = userService.untiedUserBankCard(id, bankId);
            System.out.println(up);
            if (!up){
                cam.setCode(-1);
                cam.setMessage("解绑失败");
                cam.setErrorMessage("银行卡或许已经不存。");
                result.add(cam);
                return result;
            }else {
                CAM cam2 = new CAM();
                cam2.setCode(0);
                cam2.setMessage("解绑成功");
                result.add(cam2);
                logger.info("解绑银行卡成功。用户id="+id+"，的银行卡id="+bankId+"被当前账户id="+account.get("uid")+"，登录名="+account.get("loginName")+", 角色为："+account.get("role")+"，的后台账户解绑。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            cam.setCode(-1);
            cam.setMessage("服务器错误。");
            cam.setErrorMessage("解绑银行卡时服务器发生错误。");
            logger.info("解绑银行卡时，服务器删除id:"+id + "用户的银行卡时出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。");
            result.add(cam);

        }

        if (null != newDefaultBankCardId && bankId ==user.getDefaultCard()){
            com.jnshu.entity.User user1 = new com.jnshu.entity.User();
            user1.setUpdateBy((Long) account.get("uid"));
            user1.setUpdateAt(System.currentTimeMillis());
            user1.setId(id);
            user1.setDefaultCard(newDefaultBankCardId);
            try {
                if (userService.updateUserDefaultBankCard(user1)){
                    cam.setCode(0);
                    cam.setMessage("解绑后更新默认银行卡成功。");
                    result.add(cam);
                    logger.info("解绑后更新默认银行卡成功。用户id="+id+"，的银行卡id="+bankId+"被当前账户id="+account.get("uid")+"，登录名="+account.get("loginName")+", 角色为："+account.get("role")+"，的后台账户解绑。并成功更新默认银行卡。");
                }
            } catch (Exception e) {
                CAM cam1 = new CAM();
                cam1.setCode(-1);
                cam1.setMessage("服务器错误。");
                cam1.setErrorMessage("解绑银行卡后更新默认银行卡时服务器发生错误。");
                logger.info("解绑银行卡后更新默认银行卡时，服务器更新默认银行卡id:"+id + "时出错。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。");
                result.add(cam1);
            }
        }

        return result;
    }
}
