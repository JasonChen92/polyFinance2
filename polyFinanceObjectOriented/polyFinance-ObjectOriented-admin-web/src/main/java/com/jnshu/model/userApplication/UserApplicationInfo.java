package com.jnshu.model.userApplication;

public class UserApplicationInfo {
    private long id;
    private String userNumber;
    private long createAt;
    private String phoneNumber;
    private String realName;
    private String idCard;
    private String email;
    private int applicationStatus;
    private String refuseReason;
    private String frontCard;
    private String reverseCard;

    public UserApplicationInfo() {
    }

    public UserApplicationInfo(long id, String userNumber, long createAt, String phoneNumber, String realName, String idCard, String email, int applicationStatus, String refuseReason, String frontCard, String reverseCard) {
        this.id = id;
        this.userNumber = userNumber;
        this.createAt = createAt;
        this.phoneNumber = phoneNumber;
        this.realName = realName;
        this.idCard = idCard;
        this.email = email;
        this.applicationStatus = applicationStatus;
        this.refuseReason = refuseReason;
        this.frontCard = frontCard;
        this.reverseCard = reverseCard;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(int applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getFrontCard() {
        return frontCard;
    }

    public void setFrontCard(String frontCard) {
        this.frontCard = frontCard;
    }

    public String getReverseCard() {
        return reverseCard;
    }

    public void setReverseCard(String reverseCard) {
        this.reverseCard = reverseCard;
    }

    @Override
    public String toString() {
        return "UserApplicationInfo{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", applicationStatus=" + applicationStatus +
                ", refuseReason='" + refuseReason + '\'' +
                ", frontCard='" + frontCard + '\'' +
                ", reverseCard='" + reverseCard + '\'' +
                '}';
    }
}
