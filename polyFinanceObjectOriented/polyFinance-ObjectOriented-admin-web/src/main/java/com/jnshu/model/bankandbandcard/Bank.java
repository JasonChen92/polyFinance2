package com.jnshu.model.bankandbandcard;

public class Bank {
    private long id;
    private String bankName;
    private String paymentId;
    private String withdrawalld;
    private String singleLimited;
    private String dayLimited;
    private String loginName;
    private long updateBy;

    public Bank() {
    }

    public Bank(long id, String bankName, String paymentId, String withdrawalld, String singleLimited, String dayLimited, String loginName, long updateBy) {
        this.id = id;
        this.bankName = bankName;
        this.paymentId = paymentId;
        this.withdrawalld = withdrawalld;
        this.singleLimited = singleLimited;
        this.dayLimited = dayLimited;
        this.loginName = loginName;
        this.updateBy = updateBy;
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

    public String getWithdrawalld() {
        return withdrawalld;
    }

    public void setWithdrawalld(String withdrawalld) {
        this.withdrawalld = withdrawalld;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(long updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", withdrawalld='" + withdrawalld + '\'' +
                ", singleLimited='" + singleLimited + '\'' +
                ", dayLimited='" + dayLimited + '\'' +
                ", loginName='" + loginName + '\'' +
                ", updateBy=" + updateBy +
                '}';
    }
}
