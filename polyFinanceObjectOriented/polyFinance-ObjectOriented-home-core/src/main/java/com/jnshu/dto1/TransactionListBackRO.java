package com.jnshu.dto1;

public class TransactionListBackRO {
    private String productName;
    private String money;
    private long startAt;
    private long endAt;
    private int status;
    private String returned;
    private String notReturn;
    private String contractCode;
    private String currentClaimsCode;

    public String getCurrentClaimsCode() {
        return currentClaimsCode;
    }

    public void setCurrentClaimsCode(String currentClaimsCode) {
        this.currentClaimsCode = currentClaimsCode;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }


    @Override
    public String toString() {
        return "TransactionListBackRO{" +
                "productName='" + productName + '\'' +
                ", money='" + money + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", status=" + status +
                ", returned='" + returned + '\'' +
                ", notReturn='" + notReturn + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", currentClaimsCode='" + currentClaimsCode + '\'' +
                '}';
    }
}
