package com.jnshu.dto1;

/**
 * 确认支付的相关fto对象
 */
public class PaymentDto {
    private String bankCard;
    private String bankName;

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "bankCard='" + bankCard + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
