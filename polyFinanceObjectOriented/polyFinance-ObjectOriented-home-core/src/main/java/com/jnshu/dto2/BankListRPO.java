package com.jnshu.dto2;

public class BankListRPO {
    private String bankName;
    private String updateBy;
    private Long updateAt1;
    private Long updateAt2;
    private String singleLimited1;
    private String singleLimited2;
    private String dayLimited1;
    private String dayLimited2;

    public BankListRPO() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateAt1() {
        return updateAt1;
    }

    public void setUpdateAt1(Long updateAt1) {
        this.updateAt1 = updateAt1;
    }

    public Long getUpdateAt2() {
        return updateAt2;
    }

    public void setUpdateAt2(Long updateAt2) {
        this.updateAt2 = updateAt2;
    }

    public String getSingleLimited1() {
        return singleLimited1;
    }

    public void setSingleLimited1(String singleLimited1) {
        this.singleLimited1 = singleLimited1;
    }

    public String getSingleLimited2() {
        return singleLimited2;
    }

    public void setSingleLimited2(String singleLimited2) {
        this.singleLimited2 = singleLimited2;
    }

    public String getDayLimited1() {
        return dayLimited1;
    }

    public void setDayLimited1(String dayLimited1) {
        this.dayLimited1 = dayLimited1;
    }

    public String getDayLimited2() {
        return dayLimited2;
    }

    public void setDayLimited2(String dayLimited2) {
        this.dayLimited2 = dayLimited2;
    }

    @Override
    public String toString() {
        return "BankListRPO{" +
                "bankName='" + bankName + '\'' +
                ", updateBy=" + updateBy +
                ", updateAt1=" + updateAt1 +
                ", updateAt2=" + updateAt2 +
                ", singleLimited1='" + singleLimited1 + '\'' +
                ", singleLimited2='" + singleLimited2 + '\'' +
                ", dayLimited1='" + dayLimited1 + '\'' +
                ", dayLimited2='" + dayLimited2 + '\'' +
                '}';
    }
}
