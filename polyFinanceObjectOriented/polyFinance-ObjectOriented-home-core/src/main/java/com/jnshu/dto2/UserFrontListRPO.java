package com.jnshu.dto2;

public class UserFrontListRPO {
    private String phoneNumber;
    private String realName;
    private Long createAt1;
    private Long createAt2;
    private String referrerId;
    private Integer status;

    public UserFrontListRPO() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getCreateAt1() {
        return createAt1;
    }

    public void setCreateAt1(Long createAt1) {
        this.createAt1 = createAt1;
    }

    public Long getCreateAt2() {
        return createAt2;
    }

    public void setCreateAt2(Long createAt2) {
        this.createAt2 = createAt2;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserFrontListRPO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", createAt1=" + createAt1 +
                ", createAt2=" + createAt2 +
                ", referrerId='" + referrerId + '\'' +
                ", status=" + status +
                '}';
    }
}
