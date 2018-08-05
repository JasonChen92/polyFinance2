package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融transaction_log表对应实体类
 */
public class TransactionLog implements Serializable {
    private static final long serialVersionUID = 4189666884369204619L;
    /**
     *交易状态，付款成功
     */
    public static final Integer STATUS_PAY_SUCCESS=0;
    /**
     *交易状态，付款失败
     */
    public static final Integer STATUS_PAY_FAIL=1;
    /**
     *交易状态，回款成功
     */
    public static final Integer STATUS_RETURN_SUCCESS=2;
    /**
     *交易状态，回款失败
     */
    public static final Integer STATUS_RETURN_FAIL=3;
    /**
     *交易状态，返息成功
     */
    public static final Integer STATUS_INTEREST_SUCCESS=4;
    /**
     *交易状态，返息失败
     */
    public static final Integer STATUS_INTEREST_FAIL=5;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private long userId;
    private String productName;
    private long transactionAt;
    private String transactionWay;
    private String money;
    private String bankLog;
    //交易状态，0付款成功，1付款失败，2回款成功，3回款失败，4返息成功，5返息失败
    private int status;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getTransactionAt() {
        return transactionAt;
    }

    public void setTransactionAt(long transactionAt) {
        this.transactionAt = transactionAt;
    }

    public String getTransactionWay() {
        return transactionWay;
    }

    public void setTransactionWay(String transactionWay) {
        this.transactionWay = transactionWay;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBankLog() {
        return bankLog;
    }

    public void setBankLog(String bankLog) {
        this.bankLog = bankLog;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", transactionAt=" + transactionAt +
                ", transactionWay='" + transactionWay + '\'' +
                ", money='" + money + '\'' +
                ", bankLog=" + bankLog +
                ", status=" + status +
                '}';
    }
}
