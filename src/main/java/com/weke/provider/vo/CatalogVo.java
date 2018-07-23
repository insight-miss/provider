package com.weke.provider.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import sun.swing.SwingUtilities2;

import java.io.Serializable;
import java.util.List;

public class CatalogVo implements Serializable {

    @JsonProperty("info")
    private String info;

    @JsonProperty("section")
    private List<SectionVo> sectionVos;

    public CatalogVo() {
    }

    public CatalogVo(String info, List<SectionVo> sectionVos) {
        this.info = info;
        this.sectionVos = sectionVos;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<SectionVo> getSectionVos() {
        return sectionVos;
    }

    public void setSectionVos(List<SectionVo> sectionVos) {
        this.sectionVos = sectionVos;
    }

    @Override
    public String toString() {
        return "CatalogVo{" +
                "info='" + info + '\'' +
                ", sectionVos=" + sectionVos +
                '}';
    }
}
