package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融bank对应实体类
 */
public class Bank implements Serializable{
    private static final long serialVersionUID = -7258247581129863909L;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private String bankName;
    private String paymentId;
    private String withdrawalId;
    private String singleLimited;
    private String dayLimited;
    //银行logo
    private String icon;

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(String withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public String getSingleLimited() {
        return singleLimited;
    }

    public void setSingleLimited(String singleLimited) {
        this.singleLimited = singleLimited;
    }

    public String getDayLimited() {
        return dayLimited;
    }

    public void setDayLimited(String dayLimited) {
        this.dayLimited = dayLimited;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", bankName='" + bankName + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", withdrawalId='" + withdrawalId + '\'' +
                ", singleLimited='" + singleLimited + '\'' +
                ", dayLimited='" + dayLimited + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
