package com.jnshu.model.content;

public class Content {
    private long id;
    private String title;
    private int type;
    private int status;
    private String loginName;
    private long updateAt;

    public Content() {
    }

    public Content(long id, String title, int type, int status, String loginName, long updateAt) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.status = status;
        this.loginName = loginName;
        this.updateAt = updateAt;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", loginName='" + loginName + '\'' +
                ", updateAt=" + updateAt +
                '}';
    }
}
