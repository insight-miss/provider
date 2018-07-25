package com.weke.provider.vo;

import java.io.Serializable;

public class LearnTimeVo implements Serializable {
    private Integer studyPercent;
    private String lastLearn;
    private String mustKnow;
    private String studyTime;

    public LearnTimeVo() {

    }

    public LearnTimeVo(Integer studyPercent, String lastLearn, String mustKnow, String studyTime) {
        this.studyPercent = studyPercent;
        this.lastLearn = lastLearn;
        this.mustKnow = mustKnow;
        this.studyTime = studyTime;
    }

    public Integer getStudyPercent() {
        return studyPercent;
    }

    public void setStudyPercent(Integer studyPercent) {
        this.studyPercent = studyPercent;
    }

    public String getLastLearn() {
        return lastLearn;
    }

    public void setLastLearn(String lastLearn) {
        this.lastLearn = lastLearn;
    }

    public String getMustKnow() {
        return mustKnow;
    }

    public void setMustKnow(String mustKnow) {
        this.mustKnow = mustKnow;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    @Override
    public String toString() {
        return "LearnTimeVo{" +
                "studyPercent=" + studyPercent +
                ", lastLearn='" + lastLearn + '\'' +
                ", mustKnow='" + mustKnow + '\'' +
                ", studyTime='" + studyTime + '\'' +
                '}';
    }
}
