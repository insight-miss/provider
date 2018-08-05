package com.weke.provider.vo.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weke.provider.mongodb.Question;

import java.io.Serializable;
import java.util.List;

public class ShortVo implements Serializable {

    @JsonProperty("shortNumber")
    private Integer totalNumber;

    @JsonProperty("shortQuestion")
    private List<Question> questions;

    public ShortVo() {

    }

    public ShortVo(Integer totalNumber, List<Question> questions) {
        this.totalNumber = totalNumber;
        this.questions = questions;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ShortVo{" +
                "totalNumber=" + totalNumber +
                ", questions=" + questions +
                '}';
    }
}
