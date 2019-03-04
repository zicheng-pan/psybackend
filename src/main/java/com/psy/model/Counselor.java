package com.psy.model;

public class Counselor {
    private Integer id;

    private String cityShow;

    private String guideHours;

    private String icon;

    private String intro;

    private Integer isFollow;

    private Integer level;

    private String lowPrice;

    private Integer method;

    private String name;

    private String priceShow;

    private String provinceShow;

    private Integer sex;

    private String star;

    private String title;

    private Integer years;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityShow() {
        return cityShow;
    }

    public void setCityShow(String cityShow) {
        this.cityShow = cityShow == null ? null : cityShow.trim();
    }

    public String getGuideHours() {
        return guideHours;
    }

    public void setGuideHours(String guideHours) {
        this.guideHours = guideHours == null ? null : guideHours.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice == null ? null : lowPrice.trim();
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPriceShow() {
        return priceShow;
    }

    public void setPriceShow(String priceShow) {
        this.priceShow = priceShow == null ? null : priceShow.trim();
    }

    public String getProvinceShow() {
        return provinceShow;
    }

    public void setProvinceShow(String provinceShow) {
        this.provinceShow = provinceShow == null ? null : provinceShow.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }
}