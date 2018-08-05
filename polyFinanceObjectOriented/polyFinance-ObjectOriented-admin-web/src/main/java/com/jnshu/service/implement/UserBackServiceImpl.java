package com.jnshu.service.implement;

import com.github.pagehelper.PageHelper;
import com.jnshu.Domain2.DomainModuleBackForLogin;
import com.jnshu.Domain2.DomainUserBack;
import com.jnshu.dao2.RoleBackMapper;
import com.jnshu.dao2.RoleModuleBackMapper;
import com.jnshu.dao2.UserBackMapper;
import com.jnshu.dto2.UserBackListRPO;
import com.jnshu.entity.RoleBack;
import com.jnshu.entity.UserBack;
import com.jnshu.service.UserBackService;
import com.jnshu.utils.CAM;
import com.jnshu.utils.TokenUtil;
import com.jnshu.utils.DESUtil;
import com.jnshu.utils.formodule.ModuleBackTree;
import com.jnshu.utils.formodule.ModuleBackTreeInit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

@Service
@Component
public class UserBackServiceImpl implements UserBackService {

    private static Logger logger = Logger.getLogger(UserBackServiceImpl.class);

    @Autowired
    UserBackMapper userBackMapper;
    @Autowired
    RoleBackMapper roleBackMapper;
    @Autowired
    RoleModuleBackMapper roleModuleBackMapper;

    @Override
    public List<Object> verifyUserBack(UserBack userBack, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Object> result = new ArrayList<>();
        Map<String,Object> v = new HashMap<>();
        CAM cam = new CAM();
        //通过用户名获得数据库中用户信息。
        UserBack userBackData =userBackMapper.getUserBackByLoginName(userBack.getLoginName());
        if (null == userBackData){
            cam.setCode(-1);
            cam.setMessage("账户不存在");
            result.add(cam);
            return result;
        }

        //判断密码是否正确。
        DESUtil desUtil = new DESUtil();
        String pw = userBackData.getHashKey();
        String enLoginPassword = desUtil.encrypt(userBack.getHashKey(), userBackData.getSalt());
        System.out.println(pw);
        System.out.println(enLoginPassword);

        if (pw.equals(enLoginPassword)){
            //获得角色名
            RoleBack role = roleBackMapper.getRoleByUserId(userBackData.getId());
            //获得模块权限。
            List<DomainModuleBackForLogin> moduleBacks = roleModuleBackMapper.getModuleOfRole(role.getId());
            List<ModuleBackTree> returnModules= new ModuleBackTreeInit().get(moduleBacks);

            cam.setCode(0);
            cam.setMessage("登录成功");
            v.put("uid", userBackData.getId());
            v.put("loginName", userBackData.getLoginName());
            v.put("role", role.getRole());

            result.add(cam);
            result.add(v);
            result.add(returnModules);

            //添加token和cookie
            TokenUtil tokenUtil = new TokenUtil();
            response.addHeader("token", tokenUtil.createToken(userBackData.getId(),userBackData.getLoginName(), role.getRole()));

            Cookie cookie= tokenUtil.createCookie(userBackData.getId());
            response.addCookie(cookie);

            String next = (String) request.getSession().getAttribute("next");
//

            logger.info("时间："+new Timestamp(new Date().getTime())+"。后台账户："+userBack.getLoginName()+", 管理角色："+role.getRole()+"。对应模块权限： "+"\n"+returnModules.toString());
            return result;
        }

        cam.setCode(-1);
        cam.setMessage("密码不正确。");
        result.add(cam);
        return result;
    }


    @Override
    public List<DomainUserBack> getUserBackList(UserBackListRPO rpo) throws Exception {
        PageHelper.startPage(rpo.getPageNum(), rpo.getPageSize());
        List<DomainUserBack> userBacks = userBackMapper.getUserBacksByNameAndRole(rpo);
        return userBacks;
    }

    @Override
    public Long saveUserBack(UserBack userBack) throws Exception {
        //新增账户，需要新增user_back,role_user_back,role_back三张表。
        Long createDate = System.currentTimeMillis();
        userBack.setCreateAt(createDate);
        userBack.setUpdateAt(createDate);
        //获得id作为createBy,updateBy

        //生成salt，并保存到userBack.salt中。

        //用salt加密userBack.getHashKey后再保存到userBack.hashKey中。

        //保存到数据库
        userBackMapper.saveUserBack(userBack);


        return userBack.getId();
    }
}
