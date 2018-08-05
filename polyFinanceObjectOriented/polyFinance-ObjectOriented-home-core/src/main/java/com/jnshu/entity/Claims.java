package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融claims表对应实体类
 */
public class Claims implements Serializable {
    private static final long serialVersionUID = -931727715216503734L;
    /**
     * 状态，未使用
     */
    public static final Integer STATUS_NOT_USE=0;
    /**
     * 状态，使用中
     */
    public static final Integer STATUS_USING=1;
    /**
     * 状态，已到期
     */
    public static final Integer STATUS_EXPIRED=2;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    //债权代号
    private String claimsCode;
    private String creditor;
    private String creditorPhoneNumber;
    private String creditorIdCard;
    //出借期限，单位：月
    private int lendDeadline;
    private long lendStartAt;
    private long lendEndAt;
    private String lendMoney;
    //债权状态，0:未使用，1：使用中，2：已到期，默认为0
    private int status=0;
    private String claimsNature;
    private String claimsInterestRate;
    private String remark;
    private String remanentMoney;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(long updateBy) {
        this.updateBy = updateBy;
    }

    public String getClaimsCode() {
        return claimsCode;
    }

    public void setClaimsCode(String claimsCode) {
        this.claimsCode = claimsCode;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getCreditorPhoneNumber() {
        return creditorPhoneNumber;
    }

    public void setCreditorPhoneNumber(String creditorPhoneNumber) {
        this.creditorPhoneNumber = creditorPhoneNumber;
    }

    public String getCreditorIdCard() {
        return creditorIdCard;
    }

    public void setCreditorIdCard(String creditorIdCard) {
        this.creditorIdCard = creditorIdCard;
    }

    public int getLendDeadline() {
        return lendDeadline;
    }

    public void setLendDeadline(int lendDeadline) {
        this.lendDeadline = lendDeadline;
    }

    public long getLendStartAt() {
        return lendStartAt;
    }

    public void setLendStartAt(long lendStartAt) {
        this.lendStartAt = lendStartAt;
    }

    public long getLendEndAt() {
        return lendEndAt;
    }

    public void setLendEndAt(long lendEndAt) {
        this.lendEndAt = lendEndAt;
    }

    public String getLendMoney() {
        return lendMoney;
    }

    public void setLendMoney(String lendMoney) {
        this.lendMoney = lendMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getClaimsNature() {
        return claimsNature;
    }

    public void setClaimsNature(String claimsNature) {
        this.claimsNature = claimsNature;
    }

    public String getClaimsInterestRate() {
        return claimsInterestRate;
    }

    public void setClaimsInterestRate(String claimsInterestRate) {
        this.claimsInterestRate = claimsInterestRate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemanentMoney() {
        return remanentMoney;
    }

    public void setRemanentMoney(String remanentMoney) {
        this.remanentMoney = remanentMoney;
    }

    @Override
    public String toString() {
        return "Claims{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", claimsCode='" + claimsCode + '\'' +
                ", creditor='" + creditor + '\'' +
                ", creditorPhoneNumber='" + creditorPhoneNumber + '\'' +
                ", creditorIdCard='" + creditorIdCard + '\'' +
                ", lendDeadline=" + lendDeadline +
                ", lendStartAt=" + lendStartAt +
                ", lendEndAt=" + lendEndAt +
                ", lendMoney='" + lendMoney + '\'' +
                ", status=" + status +
                ", claimsNature='" + claimsNature + '\'' +
                ", claimsInterestRate='" + claimsInterestRate + '\'' +
                ", remark='" + remark + '\'' +
                ", remanentMoney='" + remanentMoney + '\'' +
                '}';
    }
}
