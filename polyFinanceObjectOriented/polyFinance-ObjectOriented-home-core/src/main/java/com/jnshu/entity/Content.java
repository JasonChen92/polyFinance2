package com.jnshu.entity;

import java.io.Serializable;

/**
 * 聚金融content表对应实体类
 */
public class Content implements Serializable {
    private static final long serialVersionUID = 310712541617581588L;
    /**
     * 类型，banner推荐
     */
    public static final Integer TYPE_BANNER=0;
    /**
     *类型，帮助中心
     */
    public static final Integer TYPE_HELP=1;
    /**
     *类型，关于我们
     */
    public static final Integer TYPE_ABOUT_US=2;
    /**
     *状态，存为草稿
     */
    public static final Integer STATUS_DRAFT=0;
    /**
     *状态，上线
     */
    public static final Integer STATUS_ONLINE=1;
    private long id;
    private long createAt;
    private long createBy;
    private long updateAt;
    private long updateBy;
    private String title;
    //类型，0：banner推荐，1：帮助中心，2：关于我们
    private int type;
    //状态，0：草稿，1：已上线，默认0
    private int status=0;
    private String details;
    private String bannerCover;

    public Long getId() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBannerCover() {
        return bannerCover;
    }

    public void setBannerCover(String bannerCover) {
        this.bannerCover = bannerCover;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", details='" + details + '\'' +
                ", bannerCover='" + bannerCover + '\'' +
                '}';
    }
}
