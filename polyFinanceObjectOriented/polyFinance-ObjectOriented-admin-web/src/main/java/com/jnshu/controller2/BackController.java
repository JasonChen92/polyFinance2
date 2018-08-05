package com.jnshu.controller2;

import com.jnshu.utils.CAM;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//后台管理
@RestController
public class BackController {

    private CAM cam = new CAM();
    @RequestMapping(value = "/a/u/managers",method = RequestMethod.GET)
    public List<Object> getManagers(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String loginName){
        List<Object> result = new ArrayList<>();
        List<Object> feedbackInfos = new ArrayList<>();
        for (int i=1;i<pageSize;i++){
            Map<String,Object> feedback = new HashMap<>();
            feedback.put("id",(long) i);
            feedback.put("loginName","科比" );
            feedback.put("role","超级管理员" );
            feedback.put("loginName2", "admin");
            feedback.put("createAt",System.currentTimeMillis() );
            feedback.put("loginName3", "user3");
            feedback.put("updateAt", System.currentTimeMillis()+1045604500);
            feedbackInfos.add(feedback);
        }
        result.add(cam);
        Map<String,Integer> t= new HashMap<>();
        t.put("total", 200);
        result.add(feedbackInfos);
        result.add("账户列表  接收到的数据：pageNum="
                +pageNum+", pageSize="
                +pageSize+", role="+role
                + ", loginName="+loginName);
        return result;
    }

    //账户列表-详情
    @RequestMapping(value = "/a/u/managers/{id}",method = RequestMethod.GET)
    public List<Object> getManager(
            @PathVariable long id){
        List<Object> result = new ArrayList<>();

        Map<String,Object> feedbackInfo = new HashMap<>();
        feedbackInfo.put("id",id);
        feedbackInfo.put("loginName","科比" );
        feedbackInfo.put("phoneNumber", "13145656756");
        feedbackInfo.put("hashKey","2423423");
        feedbackInfo.put("role","超级管理员" );

        result.add(cam);
        result.add(feedbackInfo);
        return result;
    }

    //账户列表-更新
    @RequestMapping(value = "/a/u/managers/{id}",method = RequestMethod.PUT)
    public List<Object> updateManager(
            @PathVariable Long id,
            @RequestParam String hashKey){
        List<Object> result = new ArrayList<>();


        result.add(cam);
        result.add("账户更新  接收到的数据：id="+
                id+", hashKey="+hashKey);
        return result;
    }

    //账户列表-删除
    @RequestMapping(value = "/a/u/managers/{id}",method = RequestMethod.DELETE)
    public List<Object> deleteManager(
            @PathVariable Long id,
            @RequestParam String hashKey){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        result.add("账户删除  接收到的数据：id="+
                id);
        return result;
    }
    //账户新增
    @RequestMapping(value = "/a/u/managers/new"
            , method = RequestMethod.POST)
    public List<Object> saveManager(
            @RequestParam String loginName,
            @RequestParam String phoneNumber,
            @RequestParam String hashKey,
            @RequestParam String role){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        result.add("账户新增  接收到的数据：loginName="+
                loginName+", phoneNumber="
                +phoneNumber+", hashKey="
                +hashKey+", role="+role);
        return result;
    }

    //角色管理-角色列表
    @RequestMapping(value = "/a/u/roles",method = RequestMethod.GET)
    public List<Object> getRoles(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        List<Object> result = new ArrayList<>();
        List<Map> roles = new ArrayList<>();
        for (int i=1;i<pageSize;i++){
            Map<String,Object> role = new HashMap<>();
            role.put("id", i);
            role.put("role", "管理员");
            role.put("loginName", "admin");
            role.put("createAt",System.currentTimeMillis() );
            role.put("loginName2", "user2");
            role.put("updateAt", System.currentTimeMillis()+100*i*6+10000*i*3);
            roles.add(role);
        }
        result.add(cam);
        Map<String,Integer> t= new HashMap<>();
        t.put("total", 200);
        result.add(roles);
        return result;
    }

    //角色管理-详情
    @RequestMapping(value = "/a/u/roles/{id}",method = RequestMethod.GET)
    public List<Object> getRole(@PathVariable Long id){
        List<Object> result = new ArrayList<>();
        Map<String,Object> role = new HashMap<>();
        role.put("id", id);
        role.put("role", "管理员");
        List<Long> idlist = new ArrayList<>();
        idlist.add(12L);
        idlist.add(13L);
        idlist.add(17L);
        idlist.add(42L);
        idlist.add(15L);
        idlist.add(132L);
        idlist.add(52L);
        idlist.add(32L);
        role.put("data",idlist);

        result.add(cam);
        result.add(role);
        return result;
    }

    //角色管理-新增
    @RequestMapping(value = "/a/u/roles/new",method = RequestMethod.POST)
    public List<Object> saveRole(@PathVariable Long id, @RequestParam String str){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }

    //角色管理-更新
    @RequestMapping(value = "/a/u/roles/{id}",method = RequestMethod.PUT)
    public List<Object> updateRole(@PathVariable Long id, @RequestParam String str){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }

    //角色管理-删除
    @RequestMapping(value = "/a/u/roles/{id}",method = RequestMethod.DELETE)
    public List<Object> deleteRole(@PathVariable Long id){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }



    //模块管理-模块列表
    @RequestMapping(value = "/a/u/modules",method = RequestMethod.GET)
    public List<Object> getModules(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        List<Object> result = new ArrayList<>();
        List<Map> modules = new ArrayList<>();
        for (int s=1;s<pageSize;s++){
            Map<String,Object> module = new HashMap<>();
            module.put("id", s);
            module.put("moduleName", "用户管理");
            module.put("moduleUrl", "www.d");
            module.put("superId", s+8);
            module.put("moduleType", "WEB");
            module.put("updateAt", System.currentTimeMillis());
            module.put("id2", 3);
            module.put("createAt",System.currentTimeMillis() );
            module.put("id3", 9);
            modules.add(module);
        }
        result.add(cam);
        Map<String,Integer> t= new HashMap<>();
        t.put("total", 200);
        result.add(modules);
        return result;
    }

    //模块管理-模块详情
    @RequestMapping(value = "/a/u/modules/{id}",method = RequestMethod.GET)
    public List<Object> getModule(@PathVariable Long id){
        List<Object> result = new ArrayList<>();
            Map<String,Object> module = new HashMap<>();
            module.put("id", id);
            module.put("moduleName", "用户管理");
            module.put("moduleUrl", "www.d");
            module.put("superId", id+8);
            module.put("moduleType", "WEB");
            module.put("updateAt", System.currentTimeMillis());
            module.put("id2", 3);
            module.put("createAt",System.currentTimeMillis() );
            module.put("id3", 9);
        result.add(cam);
        result.add(module);
        return result;
    }

    //模块管理-模块更新
    @RequestMapping(value = "/a/u/modules/{id}",method = RequestMethod.PUT)
    public List<Object> updateModule(@PathVariable Long id){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }

    //模块管理-模块删除
    @RequestMapping(value = "/a/u/modules/{id}",method = RequestMethod.DELETE)
    public List<Object> deleteModule(@PathVariable Long id){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }

    //模块管理-模块新增
    @RequestMapping(value = "/a/u/modules/new",method = RequestMethod.POST)
    public List<Object> saveModule(
            @RequestParam(required = false) String moduleName,
            @RequestParam(required = false) String menuId,
            @RequestParam(required = false) String moduleUrl,
            @RequestParam(required = false) String superId,
            @RequestParam(required = false) String moduleType
    ){
        List<Object> result = new ArrayList<>();
        result.add(cam);
        return result;
    }
}
