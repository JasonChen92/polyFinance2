package com.jnshu.utils.formodule;

import com.jnshu.Domain2.DomainModuleBackForLogin;
import com.jnshu.entity.ModuleBack;

import java.util.ArrayList;
import java.util.List;

public class ModuleBackTree {
    private Long id;
    private String moduleName;
    private Long superId;
    private List<DomainModuleBackForLogin> subModuleList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public List<DomainModuleBackForLogin> getSubModuleList() {
        return subModuleList;
    }

    public void setSubModuleList(List<DomainModuleBackForLogin> subModuleList) {
        this.subModuleList = subModuleList;
    }

    @Override
    public String toString() {
        return "ModuleBackTree{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", superId=" + superId +
                ", subModuleList=" + subModuleList +
                '}';
    }
}
