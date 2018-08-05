package com.jnshu.dto1;

/**
 * 销量统计接收分页数据对象
 */
public class StatisticsSalesListRPO {
    private int page=1;
    private int size=10;
    private String productName;
    private String productCode;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "StatisticsSalesListRPO{" +
                "page=" + page +
                ", size=" + size +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
