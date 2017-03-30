package com.laotan.easyreader.bean.douban;

import com.laotan.easyreader.http.ParamNames;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class PersonBean {
    @ParamNames("alt")
    private String alt;

    // 导演或演员
    @ParamNames("type")
    private String type;

    @ParamNames("avatars")
    private HotMovieBean.SubjectsBean.ImagesBean avatars;
    @ParamNames("name")
    private String name;
    @ParamNames("id")
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HotMovieBean.SubjectsBean.ImagesBean getAvatars() {
        return avatars;
    }

    public void setAvatars(HotMovieBean.SubjectsBean.ImagesBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "alt='" + alt + '\'' +
                ", type='" + type + '\'' +
                ", avatars=" + avatars +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
