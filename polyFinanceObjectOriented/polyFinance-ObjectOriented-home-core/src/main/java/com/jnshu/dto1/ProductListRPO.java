package com.jnshu.dto1;

/**
 * 获得产品列表分页接收数据实体类
 */
public class ProductListRPO {
    private int page=1;
    private int size=10;
    private Integer status;
    private String productName;
    private Integer rateOfInterest;
    private String interestRateMin;
    private String interestRateMax;
    private String investmentAmount;
    private Integer deadlineMin;
    private Integer deadlineMax;
    private String productCode;
    private Integer isRecommend;

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Integer rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getInterestRateMin() {
        return interestRateMin;
    }

    public void setInterestRateMin(String interestRateMin) {
        this.interestRateMin = interestRateMin;
    }

    public String getInterestRateMax() {
        return interestRateMax;
    }

    public void setInterestRateMax(String interestRateMax) {
        this.interestRateMax = interestRateMax;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Integer getDeadlineMin() {
        return deadlineMin;
    }

    public void setDeadlineMin(Integer deadlineMin) {
        this.deadlineMin = deadlineMin;
    }

    public Integer getDeadlineMax() {
        return deadlineMax;
    }

    public void setDeadlineMax(Integer deadlineMax) {
        this.deadlineMax = deadlineMax;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "ProductListRPO{" +
                "page=" + page +
                ", size=" + size +
                ", status=" + status +
                ", productName='" + productName + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", interestRateMin='" + interestRateMin + '\'' +
                ", interestRateMax='" + interestRateMax + '\'' +
                ", investmentAmount='" + investmentAmount + '\'' +
                ", deadlineMin=" + deadlineMin +
                ", deadlineMax=" + deadlineMax +
                ", productCode='" + productCode + '\'' +
                ", isRecommend=" + isRecommend +
                '}';
    }
}
