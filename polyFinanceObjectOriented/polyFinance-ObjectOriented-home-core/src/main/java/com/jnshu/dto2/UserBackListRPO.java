package com.jnshu.dto2;

public class UserBackListRPO {
    private Integer pageNum=1;
    private Integer pageSize=10;
    private String role;
    private String loginName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserBackListRPO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", role='" + role + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
