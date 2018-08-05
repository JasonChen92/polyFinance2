package com.jnshu.entity;

/**
 * 指定债权匹配合同返回对象
 */
public class ContractMatchingRO {
    private String contractCode;
    private String userName;
    private String productName;
    private long endAt;
    private String money;
    private int fraction;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getEndAt() {
        return endAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    @Override
    public String toString() {
        return "ContractMatchingRO{" +
                "contractCode='" + contractCode + '\'' +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", endAt=" + endAt +
                ", money='" + money + '\'' +
                ", fraction=" + fraction +
                '}';
    }
}
