package com.weke.provider.domain;

public class Recommend {
    
    private Integer recommendId;
    private Integer courseId;
    private String recommendBelong;

    public Recommend() {}
    
    public Recommend(Integer recommendId, Integer courseId, String recommendBelong) {
        this.recommendId = recommendId;
        this.courseId = courseId;
        this.recommendBelong = recommendBelong;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendId=" + recommendId +
                ", courseId=" + courseId +
                ", recommendBelong='" + recommendBelong + '\'' +
                '}';
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getrecommendBelong() {
        return recommendBelong;
    }

    public void setrecommendBelong(String recommendBelong) {
        this.recommendBelong = recommendBelong;
    }
}
