package com.jnshu.utils.formodule;

import com.jnshu.Domain2.DomainModuleBackForLogin;
import com.jnshu.entity.ModuleBack;

import java.util.ArrayList;
import java.util.List;

public class ModuleBackTreeInit {

    public List<ModuleBackTree> get(List<DomainModuleBackForLogin> list) {

        //返回结果。
        List<ModuleBackTree> trees = new ArrayList<>();

        for (DomainModuleBackForLogin moduleBack : list) {
            //先提前父模块，作为ModuleBackTree对象。
            if (0 == moduleBack.getSuperId()) {
                ModuleBackTree moduleBackTree = new ModuleBackTree();
                moduleBackTree.setId(moduleBack.getId());
                moduleBackTree.setModuleName(moduleBack.getModuleName());
                moduleBackTree.setSuperId(moduleBack.getSuperId());

                trees.add(moduleBackTree);
            }
        }

        //将子模块添加到父模块对象的subModuleList变量中。
        for (DomainModuleBackForLogin moduleBack : list){
            if (0 != moduleBack.getSuperId()) {
                for (ModuleBackTree tree : trees) {
                    if (moduleBack.getSuperId() == tree.getId()) {
                        tree.getSubModuleList().add(moduleBack);
                    }
                }
            }
        }

        return trees;
    }
}
