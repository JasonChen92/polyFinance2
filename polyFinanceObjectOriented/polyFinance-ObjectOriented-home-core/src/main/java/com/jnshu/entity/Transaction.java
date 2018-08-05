package com.jnshu.entity;

import java.io.Serializable;

/**
 *聚金融transaction表实体类
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = 433310565527530505L;
    /**
     * 续投状态，未到续投时间
     */
    public static final Integer RENUWAL_STATUS_NOT=0;
    /**
     * 续投状态，可续投
     */
    public static final Integer RENUWAL_STATUS_CAN=1;
    /**
     * 续投状态,已续投
     */
    public static final Integer RENUWAL_STATUS_HAVE=2;
    /**
     * 续投状态，超过续投时间
     */
    public static final Integer RENUWAL_STATUS_EXPIRED=3;
    /**
     *投资状态，投资中
     */
    public static final Integer STATUS_INVESTING=0;
    /**
     *投资状态，回款中
     */
    public static final Integer STATUS_PAYING=1;
    /**
     * 投资状态，已回款
     */
    public static final Integer STATUS_REPAID=2;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private long userId;
    //起息时间，创建时间+起息日期
    private long startAt;
    private long endAt;
    //续投状态0未到续投时间，1可续投，2已续投，3超过续投时间，默认0，定时任务触发时修改为1，续投投资成功修改为2，返款后修改为3
    private int renuwalStatus=0;
    private String money;
    private String expectEarnings;
    private String returned;
    private String notReturn;
    private long productId;
    private long claimsId;
    //投资状态，0:理财中=投资中，1：退出中=回款中，2：已退出=已回款，默认0
    private int status;
    //合同编号，UK+产品代号+年份后两位+10+000001（6位递增数字）
    private String contractCode;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStartAt() {
        return startAt;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public int getRenuwalStatus() {
        return renuwalStatus;
    }

    public void setRenuwalStatus(int renuwalStatus) {
        this.renuwalStatus = renuwalStatus;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getExpectEarnings() {
        return expectEarnings;
    }

    public void setExpectEarnings(String expectEarnings) {
        this.expectEarnings = expectEarnings;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getNotReturn() {
        return notReturn;
    }

    public void setNotReturn(String notReturn) {
        this.notReturn = notReturn;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getClaimsId() {
        return claimsId;
    }

    public void setClaimsId(long claimsId) {
        this.claimsId = claimsId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", userId=" + userId +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", renuwalStatus=" + renuwalStatus +
                ", money='" + money + '\'' +
                ", exceptEarnings='" + expectEarnings + '\'' +
                ", returned='" + returned + '\'' +
                ", notReturn='" + notReturn + '\'' +
                ", productId=" + productId +
                ", claimsId=" + claimsId +
                ", status=" + status +
                ", contractCode='" + contractCode + '\'' +
                '}';
    }
}
