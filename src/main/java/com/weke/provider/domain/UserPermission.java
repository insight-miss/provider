package com.weke.provider.domain;

public class UserPermission {
    private Integer id;
    private Integer user_id;
    private String permission;

    public UserPermission() {
    }

    public UserPermission(Integer id, Integer user_id, String permission) {
        this.id = id;
        this.user_id = user_id;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserPermission{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
