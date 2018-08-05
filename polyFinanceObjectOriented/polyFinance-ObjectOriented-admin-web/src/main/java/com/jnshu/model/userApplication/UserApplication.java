package com.jnshu.model.userApplication;

public class UserApplication {
    private long id;
    private String userNumber;
    private long createAt;
    private String phoneNumber;
    private String realName;
    private String idCard;
    private int applicationStatus;
    private String refuseReason;

    public UserApplication() {
    }

    public UserApplication(long id, String userNumber, long createAt, String phoneNumber, String realName, String idCard, int applicationStatus, String refuseReason) {
        this.id = id;
        this.userNumber = userNumber;
        this.createAt = createAt;
        this.phoneNumber = phoneNumber;
        this.realName = realName;
        this.idCard = idCard;
        this.applicationStatus = applicationStatus;
        this.refuseReason = refuseReason;
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

    @Override
    public String toString() {
        return "UserApplication{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", applicationStatus=" + applicationStatus +
                ", refuseReason='" + refuseReason + '\'' +
                '}';
    }
}
