package com.jnshu.dto1;

import java.util.Arrays;

/**
 * 获得指定债权匹配列表接收传参实体类
 */
public class ClaimsMatchingRPO {
    private Long id;
    private int page=1;
    private int size=10;
    private Long productId;
    private String productName;
    private Long userId[];
    private String userName;
    private Long startAtMin;
    private Long startAtMax;
    private Long endAtMin;
    private Long endAtMax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long[] getUserId() {
        return userId;
    }

    public void setUserId(Long[] userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "ClaimsMatchingRPO{" +
                "id=" + id +
                ", page=" + page +
                ", size=" + size +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", userId=" + Arrays.toString(userId) +
                ", userName='" + userName + '\'' +
                ", startAtMin=" + startAtMin +
                ", startAtMax=" + startAtMax +
                ", endAtMin=" + endAtMin +
                ", endAtMax=" + endAtMax +
                '}';
    }
}
