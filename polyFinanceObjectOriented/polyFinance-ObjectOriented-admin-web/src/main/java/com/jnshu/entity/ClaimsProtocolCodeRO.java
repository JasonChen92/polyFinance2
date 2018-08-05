package com.jnshu.entity;

/**
 * 债权协议具体内容实体类
 */
public class ClaimsProtocolCodeRO {
    private String claimsProtocolCode;
    private long claimsCreateAt;
    private String contract="https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/840.png";
    private String userName;
    private String userIdCard;
    private String creditor;
    private String creditorIdCard;
    private String userSign;
    private String companyCachet;

    public String getClaimsProtocolCode() {
        return claimsProtocolCode;
    }

    public void setClaimsProtocolCode(String claimsProtocolCode) {
        this.claimsProtocolCode = claimsProtocolCode;
    }

    public long getClaimsCreateAt() {
        return claimsCreateAt;
    }

    public void setClaimsCreateAt(long claimsCreateAt) {
        this.claimsCreateAt = claimsCreateAt;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getCreditorIdCard() {
        return creditorIdCard;
    }

    public void setCreditorIdCard(String creditorIdCard) {
        this.creditorIdCard = creditorIdCard;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getCompanyCachet() {
        return companyCachet;
    }

    public void setCompanyCachet(String companyCachet) {
        this.companyCachet = companyCachet;
    }

    @Override
    public String toString() {
        return "ClaimsProtocolCodeRO{" +
                "claimsProtocolCode='" + claimsProtocolCode + '\'' +
                ", claimsCreateAt=" + claimsCreateAt +
                ", contract='" + contract + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", creditor='" + creditor + '\'' +
                ", creditorIdCard='" + creditorIdCard + '\'' +
                ", userSign='" + userSign + '\'' +
                ", companyCachet='" + companyCachet + '\'' +
                '}';
    }
}
