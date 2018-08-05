package com.jnshu.Domain2;

public class DomainModuleBack {
    private Long id;
    private Long createAt;
    private String crateBy;
    private Long updateAt;
    private String updateBy;
    private String moduleName;
    private Long superId;
    private String moduleType;
    private String moduleUrl;
    private String menuId;

    public DomainModuleBack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getCrateBy() {
        return crateBy;
    }

    public void setCrateBy(String crateBy) {
        this.crateBy = crateBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "DomainModuleBack{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", crateBy='" + crateBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", superId=" + superId +
                ", moduleType='" + moduleType + '\'' +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}
