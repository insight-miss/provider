package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ProblemPageVo implements Serializable {

    @JsonProperty("comments")
    private List<ProblemReviewVo> problemReviewVos;

    @JsonProperty("learnTime")
    private LearnTimeVo learnTimeVo;

    public ProblemPageVo() {
    }

    public ProblemPageVo(List<ProblemReviewVo> problemReviewVos, LearnTimeVo learnTimeVo) {
        this.problemReviewVos = problemReviewVos;
        this.learnTimeVo = learnTimeVo;
    }

    public List<ProblemReviewVo> getProblemReviewVos() {
        return problemReviewVos;
    }

    public void setProblemReviewVos(List<ProblemReviewVo> problemReviewVos) {
        this.problemReviewVos = problemReviewVos;
    }

    public LearnTimeVo getLearnTimeVo() {
        return learnTimeVo;
    }

    public void setLearnTimeVo(LearnTimeVo learnTimeVo) {
        this.learnTimeVo = learnTimeVo;
    }

    @Override
    public String toString() {
        return "ProblemPageVo{" +
                "problemReviewVos=" + problemReviewVos +
                ", learnTimeVo=" + learnTimeVo +
                '}';
    }
}
