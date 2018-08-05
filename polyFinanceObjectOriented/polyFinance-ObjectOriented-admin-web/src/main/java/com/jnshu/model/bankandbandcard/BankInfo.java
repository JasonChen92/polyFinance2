package com.jnshu.model.bankandbandcard;

public class BankInfo {
    private long id;
    private String bankName;
    private String paymentId;
    private String withdrawalId;
    private String singleLimited;
    private String dayLimited;
    private String icon;

    public BankInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "BankInfo{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", withdrawalId='" + withdrawalId + '\'' +
                ", singleLimited='" + singleLimited + '\'' +
                ", dayLimited='" + dayLimited + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
