package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融claims_matching表实体类
 */
public class ClaimsMatching implements Serializable {
    private static final long serialVersionUID = 6281461440165984785L;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private long claimsId;
    private String contractCode;
    //债权协议编号，UK+ZQ+年份后两位+10+000001（6位递增数字）
    private String claimsProtocolCode;

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

    public long getClaimsId() {
        return claimsId;
    }

    public void setClaimsId(long claimsId) {
        this.claimsId = claimsId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getClaimsProtocolCode() {
        return claimsProtocolCode;
    }

    public void setClaimsProtocolCode(String claimsProtocolCode) {
        this.claimsProtocolCode = claimsProtocolCode;
    }

    @Override
    public String toString() {
        return "ClaimsMatching{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", claimsId=" + claimsId +
                ", contractCode='" + contractCode + '\'' +
                ", claimsProtocolCode='" + claimsProtocolCode + '\'' +
                '}';
    }
}
