package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融timed_task表对应实体类
 */
public class TimedTask implements Serializable {
    private static final long serialVersionUID = 7155950148356243300L;
    /**
     *状态，已执行
     */
    public static final Integer STATUS_HAS_EXECUTED=1;
    /**
     *状态，未执行
     */
    public static final Integer STATUS_NOT_EXECUTE=0;
    /**
     *任务性质，返息
     */
    public static final Integer NATURE_RETURN_INTEREST=0;
    /**
     *任务性质,返回本金
     */
    public static final Integer NATURE_RETURN_PRINCIPAL=1;
    /**
     *任务性质，查询返息是否成功
     */
    public static final Integer NATURE_INQUIRE_INTEREST=2;
    /**
     *任务性质，查询返现是否成功
     */
    public static final Integer NATURE_INQUIRE_PRINCIPAL=3;
    /**
     *任务性质，修改续投状态
     */
    public static final Integer NATURE_RENEWAL=4;
    /**
     *任务性质，修改消息为已发送
     */
    public static final Integer NATURE_MESSAGE=5;
    /**
     *任务性质，修改合同状态为未匹配
     */
    public static final Integer NATURE_CONTRACT=6;
    /**
     *任务性质，修改债权状态为已过期
     */
    public static final Integer NATURE_CLAIMS=7;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    //状态，0;未执行，1：已执行，默认0
    private int status;
    private long taskTime;
    //任务性质，0为回息，1为回本金，2为查询返息是否成功，3为查询回款是否成功，4为到续投时间修改状态为可续投并发消息提醒，
    //5管理员定时消息转为已发送状态，6债权匹配时，合同时间>债权时间的情况，修改合同表的状态为未匹配，
    // 7新增债权时增加（或是修改债权后修改）一个定时任务，任务时间为债权到期时间，到期后将债权状态修改为已过期
    private int nature;
    private String money;
    private long contractId;
    private long transactionId;
    private long messageId;
    private long claimsId;
    private String bankLog;
    private long superId;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(long taskTime) {
        this.taskTime = taskTime;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getClaimsId() {
        return claimsId;
    }

    public void setClaimsId(long claimsId) {
        this.claimsId = claimsId;
    }

    public String getBankLog() {
        return bankLog;
    }

    public void setBankLog(String bankLog) {
        this.bankLog = bankLog;
    }

    public long getSuperId() {
        return superId;
    }

    public void setSuperId(long superId) {
        this.superId = superId;
    }

    @Override
    public String toString() {
        return "TimedTask{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", status=" + status +
                ", taskTime=" + taskTime +
                ", nature=" + nature +
                ", money='" + money + '\'' +
                ", contractId=" + contractId +
                ", transactionId=" + transactionId +
                ", messageId=" + messageId +
                ", claimsId=" + claimsId +
                ", bankLog='" + bankLog + '\'' +
                ", superId=" + superId +
                '}';
    }
}
