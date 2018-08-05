package com.jnshu.dto2;

public class ApplicationListRPO {
    private String phoneNumber;
    private String realName;
    private Long createAt1;
    private Long createAt2;
    private String userNumber;
    private Integer applicationStatus;

    public ApplicationListRPO() {
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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "ApplicationListRPO{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", createAt1=" + createAt1 +
                ", createAt2=" + createAt2 +
                ", userNumber='" + userNumber + '\'' +
                ", applicationStatus=" + applicationStatus +
                '}'+"\n";
    }
}
