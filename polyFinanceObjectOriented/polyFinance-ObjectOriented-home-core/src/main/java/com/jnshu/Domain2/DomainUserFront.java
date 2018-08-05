package com.jnshu.Domain2;

public class DomainUserFront {
    private Long id;
    private String userNumber;
    private Long createAt;
    private String phoneNumber;
    private String referrerId;
    private Integer realStatus;
    private String realName;
    private String property;
    private String cumulativeIncome;
    private Integer status;

    public DomainUserFront() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public Integer getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(Integer realStatus) {
        this.realStatus = realStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCumulativeIncome() {
        return cumulativeIncome;
    }

    public void setCumulativeIncome(String cumulativeIncome) {
        this.cumulativeIncome = cumulativeIncome;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DomainUserFront{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", referrerId='" + referrerId + '\'' +
                ", realStatus=" + realStatus +
                ", realName='" + realName + '\'' +
                ", property='" + property + '\'' +
                ", cumulativeIncome='" + cumulativeIncome + '\'' +
                ", status=" + status +
                '}' + "\n";
    }
}