package com.weke.provider.vo.upload;

import java.io.Serializable;
import java.util.List;

public class UploadInfoVo implements Serializable {

    private InfoVo info;
    private List<UploadVo> catalog;

    public UploadInfoVo() {}

    public UploadInfoVo(InfoVo info, List<UploadVo> catalog) {
        this.info = info;
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "UploadInfoVo{" +
                "info=" + info +
                ", catalog=" + catalog +
                '}';
    }

    public InfoVo getInfo() {
        return info;
    }

    public void setInfo(InfoVo info) {
        this.info = info;
    }

    public List<UploadVo> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<UploadVo> catalog) {
        this.catalog = catalog;
    }
}
