package com.jnshu.model.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleProduce {

    
    //获得父模块
    public List<ListModule> getSuper(List<Module> list) {
        //返回结果
        List<ListModule> re = new ArrayList<ListModule>();

        List<Module> lists=list;
        for (Module module: lists){
            if (0 ==module.getSuperId()){
                //父模块对象
                ListModule superModule = new ListModule();
                superModule.setId(module.getId());
                superModule.setModuleName(module.getModuleName());
                re.add(superModule);
            }
        }
        System.out.println(re);
        //此时父模块已经添加到返回结果中。

        //将子模块添加到列表中。
        for (Module module : lists){
            if (module.getSuperId() !=0){
                for (ListModule listModule : re){
                    if (module.getSuperId() == listModule.getId()){
                        listModule.getList().add(module);
                    }
                }
            }
        }

        System.out.println(re);
        return re;
    }
}
