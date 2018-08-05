package com.jnshu.model.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleListInit {
    public List<Module> init(){
        List<Module> list = new ArrayList<>();
        Module module1 = new Module(1,"业务管理",0);
        Module module2 = new Module(2,"用户管理",1);
        Module module3 = new Module(10,"实名认证",1);
        Module module12 = new Module(11,"产品管理",1);
        Module module13 = new Module(13,"债权管理",1);

        Module module5 = new Module(3,"运营管理",0);
        Module module4 = new Module(21,"内容管理",3);
        Module module14 = new Module(14,"消息管理",3);
        Module module6 = new Module(12,"银行管理",3);
        Module module15 = new Module(15,"参数管理",3);
        Module module16 = new Module(16,"版本管理",3);
        Module module7 = new Module(6,"意见反馈",3);

        Module module8 = new Module(9,"后台管理",0);
        Module module17 = new Module(17,"账户管理",9);
        Module module18 = new Module(18,"修改密码",9);
        Module module19 = new Module(19,"角色管理",9);
        Module module9 = new Module(8,"模块管理",9);
        Module module11 = new Module(23,"统计模块",0);
        Module module20 = new Module(24,"销量统计",23);
        Module module21 = new Module(25,"查看明细",23);

        list.add(module1);
        list.add(module2);
        list.add(module3);
        list.add(module4);
        list.add(module5);
        list.add(module6);
        list.add(module7);
        list.add(module8);
        list.add(module9);
        list.add(module11);
        list.add(module12);
        list.add(module13);
        list.add(module14);
        list.add(module15);
        list.add(module16);
        list.add(module17);
        list.add(module18);
        list.add(module19);
        list.add(module20);
        list.add(module21);
        return list;
    }
}
