package com.laotan.easyreader.bean.wechat;

/**
 * Created by quantan.liu on 2017/3/30.
 */
public class WXHttpResponse<T> {

    private int code;
    private String msg;
    private T newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }

    @Override
    public String toString() {
        return "WXHttpResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }
}