package com.jnshu.Domain2;

public class DomainBank {
    private Long id;
    private String bankName;
    private String paymentId;
    private String withdrawalId;
    private String singleLimited;
    private String dayLimited;
    private String updateBy;
    private Long updateAt;

    public DomainBank() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "DomainBank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", withdrawalId='" + withdrawalId + '\'' +
                ", singleLimited='" + singleLimited + '\'' +
                ", dayLimited='" + dayLimited + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateAt=" + updateAt +
                '}';
    }
}
