package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融contract表实体类
 */
public class Contract implements Serializable {
    private static final long serialVersionUID = -1164263469683778970L;
    /**
     * 是否付款，未付款
     */
    public static final Integer IS_PAY_NO=0;
    /**
     * 是否付款，已付款
     */
    public static final Integer IS_PAY_YES=1;
    /**
     * 是否匹配债权,未匹配
     */
    public static final Integer IS_MATCHING_CLAIMS_NO=0;
    /**
     * 是否匹配债权，已匹配
     */
    public static final Integer IS_MATCHING_CLAIMS_YES=1;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private String contractCode;
    //是否付款成功，0：失败，1：成功，默认0
    private int isPay=0;
    //是否匹配债权，0：没有，1：已匹配，默认0
    private int isMatchingClaims=0;
    //当前债权协议
    private String currentClaimsCode;
    //用户数字签名
    private String userSign;

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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public int getIsMatchingClaims() {
        return isMatchingClaims;
    }

    public void setIsMatchingClaims(int isMatchingClaims) {
        this.isMatchingClaims = isMatchingClaims;
    }

    public String getCurrentClaimsCode() {
        return currentClaimsCode;
    }

    public void setCurrentClaimsCode(String currentClaimsCode) {
        this.currentClaimsCode = currentClaimsCode;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", contractCode='" + contractCode + '\'' +
                ", isPay=" + isPay +
                ", isMatchingClaims=" + isMatchingClaims +
                ", currentClaimsCode='" + currentClaimsCode + '\'' +
                ", userSign='" + userSign + '\'' +
                '}';
    }
}
