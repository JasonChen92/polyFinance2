package com.jnshu.model.module;

import java.util.ArrayList;
import java.util.List;

public class ListModule {
    private long id;
    private String moduleName;
    private List<Module> list = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<Module> getList() {
        return list;
    }

    public void setList(List<Module> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListModule{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", list=" + list +
                '}';
    }
}
