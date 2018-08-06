package com.weke.provider.mongodb;

import java.io.Serializable;

public class Echar implements Serializable {

    private Integer value;
    private String name;

    public Echar() {
    }

    public Echar(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Echar{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
