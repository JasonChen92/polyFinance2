package com.jnshu.entity;

/**
 * 确认支付用户支付信息
 */
public class PaymentRPO {
    private String phone;
    private String code;
    private long bankCardId;
    private String money;
    private long productId;
    private long contractId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(long bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "PaymentRPO{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", bankCardId=" + bankCardId +
                ", money='" + money + '\'' +
                ", productId=" + productId +
                ", contractId=" + contractId +
                '}';
    }
}
