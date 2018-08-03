package com.weke.provider.vo.exam;

import java.io.Serializable;

public class Analysis implements Serializable {
    private Integer testId;
    private String userName;

    public Analysis() {

    }

    public Analysis(Integer testId, String userName) {
        this.testId = testId;
        this.userName = userName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AnalySic{" +
                "testId=" + testId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
