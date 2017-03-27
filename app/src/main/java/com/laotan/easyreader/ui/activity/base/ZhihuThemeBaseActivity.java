package com.laotan.easyreader.ui.activity.base;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.laotan.easyreader.R;
import com.laotan.easyreader.http.Stateful;
import com.laotan.easyreader.presenter.BasePresenter;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public abstract class ZhihuThemeBaseActivity<T extends BasePresenter> extends LoadingBaseActivity<T> implements Stateful{

    protected Toolbar toolbarThemeBase;
    protected AppBarLayout appbarThemeChild;
    protected ImageView ivThemeChildBlur;
    protected ImageView ivThemeChildOrigin;
    protected TextView tvThemeChildDes;
    protected SwipeRefreshLayout swipeRefresh;

    @Override
    public int setFrameLayoutId() {
        return R.id.fl_base_theme_content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihu_theme_base;
    }

    @Override
    protected void initUI() {
        toolbarThemeBase = (Toolbar) findViewById(R.id.toolbar_theme_base);
        appbarThemeChild = (AppBarLayout) findViewById(R.id.appbar_theme_child);
        ivThemeChildBlur = (ImageView) findViewById(R.id.iv_theme_child_blur);
        ivThemeChildOrigin = (ImageView) findViewById(R.id.iv_theme_child_origin);
        tvThemeChildDes = (TextView) findViewById(R.id.tv_theme_child_des);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        setToolBar(toolbarThemeBase,"");
    }
}
