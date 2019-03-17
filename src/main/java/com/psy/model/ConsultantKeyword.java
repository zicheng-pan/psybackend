package com.psy.model;

public class ConsultantKeyword {
    private Integer id;

    private String name;

    private Integer counseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCounseId() {
        return counseId;
    }

    public void setCounseId(Integer counseId) {
        this.counseId = counseId;
    }
}