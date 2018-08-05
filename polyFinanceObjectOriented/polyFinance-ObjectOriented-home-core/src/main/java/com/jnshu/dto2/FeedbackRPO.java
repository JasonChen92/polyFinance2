package com.jnshu.dto2;

public class FeedbackRPO {
    private String phoneNumber;
    private String realName;
    private Long createAt1;
    private Long createAt2;
    private String email;
    private Long id;

    public FeedbackRPO() {
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

    public Long getCreateAt1() {
        return createAt1;
    }

    public void setCreateAt1(Long createAt1) {
        this.createAt1 = createAt1;
    }

    public Long getCreateAt2() {
        return createAt2;
    }

    public void setCreateAt2(Long createAt2) {
        this.createAt2 = createAt2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FeedbackRPO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", createAt1=" + createAt1 +
                ", createAt2=" + createAt2 +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
