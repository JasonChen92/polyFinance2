package com.jnshu.entity;

public class StatisticsSalesRO {
    private String productName;
    private long date;
    private long peopleCounting;
    private long numberOfTimes;
    private String totalMoney;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getPeopleCounting() {
        return peopleCounting;
    }

    public void setPeopleCounting(long peopleCounting) {
        this.peopleCounting = peopleCounting;
    }

    public long getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(long numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "StatisticsSalesRO{" +
                "productName='" + productName + '\'' +
                ", date=" + date +
                ", peopleCounting=" + peopleCounting +
                ", numberOfTimes=" + numberOfTimes +
                ", totalMoney='" + totalMoney + '\'' +
                '}';
    }
}
