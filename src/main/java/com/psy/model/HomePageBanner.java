package com.psy.model;

import java.util.Date;

public class HomePageBanner {
    private Integer id;

    private String pic;

    private String link;

    private Integer linkType;

    private String appid;

    private String title;

    private String linkTypeShow;

    private Integer status;

    private String statusShow;

    private Date createTime;

    private String createTimeShow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLinkTypeShow() {
        return linkTypeShow;
    }

    public void setLinkTypeShow(String linkTypeShow) {
        this.linkTypeShow = linkTypeShow == null ? null : linkTypeShow.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow == null ? null : statusShow.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeShow() {
        return createTimeShow;
    }

    public void setCreateTimeShow(String createTimeShow) {
        this.createTimeShow = createTimeShow == null ? null : createTimeShow.trim();
    }
}