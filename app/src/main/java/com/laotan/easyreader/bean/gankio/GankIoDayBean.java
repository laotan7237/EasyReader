package com.laotan.easyreader.bean.gankio;


import com.laotan.easyreader.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by quantan.liu on 2017/3/22.
 */
public class GankIoDayBean implements Serializable {

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public static class ResultsBean {   
        /**
         * _id : 56cc6d23421aa95caa707a69
         * createdAt : 2015-08-06T07:15:52.65Z
         * desc : 类似Link Bubble的悬浮式操作设计
         * images : ["http://img.gank.io/2f0b6c5f-6de7-4ba3-94ad-98bf721ee447"]
         * source : web
         * publishedAt : 2015-08-07T03:57:48.45Z
         * type : Android
         * url : https://github.com/recruit-lifestyle/FloatingView
         * used : true
         * who : mthli
         */

        @ParamNames("Android")
        private List<AndroidBean> Android;

        @ParamNames("iOS")
        private List<AndroidBean> iOS;

        @ParamNames("前端")
        private List<AndroidBean> front;

        @ParamNames("App")
        private List<AndroidBean> app;

        @ParamNames("休息视频")
        private List<AndroidBean> restMovie;

        @ParamNames("拓展资源")
        private List<AndroidBean> resource;

        @ParamNames("瞎推荐")
        private List<AndroidBean> recommend;

        @ParamNames("福利")
        private List<AndroidBean> welfare;


        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public List<AndroidBean> getiOS() {
            return iOS;
        }

        public List<AndroidBean> getRestMovie() {
            return restMovie;
        }

        public List<AndroidBean> getResource() {
            return resource;
        }

        public List<AndroidBean> getRecommend() {
            return recommend;
        }

        public List<AndroidBean> getWelfare() {
            return welfare;
        }

        public List<AndroidBean> getFront() {
            return front;
        }

        public List<AndroidBean> getApp() {
            return app;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "Android=" + Android +
                    ", iOS=" + iOS +
                    ", front=" + front +
                    ", app=" + app +
                    ", restMovie=" + restMovie +
                    ", resource=" + resource +
                    ", recommend=" + recommend +
                    ", welfare=" + welfare +
                    '}';
        }
    }

    public boolean isError() {
        return error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public List<String> getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "GankIoDayBean{" +
                "error=" + error +
                ", results=" + results +
                ", category=" + category +
                '}';
    }
}
