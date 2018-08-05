package com.jnshu.controller2;

import com.jnshu.Domain2.DomainContent;
import com.jnshu.dto2.ContentListRPO;
import com.jnshu.model.content.Content;
import com.jnshu.model.content.ContentInfo;
import com.jnshu.service.ContentService;
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

@RestController
public class ContentController {
    private static Logger logger = Logger.getLogger(ContentController.class);

    private static TokenUtil tokenUtil = new TokenUtil();
    @Autowired
    ContentService contentService;

    //内容列表
    @RequestMapping(value = "/a/u/contents",method = RequestMethod.GET)
    public Object getContents(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @ModelAttribute ContentListRPO contentListRPO,
                              HttpServletRequest request,
                              HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        if (null !=contentListRPO.getUpdateAt1() || null != contentListRPO.getUpdateAt2()){

            if (null ==contentListRPO.getUpdateAt1() || null == contentListRPO.getUpdateAt2()){
                cam.setCode(-1);
                cam.setMessage("通过日期查询时，两个日期都要有值。");
                result.add(cam);
                return result;
            }
        }

        if (null != contentListRPO.getType()){
            if (contentListRPO.getType() != 0 && 1 != contentListRPO.getType() && 2 != contentListRPO.getType()){
                CAM cam1 = new CAM(-1, "类型为非法参数。");
                result.add(cam1);
                return result;
            }
        }

        if (null != contentListRPO.getStatus()){
            if (0 != contentListRPO.getStatus() && 1 != contentListRPO.getStatus()){
                CAM cam1 = new CAM(-1,"状态为非法参数。");
                result.add(cam1);
                return result;
            }
        }

        List<DomainContent> contents = null;
        try {
            contents = contentService.getContentList(pageNum,pageSize,contentListRPO);
            if (null == contents){
                CAM cam1 = new CAM(-1,"当前条件无符合条件记录。");
                cam1.setErrorMessage("换条件试试。");
                result.add(cam1);
                return result;
            }
            logger.info("后台 运营管理--内容列表查询成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求id参数： "+contentListRPO);
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("查询内容列表时服务器错误。");
            logger.info("后台 运营管理--内容列表查询服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+contentListRPO);
            result.add(cam1);
            return result;
        }

        //查询总数。
        Integer total = null;
        try {
            total = contentService.getCount();
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("查询内容列表总数时服务器错误。");
            logger.info("后台 运营管理--内容列表查询-记录总数时-服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+contentListRPO);
            result.add(cam1);
            return result;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("total", total);
        result.add(map);

        cam.setMessage("查询成功。total为全部内容数。与条件查询无关。");
        result.add(cam);
        result.add(contents);

        return result;
    }

    //获得内容详情
    @RequestMapping(value = "/a/u/contents/{id}",method = RequestMethod.GET)
    public List<Object> getInfo(@PathVariable Long id,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数验证。
        if(null == id || id < 1){
            cam.setCode(-1);
            cam.setErrorMessage("id不能为空或小于1.");
            result.add(cam);
            return result;
        }

        com.jnshu.entity.Content content = null;
        try {
            content = contentService.getContentById(id);
            if (null == content){
                CAM cam1 = new CAM(-1,"没有此id记录。");
                result.add(cam1);
                return result;
            }
            logger.info("后台 运营管理--内容详情查询成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id);
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("查询内容详情时服务器错误。");
            logger.info("后台 运营管理--内容详情--服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id);
            result.add(cam1);
            return result;
        }

        cam.setMessage("查询成功。");
        result.add(cam);
        result.add(content);
        return result;
    }

    //保存内容编辑
    @RequestMapping(value = "/a/u/contents/{id}",method = RequestMethod.PUT)
    public List<Object> updateInfo(@PathVariable Long id,
                                   @RequestParam String title,
                                   @RequestParam Integer type,
                                   @RequestParam(required = false) String bannerCover,
                                   @RequestParam(required = false) String detail,
                                   @RequestParam Integer status,
                                   HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数验证。
        if (null == id || id < 1){
            cam.setCode(-1);
            cam.setErrorMessage("id不能为空或小于1。");
            result.add(cam);
            return result;
        }

        //type不能为空，或者时0，1，2之外的数字
        if (null == type || 0 != type && 1 != type && 2 != type){
            cam.setCode(-1);
            cam.setErrorMessage("type参数错误。");
            result.add(cam);
            return result;
        }

        //status不能为空，或者是0，1之外的数字
        if (null == status || 0 != status && 1 != status){
            cam.setCode(-1);
            cam.setErrorMessage("status参数错误。");
            result.add(cam);
            return result;
        }

        //当type=0时，bannerCover不能没有或者没有值。
        if(0 == type){
            if (null == bannerCover ||  "".equals(bannerCover)){
                cam.setCode(-1);
                cam.setErrorMessage("类型为 推荐 时，bannerCover不能为空。");
                result.add(cam);
                return result;
            }
        }

        //当type为1或2时，detail不能为没有或者没有值。同时也不需要bannerCover。
        if(type == 1 || 2 == type){
            if (null == detail || detail.equals("")){
                cam.setCode(-1);
                cam.setErrorMessage("类型为”帮助中心“或”关于我们“时，内容不能为空。");
                result.add(cam);
                return result;
            }

            if (null != bannerCover){
                cam.setCode(-1);
                cam.setErrorMessage("类型为”帮助中心“或”关于我们“时，没有封面banner。");
                result.add(cam);
                return result;
            }
        }
        com.jnshu.entity.Content content = new com.jnshu.entity.Content();
        content.setId(id);
        content.setUpdateAt(System.currentTimeMillis());
        content.setUpdateBy((Long) account.get("uid"));
        content.setTitle(title);
        content.setType(type);
        content.setBannerCover(bannerCover);
        content.setDetails(detail);
        content.setStatus(status);

        Boolean x = false;
        try {
            x = contentService.updateContentById(content);
            if (!x){
                cam.setCode(-1);
                cam.setErrorMessage("id 不存在。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("更新内容详情时服务器错误。");
            logger.info("后台 运营管理--内容详情-更新--服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id+", title:"+title+ ", type:"+type +", bannerCover:"+bannerCover+ ", detail:"+ detail+ ", status:"+status);
            result.add(cam1);
            return result;
        }
        cam.setMessage("更新成功。");
        result.add(cam);
        logger.info("后台 运营管理--内容详情-更新成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+id+", title:"+title+ ", type:"+type +", bannerCover:"+bannerCover+ ", detail:"+ detail+ ", status:"+status);
        return result;
    }

    //新增内容
    @RequestMapping(value = "/a/u/contents/new",method = RequestMethod.POST)
        public List<Object> saveInfo(@RequestParam String title,
                                 @RequestParam Integer type,
                                 @RequestParam(required = false) String bannerCover,
                                 @RequestParam(required = false) String detail,
                                 @RequestParam Integer status,
                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数验证。
        //type不能没有，而且只能时0，1，2之中的一个。
        if (null == type ||0 != type && 1 != type && 2 != type){
            cam.setCode(-1);
            cam.setErrorMessage("type参数错误.");
            result.add(cam);
            return result;
        }

        //status不能没有，而且必须时0或1.
        if (null == status || 0 != status && 1 != status){
            cam.setCode(-1);
            cam.setErrorMessage("status参数错误.");
            result.add(cam);
            return result;
        }

        //当type为0时，不能没有bannerCover也不能无值。
        if(0 == type){
            if (null == bannerCover ||  "".equals(bannerCover)){
                cam.setCode(-1);
                cam.setErrorMessage("类型为推荐 时，bannerCover不能为空。");
                result.add(cam);
                return result;
            }
        }

        //当type等于1或2时，detail不能没有或者无值，同时不需要bannerCover。
        if(type == 1 || 2 == type){
            if (null == detail || detail.equals("")){
                cam.setCode(-1);
                cam.setErrorMessage("类型为”帮助中心“ 或”关于我们“时，内容不能为空。");
                result.add(cam);
                return result;
            }

            if (null != bannerCover){
                cam.setCode(-1);
                cam.setErrorMessage("类型为”帮助中心“ 或”关于我们“时，没有封面banner。");
                result.add(cam);
                return result;
            }
        }

        //查重
        Long existId = null;
        try {
            existId = contentService.getContentIdByTitle(title);
            if (null != existId){
                cam.setCode(-1);
                cam.setErrorMessage("title重复错误。删除之前的或者换个title。");
                result.add(cam);
                return result;
            }
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("新增内容查询是否已经有重复title时服务器错误。");
            logger.info("后台 运营管理--新增内容-查询是否已经有重复title时-服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+", title:"+title+ ", type:"+type +", bannerCover:"+bannerCover+ ", detail:"+ detail+ ", status:"+status);
            result.add(cam1);
            return result;
        }
        com.jnshu.entity.Content content = new com.jnshu.entity.Content();
        content.setCreateAt(System.currentTimeMillis());
        content.setCreateBy((Long) account.get("uid"));
        content.setUpdateAt(System.currentTimeMillis());
        content.setUpdateBy((Long) account.get("uid"));
        content.setTitle(title);
        content.setType(type);
        content.setBannerCover(bannerCover);
        content.setDetails(detail);
        content.setStatus(status);

        //新增
        try {
            contentService.saveContent(content);
            if (content.getId() == null || content.getId() <= 1){
                CAM cam1 = new CAM(-1,"新增失败。");
                result.add(cam1);
                return result;
            }
            logger.info("后台 运营管理--新增内容成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+", title:"+title+ ", type:"+type +", bannerCover:"+bannerCover+ ", detail:"+ detail+ ", status:"+status);
            cam.setMessage("新增成功。");
            result.add(cam);
            return result;
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("新增内容时服务器错误。");
            logger.info("后台 运营管理--新增内容--服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数： "+", title:"+title+ ", type:"+type +", bannerCover:"+bannerCover+ ", detail:"+ detail+ ", status:"+status);
            result.add(cam1);
            return result;
        }
    }

    //指定内容上下线操作
    @RequestMapping(value = "/a/u/contents/{id}/status",method = RequestMethod.PUT)
    public List<Object> updateContentStatus(@PathVariable Long id,
                                            @RequestParam Integer status,
                                            HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数验证。
        //id不能没有值，也不能小于1。
        if (null == id || 1 > id){
            cam.setCode(-1);
            cam.setErrorMessage("非法参数。");
            result.add(cam);
            return result;
        }

        //status不能没有值，同时不能是0和1之外的值。
        if (null == status ||0 != status && 1 != status){
            cam.setCode(-1);
            cam.setErrorMessage("status非法参数。");
            result.add(cam);
            return result;
        }

        com.jnshu.entity.Content content = new com.jnshu.entity.Content();
        content.setId(id);
        content.setUpdateAt(System.currentTimeMillis());
        content.setUpdateBy((Long) account.get("uid"));
        content.setStatus(status);
        Boolean up= false;
        try {
            up = contentService.updateContentStatusById(content);
            if (!up){
                cam.setCode(-1);
                cam.setErrorMessage("检查id是否正确。或者当前内容状态与要更新的状态相同。");
                result.add(cam);
                return result;
            }

            if (0 == status){
                cam.setCode(0);
                cam.setMessage("下线成功。");
                logger.info("后台 运营管理--下线内容成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数id： "+id+ ", status:"+status);
            }
            if (1 == status){
                cam.setCode(0);
                cam.setMessage("上线成功。");
                logger.info("后台 运营管理--上线内容成功。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数id： "+id+ ", status:"+status);
            }
            result.add(cam);
            return result;
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("上下线内容时服务器错误。");
            logger.info("后台 运营管理--上下线内容--服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数id： "+id+ ", status:"+status);
            result.add(cam1);
            return result;
        }
    }

    //删除指定内容
    @RequestMapping(value = "/a/u/contents/{id}",method = RequestMethod.DELETE)
    public List<Object> deleteContent(@PathVariable Long id,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> account = new HashMap<>();
        CAM cam = new CAM();
        account = tokenUtil.getAccount(request);

        //返回数据List。
        List<Object> result = new ArrayList<>();

        //参数验证。
        if (0 >= id){
            cam.setCode(-1);
            cam.setErrorMessage("非法参数.");
            result.add(cam);
            return result;
        }

        System.out.println("************");
        System.out.println(id);
        Boolean del = false;
        try {
            del = contentService.deleteContentById(id);
            System.out.println(del);
            if (!del){
                cam.setCode(-1);
                cam.setMessage("删除内容失败。");
                cam.setErrorMessage("删除失败，检查id。");
                result.add(cam);
                return result;
            }
            cam.setCode(0);
            cam.setMessage("删除内容成功。");
            result.add(cam);
            return result;
        } catch (Exception e) {
            CAM cam1 = new CAM(-1,"服务器错误。");
            cam1.setErrorMessage("删除内容时服务器错误。");
            logger.info("后台 运营管理--删除内容--服务器错误。当前账户id："+account.get("uid")+"，账户名："+account.get("loginName")+"，后台角色："+account.get("role")+"。请求参数id： "+id);
            result.add(cam1);
            return result;
        }
    }
}