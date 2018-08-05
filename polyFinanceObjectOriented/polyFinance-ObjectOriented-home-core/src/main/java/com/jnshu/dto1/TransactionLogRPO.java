package com.jnshu.dto1;

/**
 * 获得交易记录接收数据对象
 */
public class TransactionLogRPO {
    private Long id;
    private int page=1;
    private int size=10;
    private String productName;
    private Long transactionAtMin;
    private Long transactionAtMax;
    private Integer status;


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getTransactionAtMin() {
        return transactionAtMin;
    }

    public void setTransactionAtMin(Long transactionAtMin) {
        this.transactionAtMin = transactionAtMin;
    }

    public Long getTransactionAtMax() {
        return transactionAtMax;
    }

    public void setTransactionAtMax(Long transactionAtMax) {
        this.transactionAtMax = transactionAtMax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransactionLogRPO{" +
                "id=" + id +
                ", page=" + page +
                ", size=" + size +
                ", productName='" + productName + '\'' +
                ", transactionAtMin=" + transactionAtMin +
                ", transactionAtMax=" + transactionAtMax +
                ", status=" + status +
                '}';
    }
}
