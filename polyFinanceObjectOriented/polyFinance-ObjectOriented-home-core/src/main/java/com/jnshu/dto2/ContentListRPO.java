package com.jnshu.dto2;

public class ContentListRPO {
    private String title;
    private String updateBy;
    private Long updateAt1;
    private Long updateAt2;
    private Integer status;
    private Integer type;

    public ContentListRPO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateAt1() {
        return updateAt1;
    }

    public void setUpdateAt1(Long updateAt1) {
        this.updateAt1 = updateAt1;
    }

    public Long getUpdateAt2() {
        return updateAt2;
    }

    public void setUpdateAt2(Long updateAt2) {
        this.updateAt2 = updateAt2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContentListRPO{" +
                " title='" + title + '\'' +
                ", updateBy=" + updateBy +
                ", updateAt1=" + updateAt1 +
                ", updateAt2=" + updateAt2 +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
