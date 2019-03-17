package com.psy.model;

import java.util.List;

public class Counselor {
    private Integer id;

    private String city_show;

    private String guideHours;

    private String icon;

    private String intro;

    private Integer is_follow;

    private Integer level;

    private String lowPrice;

    private Integer method;

    private String name;

    private String price_show;

    private String provinceShow;

    private Integer sex;

    private String star;

    private String title;

    private Integer years;
    
    private List<ConsultantKeyword> tags;
    
    public List<ConsultantKeyword> getTags() {
		return tags;
	}

	public void setTags(List<ConsultantKeyword> tags) {
		this.tags = tags;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity_show() {
		return city_show;
	}

	public void setCity_show(String city_show) {
		this.city_show = city_show;
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

    public Integer getIs_follow() {
		return is_follow;
	}

	public void setIs_follow(Integer is_follow) {
		this.is_follow = is_follow;
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

    public String getPrice_show() {
		return price_show;
	}

	public void setPrice_show(String price_show) {
		this.price_show = price_show;
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