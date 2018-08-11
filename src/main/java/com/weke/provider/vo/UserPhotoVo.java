package com.weke.provider.vo;

import java.io.Serializable;

public class UserPhotoVo implements Serializable {

    private String photoUrl;

    public UserPhotoVo() {
    }

    public UserPhotoVo(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "UserPhotoVo{" +
                "photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
