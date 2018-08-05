package com.jnshu.entity;

public class ContractRO {
    private String contractCode;
    private long contractCreateAt;
    private String contract="https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/840.png";
    private String userName;
    private String userIdCard;
    private String creditor;
    private String creditorIdCard;
    private String userSign;
    private String companyCachet;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public long getContractCreateAt() {
        return contractCreateAt;
    }

    public void setContractCreateAt(long contractCreateAt) {
        this.contractCreateAt = contractCreateAt;
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
        return "ContractRO{" +
                "contractCode='" + contractCode + '\'' +
                ", contractCreate=" + contractCreateAt +
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
