package com.weke.provider.vo.recommend;

import java.io.Serializable;

public class AdCourseVo implements Serializable {

    private Integer id;
    private String courseName;
    private String imgSrc;
    private String kind;
    private String info;
    private String bleng;

    public AdCourseVo() {}

    public AdCourseVo(Integer id, String courseName, String imgSrc, String kind, String info, String bleng) {
        this.id = id;
        this.courseName = courseName;
        this.imgSrc = imgSrc;
        this.kind = kind;
        this.info = info;
        this.bleng = bleng;
    }

    @Override
    public String toString() {
        return "AdCourseVo{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", kind='" + kind + '\'' +
                ", info='" + info + '\'' +
                ", bleng='" + bleng + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBleng() {
        return bleng;
    }

    public void setBleng(String bleng) {
        this.bleng = bleng;
    }
}
