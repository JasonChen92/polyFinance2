package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融role_module_back表对应实体类
 */
public class RoleModuleBack implements Serializable {
    private static final long serialVersionUID = 3924841975726229879L;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private long roleId;
    private long moduleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(long updateBy) {
        this.updateBy = updateBy;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "RoleModuleBack{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }
}
