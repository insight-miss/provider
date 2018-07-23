package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 方向详情页面返回数据
 */
public class DirectionDetailsVo implements Serializable {

    @JsonProperty("direction")
    private List<Direction_vo> direction_vo;

    @JsonProperty("diff")
    private List<String> courseDiff;

    @JsonProperty("course")
    private List<CourseVo> courseVos;

    public DirectionDetailsVo() {
    }

    public DirectionDetailsVo(List<Direction_vo> direction_vo, List<String> courseDiff, List<CourseVo> courseVos) {
        this.direction_vo = direction_vo;
        this.courseDiff = courseDiff;
        this.courseVos = courseVos;
    }

    public List<Direction_vo> getDirection_vo() {
        return direction_vo;
    }

    public void setDirection_vo(List<Direction_vo> direction_vo) {
        this.direction_vo = direction_vo;
    }

    public List<String> getCourseDiff() {
        return courseDiff;
    }

    public void setCourseDiff(List<String> courseDiff) {
        this.courseDiff = courseDiff;
    }

    public List<CourseVo> getCourseVos() {
        return courseVos;
    }

    public void setCourseVos(List<CourseVo> courseVos) {
        this.courseVos = courseVos;
    }

    @Override
    public String toString() {
        return "DirectionDetailsVo{" +
                "direction_vo=" + direction_vo +
                ", courseDiff=" + courseDiff +
                ", courseVos=" + courseVos +
                '}';
    }
}
