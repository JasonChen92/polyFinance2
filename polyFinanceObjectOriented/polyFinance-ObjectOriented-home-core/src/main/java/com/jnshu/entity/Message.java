package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融message表对应实体类
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -4586832996771783008L;
    /**
     * 发送人群，所有人
     */
    public static final Integer SENT_PERSON_TYPE_ALL=0;
    /**
     * 发送人群，认证投资人
     */
    public static final Integer SENT_PERSON_TYPE_VERIFIED=1;
    /**
     * 是否推送，不推送
     */
    public static final Integer IS_PUSH_NO=0;
    /**
     *是否推送，推送
     */
    public static final Integer IS_PUSH_YES=1;
    /**
     *消息类型，即时发送
     */
    public static final Integer MESSAGE_TYPE_IMMEDIATE=0;
    /**
     *消息类型，定时发送
     */
    public static final Integer MESSAGE_TYPE_TIMING=1;
    /**
     *是否发送，发送
     */
    public static final Integer IS_SENT_YES=0;
    /**
     *是否发送，待发送
     */
    public static final Integer IS_SENT_READY=1;
    /**
     *是否发送，存为草稿
     */
    public static final Integer IS_SENT_DRAFT=2;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private String title;
    private String introduce;
    private String content;
    //发送人群，0：所有人，1：认证投资人
    private int sentPersonType;
    //消息类型，0：即时发送，1：定时发送
    private int messageType;
    //是否推送，0：不推送，1：推送
    private int isPush;
    //是否发送，0：发送，1：待发送，2：存为草稿
    private int isSent;
    private long transactionId;
    private long userId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSentPersonType() {
        return sentPersonType;
    }

    public void setSentPersonType(int sentPersonType) {
        this.sentPersonType = sentPersonType;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getIsPush() {
        return isPush;
    }

    public void setIsPush(int isPush) {
        this.isPush = isPush;
    }

    public int getIsSent() {
        return isSent;
    }

    public void setIsSent(int isSent) {
        this.isSent = isSent;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", content='" + content + '\'' +
                ", sentPersonType=" + sentPersonType +
                ", messageType=" + messageType +
                ", isPush=" + isPush +
                ", isSent=" + isSent +
                ", transactionId=" + transactionId +
                ", userId=" + userId +
                '}';
    }
}
