package com.jnshu.Domain2;

public class DomainFeedBackDetail {
    private Long id;
    private String phoneNumber;
    private String realName;
    private String email;
    private String FeedbackContent;

    public DomainFeedBackDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return FeedbackContent;
    }

    public void setContents(String content) {
        this.FeedbackContent = content;
    }

    @Override
    public String toString() {
        return "DomainFeedBackDetail{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", FeedbackContent='" + FeedbackContent + '\'' +
                '}';
    }
}
