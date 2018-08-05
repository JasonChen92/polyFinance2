package com.jnshu.model.user;

public class User {
    private long id;
    private String userNumber;
    private long createAt;
    private String phoneNumber;
    private String referrerId;
    private int realStatus;
    private String realName;
    private String idCard;
    private String property;
    private String cumulativeIncome;
    private Integer status;

    public User() {
    }

    public User(long id, String userNumber, long createAt, String phoneNumber, String referrerId, int realStatus, String realName, String idCard, String property, String cumulativeIncome, Integer status) {
        this.id = id;
        this.userNumber = userNumber;
        this.createAt = createAt;
        this.phoneNumber = phoneNumber;
        this.referrerId = referrerId;
        this.realStatus = realStatus;
        this.realName = realName;
        this.idCard = idCard;
        this.property = property;
        this.cumulativeIncome = cumulativeIncome;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
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

    public int getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(Short realStatus) {
        this.realStatus = realStatus;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", referrerId='" + referrerId + '\'' +
                ", realStatus=" + realStatus +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", property='" + property + '\'' +
                ", cumulativeIncome='" + cumulativeIncome + '\'' +
                ", status=" + status +
                '}';
    }
}
