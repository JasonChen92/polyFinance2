package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融bank_card表实体类
 */
public class BankCard implements Serializable {
    private static final long serialVersionUID = 6592673127900903170L;
    /**
     * 银行卡第一次添加
     */
    public static final Integer ORDER_FIRST=1;
    /**
     * 银行卡第二次添加
     */
    public static final Integer ORDER_SECOND=2;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    //银行卡号
    private String bankCard;
    //对应bank表银行id
    private long bankId;
    //银行预留手机号
    private String bankPhone;
    //所属人对应user表id
    private long userId;
    private String city;
    //添加顺序，1为第一次添加，2为第二次添加，最多为2
    private int order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(long updateBy) {
        this.updateBy = updateBy;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BankCardMapper{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", bankCard='" + bankCard + '\'' +
                ", bankId=" + bankId +
                ", bankPhone='" + bankPhone + '\'' +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", order=" + order +
                '}';
    }
}
