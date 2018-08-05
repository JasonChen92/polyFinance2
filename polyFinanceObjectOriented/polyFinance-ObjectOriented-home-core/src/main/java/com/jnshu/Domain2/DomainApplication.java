package com.jnshu.Domain2;

public class DomainApplication {
    private Long id;
    private Long userId;
    private String userNumber;
    private String realName;
    private String idCard;
    private Long createAt;
    private String phoneNumber;
    private String email;
    private String address;
    private String frontCard;
    private String reverseCard;
    private Integer isFirst;
    private Integer applicationStatus;
    private String refuseReason;

    public DomainApplication() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
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
        return "DomainApplication{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", frontCard='" + frontCard + '\'' +
                ", reverseCard='" + reverseCard + '\'' +
                ", isFirst=" + isFirst +
                ", applicationStatus=" + applicationStatus +
                ", refuseReason='" + refuseReason + '\'' +
                '}' +"\n";
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
