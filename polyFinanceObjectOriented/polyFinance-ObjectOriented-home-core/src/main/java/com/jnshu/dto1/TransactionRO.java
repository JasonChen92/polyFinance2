package com.jnshu.dto1;

/**
 * 指定投资具体对象
 */
public class TransactionRO {
    private long id;
    private String productName;
    private String interestRate;
    private String money;
    private int mark;
    private long startAt;
    private long endAt;
    private int status;
    private String exceptEarnings;
    private String returned;
    private String notReturn;
    private String investmentAmount;
    private String defaultCardBankName;
    private String defaultCardId;
    private int refundStyle;
    private int renuwalStatus;
    private long contractId;
    private int productStatus;

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

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExceptEarnings() {
        return exceptEarnings;
    }

    public void setExceptEarnings(String exceptEarnings) {
        this.exceptEarnings = exceptEarnings;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getNotReturn() {
        return notReturn;
    }

    public void setNotReturn(String notReturn) {
        this.notReturn = notReturn;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getDefaultCardBankName() {
        return defaultCardBankName;
    }

    public void setDefaultCardBankName(String defaultCardBankName) {
        this.defaultCardBankName = defaultCardBankName;
    }

    public String getDefaultCardId() {
        return defaultCardId;
    }

    public void setDefaultCardId(String defaultCardId) {
        this.defaultCardId = defaultCardId;
    }

    public int getRefundStyle() {
        return refundStyle;
    }

    public void setRefundStyle(int refundStyle) {
        this.refundStyle = refundStyle;
    }

    public int getRenuwalStatus() {
        return renuwalStatus;
    }

    public void setRenuwalStatus(int renuwalStatus) {
        this.renuwalStatus = renuwalStatus;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "TransactionRO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", money='" + money + '\'' +
                ", mark=" + mark +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", status=" + status +
                ", exceptEarnings='" + exceptEarnings + '\'' +
                ", returned='" + returned + '\'' +
                ", notReturn='" + notReturn + '\'' +
                ", investmentAmount='" + investmentAmount + '\'' +
                ", defaultCardBankName='" + defaultCardBankName + '\'' +
                ", defaultCardId='" + defaultCardId + '\'' +
                ", refundStyle=" + refundStyle +
                ", renuwalStatus=" + renuwalStatus +
                ", contractId=" + contractId +
                ", productStatus=" + productStatus +
                '}';
    }
}
