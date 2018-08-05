package com.jnshu.model.user;

public class UserInfo {
    private long id;
    private String userNumber;
    private long createAt;
    private String phoneNumber;
    private String referrerId;
    private int realStatus;

    private String realName;
    private String idCard;
    private String email;
    private String address;
    private String property;
    private String cumulativeIncome;
    private Integer status;
    private String frontCard;
    private String reverseCard;
    private long cardId1;
    private String bank1;
    private String bankCard1;
    private long cardId2;
    private String bank2;
    private String bankCard2;

    public UserInfo() {
    }

    public UserInfo(long id, String userNumber, long createAt, String phoneNumber, String referrerId, int realStatus, String realName, String idCard, String property, String cumulativeIncome, Integer status) {
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

    public UserInfo(long id, String userNumber, long createAt, String phoneNumber, String referrerId, int realStatus, String realName, String idCard, String email, String address, String property, String cumulativeIncome, Integer status, String frontCard, String reverseCard, long cardId1, String bank1, String bankCard1, long cardId2, String bank2, String bankCard2) {
        this.id = id;
        this.userNumber = userNumber;
        this.createAt = createAt;
        this.phoneNumber = phoneNumber;
        this.referrerId = referrerId;
        this.realStatus = realStatus;
        this.realName = realName;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.property = property;
        this.cumulativeIncome = cumulativeIncome;
        this.status = status;
        this.frontCard = frontCard;
        this.reverseCard = reverseCard;
        this.cardId1 = cardId1;
        this.bank1 = bank1;
        this.bankCard1 = bankCard1;
        this.cardId2 = cardId2;
        this.bank2 = bank2;
        this.bankCard2 = bankCard2;
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

    public void setRealStatus(int realStatus) {
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

    public long getCardId1() {
        return cardId1;
    }

    public void setCardId1(long cardId1) {
        this.cardId1 = cardId1;
    }

    public String getBank1() {
        return bank1;
    }

    public void setBank1(String bank1) {
        this.bank1 = bank1;
    }

    public String getBankCard1() {
        return bankCard1;
    }

    public void setBankCard1(String bankCard1) {
        this.bankCard1 = bankCard1;
    }

    public long getCardId2() {
        return cardId2;
    }

    public void setCardId2(long cardId2) {
        this.cardId2 = cardId2;
    }

    public String getBank2() {
        return bank2;
    }

    public void setBank2(String bank2) {
        this.bank2 = bank2;
    }

    public String getBankCard2() {
        return bankCard2;
    }

    public void setBankCard2(String bankCard2) {
        this.bankCard2 = bankCard2;
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

    public String toString2() {
        return "UserInfo{" +
                "id=" + id +
                ", userNumber='" + userNumber + '\'' +
                ", createAt=" + createAt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", referrerId='" + referrerId + '\'' +
                ", realStatus=" + realStatus +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", property='" + property + '\'' +
                ", cumulativeIncome='" + cumulativeIncome + '\'' +
                ", status=" + status +
                ", frontCard='" + frontCard + '\'' +
                ", reverseCard='" + reverseCard + '\'' +
                ", cardId1=" + cardId1 +
                ", bank1='" + bank1 + '\'' +
                ", bankCard1='" + bankCard1 + '\'' +
                ", cardId2=" + cardId2 +
                ", bank2='" + bank2 + '\'' +
                ", bankCard2='" + bankCard2 + '\'' +
                '}';
    }
}
