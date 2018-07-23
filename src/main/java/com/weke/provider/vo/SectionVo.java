package com.weke.provider.vo;

import java.io.Serializable;
import java.util.List;

public class SectionVo implements Serializable {
    private String title;
    private List<String> course;

    public SectionVo() {
    }

    public SectionVo(String title, List<String> course) {
        this.title = title;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "SectionVo{" +
                "title='" + title + '\'' +
                ", course=" + course +
                '}';
    }
}
