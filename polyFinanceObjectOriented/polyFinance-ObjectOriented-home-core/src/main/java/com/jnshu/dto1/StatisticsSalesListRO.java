package com.jnshu.dto1;

public class StatisticsSalesListRO {
    private long id;
    private String productCode;
    private String productName;
    private long peopleCounting;
    private long numberOfTimes;
    private String totalMoney;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
        return "StatisticsSalesListRO{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", peopleCounting=" + peopleCounting +
                ", numberOfTimes=" + numberOfTimes +
                ", totalMoney='" + totalMoney + '\'' +
                '}';
    }
}
