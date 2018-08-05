package com.jnshu.model.module;

public class Module {
    private long id;
    private String moduleName;
    private long superId;

    public Module() {
    }

    public Module(long id, String moduleName, long superId) {
        this.id = id;
        this.moduleName = moduleName;
        this.superId = superId;
    }

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

    public long getSuperId() {
        return superId;
    }

    public void setSuperId(long superId) {
        this.superId = superId;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", superId=" + superId +
                '}';
    }
}
