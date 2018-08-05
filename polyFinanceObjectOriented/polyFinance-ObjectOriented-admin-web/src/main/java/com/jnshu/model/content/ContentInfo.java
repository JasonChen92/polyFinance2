package com.jnshu.model.content;

public class ContentInfo {
    private long id;
    private String title;
    private int type;
    private String bannerCover;
    private String details;
    private int status;

    public ContentInfo() {
    }

    public ContentInfo(long id, String title, int type, String bannerCover, String details, int status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.bannerCover = bannerCover;
        this.details = details;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getBannerCover() {
        return bannerCover;
    }

    public void setBannerCover(String bannerCover) {
        this.bannerCover = bannerCover;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContentInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", bannerCover='" + bannerCover + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                '}';
    }
}
