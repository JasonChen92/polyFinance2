package com.jnshu.entity;

import java.io.Serializable;

public class RealNameApplication implements Serializable {
    private static final long serialVersionUID = 7462581826457911697L;
    /**
     *实名状态，未认证
     */
    public static final Integer APPLICATION_STATUS_NO=0;
    /**
     *实名状态，已认证
     */
    public static final Integer APPLICATION_STATUS_YES=1;
    /**
     *实名状态，已拒绝
     */
    public static final Integer APPLICATION_STATUS_REFUSED=2;
    /**
     *实名状态，已取消
     */
    public static final Integer APPLICATION_STATUS_CANCEL=3;
    /**
     *是否第一次申请，是
     */
    public static final Integer IS_FIRST_YES=0;
    /**
     *是否第一次申请，不是
     */
    public static final Integer IS_FIRST_NO=1;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private long userId;
    private String realName;
    private String idCard;
    private String frontCard;
    private String reverseCard;
    //申请状态，0：未认证，1：已认证，2：已拒绝，3：已取消，默认0
    private int applicationStatus=0;
    //是否第一次申请，0：第一次，1：非第一次，默认0
    private int isFirst=0;
    private String refuseReason;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFrontCard() {
        return frontCard;
    }

    public void setFrontCard(String frontCard) {
        this.frontCard = frontCard;
    }

    public String getReverseCard() {
        return reverseCard;
    }

    public void setReverseCard(String reverseCard) {
        this.reverseCard = reverseCard;
    }

    public int getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(int applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(int isFirst) {
        this.isFirst = isFirst;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    @Override
    public String toString() {
        return "RealNameApplication{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", userId=" + userId +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", frontCard='" + frontCard + '\'' +
                ", reverseCard='" + reverseCard + '\'' +
                ", applicationStatus=" + applicationStatus +
                ", isFirst=" + isFirst +
                ", refuseReason='" + refuseReason + '\'' +
                '}';
    }
}
