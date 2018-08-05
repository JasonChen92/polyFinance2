package com.jnshu.model.user;

public class LoginBack {
    private String loginName;
    private String role;

    public LoginBack() {
    }

    public LoginBack(String loginName, String role) {
        this.loginName = loginName;
        this.role = role;
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
}
