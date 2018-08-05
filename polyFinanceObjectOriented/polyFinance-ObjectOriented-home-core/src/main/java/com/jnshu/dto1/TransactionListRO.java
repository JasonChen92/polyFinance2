package com.jnshu.dto1;

/**
 * 用户投资列表返回结果实体类
 */
public class TransactionListRO {
    private long id;
    private String productName;
    private String money;
    private long startAt;
    private long endAt;
    private String interestRate;
    private int mark;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public long getStartAt() {
        return startAt;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionListRO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", money='" + money + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", interestRate='" + interestRate + '\'' +
                ", mark=" + mark +
                ", status=" + status +
                '}';
    }
}
