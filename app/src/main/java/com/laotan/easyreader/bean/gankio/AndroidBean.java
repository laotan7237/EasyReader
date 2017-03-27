package com.laotan.easyreader.bean.gankio;


import com.laotan.easyreader.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by quantan.liu on 2017/3/22.
 * 首页item
 */

public class AndroidBean implements Serializable {

    // 存储单独设置的值，用来显示title
    @ParamNames("type_title")
    private String type_title;

    @ParamNames("_id")
    private String _id;
    @ParamNames("createdAt")
    private String createdAt;
    @ParamNames("desc")
    private String desc;
    @ParamNames("publishedAt")
    private String publishedAt;
    @ParamNames("type")
    private String type;
    @ParamNames("url")
    private String url;
    @ParamNames("used")
    private boolean used;
    @ParamNames("who")
    private String who;

    @ParamNames("source")
    private String source;
    @ParamNames("images")
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public boolean isUsed() {
        return used;
    }

    public String getWho() {
        return who;
    }

    public String getSource() {
        return source;
    }

    public List<String> getImages() {
        return images;
    }

    public String getType_title() {
        return type_title;
    }

    public void setType_title(String type_title) {
        this.type_title = type_title;
    }

    @Override
    public String toString() {
        return "AndroidBean{" +
                "type_title='" + type_title + '\'' +
                ", _id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                ", source='" + source + '\'' +
                ", images=" + images +
                '}';
    }
}
