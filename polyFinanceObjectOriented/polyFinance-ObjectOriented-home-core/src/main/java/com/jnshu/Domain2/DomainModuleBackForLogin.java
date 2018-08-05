package com.jnshu.Domain2;

public class DomainModuleBackForLogin {
    private Long id;
    private String moduleName;
    private Long superId;

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

    @Override
    public String toString() {
        return "DomainModuleBackForLogin{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", superId=" + superId +
                '}';
    }
}
