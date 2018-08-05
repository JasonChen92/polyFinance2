package com.jnshu.dto1;

public class TransactionListRPO {
    private long id;
    private int page=1;
    private int size=10;
    private String productName;
    private String contractCode;
    private Long startAtMin;
    private Long startAtMax;
    private String claimsProtocolCode;
    private Integer status;
    private Long endAtMin;
    private Long endAtMax;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getStartAtMin() {
        return startAtMin;
    }

    public void setStartAtMin(Long startAtMin) {
        this.startAtMin = startAtMin;
    }

    public Long getStartAtMax() {
        return startAtMax;
    }

    public void setStartAtMax(Long startAtMax) {
        this.startAtMax = startAtMax;
    }

    public String getClaimsProtocolCode() {
        return claimsProtocolCode;
    }

    public void setClaimsProtocolCode(String claimsProtocolCode) {
        this.claimsProtocolCode = claimsProtocolCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getEndAtMin() {
        return endAtMin;
    }

    public void setEndAtMin(Long endAtMin) {
        this.endAtMin = endAtMin;
    }

    public Long getEndAtMax() {
        return endAtMax;
    }

    public void setEndAtMax(Long endAtMax) {
        this.endAtMax = endAtMax;
    }

    @Override
    public String toString() {
        return "TransactionListRPO{" +
                "id=" + id +
                ", page=" + page +
                ", size=" + size +
                ", productName='" + productName + '\'' +
                ", contractCode='" + contractCode + '\'' +
                ", startAtMin=" + startAtMin +
                ", startAtMax=" + startAtMax +
                ", claimsProtocolCode='" + claimsProtocolCode + '\'' +
                ", status=" + status +
                ", endAtMin=" + endAtMin +
                ", endAtMax=" + endAtMax +
                '}';
    }
}
