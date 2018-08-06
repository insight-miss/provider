package com.weke.provider.vo.exam;

import java.io.Serializable;

public class RankVo implements Serializable {
    private Integer rank;
    private String name;
    private Integer grade;
    private Integer statues;
    private String examName;

    public RankVo() {

    }

    public RankVo(Integer rank, String name, Integer grade, Integer statues, String examName) {
        this.rank = rank;
        this.name = name;
        this.grade = grade;
        this.statues = statues;
        this.examName = examName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getStatues() {
        return statues;
    }

    public void setStatues(Integer statues) {
        this.statues = statues;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "RankVo{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", statues=" + statues +
                ", examName='" + examName + '\'' +
                '}';
    }
}
