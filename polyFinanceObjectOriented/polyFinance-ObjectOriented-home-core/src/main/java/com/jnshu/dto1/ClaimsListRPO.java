package com.jnshu.dto1;

/**
 * 获得债权列表前端传参接收类
 */
public class ClaimsListRPO {
    private int page=1;
    private int size=10;
    private String creditor;
    private String creditorIdCard;
    private Long lendStartMin;
    private Long lendStartMax;
    private String ClaimsCode;
    private Integer status;
    private Long lendEndMin;
    private Long lendEndMax;
    private String creditorPhoneNumber;
    private String lendMoneyMin;
    private String lendMoneyMax;
    //单位：月
    private Integer lendDeadlineMin;
    private Integer lendDeadlineMax;

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

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getCreditorIdCard() {
        return creditorIdCard;
    }

    public void setCreditorIdCard(String creditorIdCard) {
        this.creditorIdCard = creditorIdCard;
    }

    public Long getLendStartMin() {
        return lendStartMin;
    }

    public void setLendStartMin(Long lendStartMin) {
        this.lendStartMin = lendStartMin;
    }

    public Long getLendStartMax() {
        return lendStartMax;
    }

    public void setLendStartMax(Long lendStartMax) {
        this.lendStartMax = lendStartMax;
    }

    public String getClaimsCode() {
        return ClaimsCode;
    }

    public void setClaimsCode(String claimsCode) {
        ClaimsCode = claimsCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLendEndMin() {
        return lendEndMin;
    }

    public void setLendEndMin(Long lendEndMin) {
        this.lendEndMin = lendEndMin;
    }

    public Long getLendEndMax() {
        return lendEndMax;
    }

    public void setLendEndMax(Long lendEndMax) {
        this.lendEndMax = lendEndMax;
    }

    public String getCreditorPhoneNumber() {
        return creditorPhoneNumber;
    }

    public void setCreditorPhoneNumber(String creditorPhoneNumber) {
        this.creditorPhoneNumber = creditorPhoneNumber;
    }

    public String getLendMoneyMin() {
        return lendMoneyMin;
    }

    public void setLendMoneyMin(String lendMoneyMin) {
        this.lendMoneyMin = lendMoneyMin;
    }

    public String getLendMoneyMax() {
        return lendMoneyMax;
    }

    public void setLendMoneyMax(String lendMoneyMax) {
        this.lendMoneyMax = lendMoneyMax;
    }

    public Integer getLendDeadlineMin() {
        return lendDeadlineMin;
    }

    public void setLendDeadlineMin(Integer lendDeadlineMin) {
        this.lendDeadlineMin = lendDeadlineMin;
    }

    public Integer getLendDeadlineMax() {
        return lendDeadlineMax;
    }

    public void setLendDeadlineMax(Integer lendDeadlineMax) {
        this.lendDeadlineMax = lendDeadlineMax;
    }

    @Override
    public String toString() {
        return "ClaimsListRPO{" +
                "page=" + page +
                ", size=" + size +
                ", creditor='" + creditor + '\'' +
                ", creditorIdCard='" + creditorIdCard + '\'' +
                ", lendStartMin=" + lendStartMin +
                ", lendStartMax=" + lendStartMax +
                ", ClaimsCode='" + ClaimsCode + '\'' +
                ", status=" + status +
                ", lendEndMin=" + lendEndMin +
                ", lendEndMax=" + lendEndMax +
                ", creditorPhoneNumber='" + creditorPhoneNumber + '\'' +
                ", lendMoneyMin='" + lendMoneyMin + '\'' +
                ", lendMoneyMax='" + lendMoneyMax + '\'' +
                ", lendDeadlineMin=" + lendDeadlineMin +
                ", lendDeadlineMax=" + lendDeadlineMax +
                '}';
    }
}
