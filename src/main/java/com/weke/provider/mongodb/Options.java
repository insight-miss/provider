package com.weke.provider.mongodb;

import java.io.Serializable;

public class Options implements Serializable {
    private Integer optionNumber;
    private String optionDetails;

    public Options() {
    }

    public Options(Integer optionNumber, String optionDetails) {
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
        return "Options{" +
                "optionNumber=" + optionNumber +
                ", optionDetails='" + optionDetails + '\'' +
                '}';
    }
}
