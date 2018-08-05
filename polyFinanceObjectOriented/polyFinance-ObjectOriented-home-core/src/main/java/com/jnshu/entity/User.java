package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融user表实体类
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3931423334698412790L;
    /**
     * 实名状态，未实名
     */
    public static final Integer REAL_STATUS_NOT=0;
    /**
     *实名状态，已实名
     */
    public static final Integer REAL_STATUS_HAVE=1;
    /**
     * 新手礼包,未买过
     */
    public static final Integer IS_NEW_NOT=0;
    /**
     * 新手礼包，已经买过
     */
    public static final Integer IS_NEW_HAVE=1;
    /**
     *用户状态，正常
     */
    public static final Integer STATUS_NORMAL=0;
    /**
     *用户状态，冻结
     */
    public static final Integer STATUS_FREEZE=1;

    private long id;
     private long createAt;
     private long createBy;
     private long updateAt;
     private long updateBy;
     //用户编号，UK+年份后两位+10+000001（六位递增数字）
     private String userNumber;
     //手机号，也是账号
     private String phoneNumber;
     //随机盐
     private String salt;
     //代替密码的hashKey
     private String hashKey;
     //实名状态，0：未实名，1：实名，默认0
     private int realStatus=0;
     private String realName;
     private String idCard;
     //是否购买过新手礼包0未买，1买过，默认0
     private int isNew=0;
     //推荐人手机号
     private String referrerId;
     private String email;
     private String address;
     //默认银行卡id
     private long defaultCard;
     //手势密码
     private int gesturePassword;
     //总资产
     private String property;
     //累计收益
     private String cumulativeIncome;
    //账号状态，0正常，1冻结，默认0
     private int status=0;

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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public int getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(int realStatus) {
        this.realStatus = realStatus;
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

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDefaultCard() {
        return defaultCard;
    }

    public void setDefaultCard(long defaultCard) {
        this.defaultCard = defaultCard;
    }

    public int getGesturePassword() {
        return gesturePassword;
    }

    public void setGesturePassword(int gesturePassword) {
        this.gesturePassword = gesturePassword;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCumulativeIncome() {
        return cumulativeIncome;
    }

    public void setCumulativeIncome(String cumulativeIncome) {
        this.cumulativeIncome = cumulativeIncome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", userNumber='" + userNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salt='" + salt + '\'' +
                ", hashKey='" + hashKey + '\'' +
                ", realStatus=" + realStatus +
                ", realName='" + realName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", isNew=" + isNew +
                ", referrerId='" + referrerId + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", defaultCard=" + defaultCard +
                ", gesturePassword=" + gesturePassword +
                ", property='" + property + '\'' +
                ", cumulativeIncome='" + cumulativeIncome + '\'' +
                ", status=" + status +
                '}';
    }
}
