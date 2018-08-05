package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融product表对应实体类
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 492495524263482919L;
    /**
     *还款方式，按月付息，到期还本
     */
    public static final Integer REFUND_STYLE_INTEREST=0;
    /**
     *还款方式，本息一次还
     */
    public static final Integer REFUND_STYLE_ONCE=1;
    /**
     *在售
     */
    public static final Integer STATUS_ON_SALE=0;
    /**
     * 停售
     */
    public static final Integer STATUS_STOP_SALE=1;
    /**
     * 角标，都不选
     */
    public static final Integer MARK_NOT_SELECTED=0;
    /**
     * 角标，新近产品
     */
    public static final Integer MARK_NEW=1;
    /**
     * 角标，热门产品
     */
    public static final Integer MARK_HOT=2;
    /**
     * 是否推荐，不推荐
     */
    public static final Integer IS_RECOMMEND_NO=0;
    /**
     * 是否推荐，推荐
     */
    public static final Integer IS_RECOMMEND_YES=1;
    /**
     * 是否限购，否
     */
    public static final Integer IS_LIMITED_PURCHASE_NO=0;
    /**
     * 是否限购，是
     */
    public static final Integer IS_LIMITED_PURCHASE_YES=1;

    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    //产品代号
    private String productCode;
    private String productName;
    //利率
    private String interestRate;
    //期限，单位：天
    private int deadline;
    private String investmentAmount;
    //起息日期，0：T+0,1:T+1,2:T+2
    private int rateOfInterest;
    //还款方式，0:按月付息到期还本，1：本息一次还
    private int refundStyle;
    private String remark;
    //状态，0：在售，1：停售
    private int status;
    //角标，0：啥也不选，1:  新近产品，2：热门产品，默认0
    private int mark=0;
    //是否推荐，0：不推荐，1：推荐，默认0
    private int isRecommend=0;
    //是否限购0:否，1:是，默认0
    private int isLimitePurchase=0;
    //图片url
    private String moreMessage;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public int getRefundStyle() {
        return refundStyle;
    }

    public void setRefundStyle(int refundStyle) {
        this.refundStyle = refundStyle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public int getIsLimitePurchase() {
        return isLimitePurchase;
    }

    public void setIsLimitePurchase(int isLimitePurchase) {
        this.isLimitePurchase = isLimitePurchase;
    }

    public String getMoreMessage() {
        return moreMessage;
    }

    public void setMoreMessage(String moreMessage) {
        this.moreMessage = moreMessage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", deadline=" + deadline +
                ", investmentAmount='" + investmentAmount + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", refundStyle=" + refundStyle +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", mark=" + mark +
                ", isRecommend=" + isRecommend +
                ", isLimitePurchase=" + isLimitePurchase +
                ", moreMessage='" + moreMessage + '\'' +
                '}';
    }
}
