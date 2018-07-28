package com.weke.provider.vo.exam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Option implements Serializable {
    @JsonProperty("_optionNumber")
    private Integer optionNumber;
    @JsonProperty("_optionDetails")
    private String optionDetails;

    public Option() {
    }

    public Option(Integer optionNumber, String optionDetails) {
        this.optionNumber = optionNumber;
        this.optionDetails = optionDetails;
    }

    public Integer getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(Integer optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionDetails() {
        return optionDetails;
    }

    public void setOptionDetails(String optionDetails) {
        this.optionDetails = optionDetails;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionNumber=" + optionNumber +
                ", optionDetails='" + optionDetails + '\'' +
                '}';
    }
}
