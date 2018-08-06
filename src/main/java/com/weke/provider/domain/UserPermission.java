package com.weke.provider.domain;

public class UserPermission {
    private Integer id;
    private Integer userId;
    private String permission;

    public UserPermission() {
    }

    public UserPermission(Integer id, Integer userId, String permission) {
        this.id = id;
        this.userId = userId;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", permission='" + permission + '\'' +
                '}';
    }
}
