package com.jnshu.controller2;

import com.jnshu.entity.UserBack;
import com.jnshu.model.module.Module;
import com.jnshu.model.module.ModuleListInit;
import com.jnshu.model.module.ModuleProduce;
import com.jnshu.service.UserBackService;
import com.jnshu.utils.CAM;
import org.apache.catalina.Session;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserBackService userBackService;

    @RequestMapping(value = "/a/login",method = RequestMethod.POST)
    public Object loginBackEnd(@RequestParam String loginName, @RequestParam String hashKey, HttpServletRequest request, HttpServletResponse response){
        UserBack userBack = new UserBack();
        userBack.setLoginName(loginName);
        userBack.setHashKey(hashKey);

        if (0 ==userBack.getLoginName().length() || userBack.getHashKey().length() == 0){
            CAM cam = new CAM();
            cam.setErrorMessage("用户名或密码不能为空");
            return cam;
        }

        List<Object> result = new ArrayList<>();
        try {
            result =userBackService.verifyUserBack(userBack,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result;
    }

    @RequestMapping("/intercepted")
    public Map<String,Object> beIntercepted(HttpServletRequest request,@RequestParam(value = "next",required = false) String next){
        request.getSession().setAttribute("next", next);

        Map<String,Object> cAm = new HashMap<>();
        cAm.put("code", -1);
        cAm.put("errorMessage", "当前访问需要权限，请登录。");
        return cAm;
    }
}
