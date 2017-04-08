package com.laotan.easyreader.ui.activity.topnews;

import android.text.TextUtils;

import com.laotan.easyreader.R;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.bean.topnews.NewsListBean;
import com.laotan.easyreader.injector.component.activity.DaggerTopNewsComponent;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.presenter.TopNewsPresenter;
import com.laotan.easyreader.presenter.impl.TopNewsPresenterImpl;
import com.laotan.easyreader.ui.activity.base.ZhihuDetailBaseActivity;
import com.laotan.easyreader.utils.GlideUtils;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/3/28.
 * 这个页面比较特殊没有用到之前的网络请求
 * 所以大家可以忽略这个页面不看。
 */

public class TopNewsActivity extends ZhihuDetailBaseActivity<TopNewsPresenterImpl> implements TopNewsPresenter.ViewActivity {

    @BindView(R.id.ht_news_content)
    HtmlTextView htNewsContent;
    private String url;

    @Override
    protected void loadData() {
        String id = getIntent().getStringExtra("id");//获取新闻的id
        //获取imgUrl
        url = getIntent().getStringExtra("url");
        mPresenter.getDescrible(id);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_top_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
        DaggerTopNewsComponent.builder()
                .topNewsHttpModule(new TopNewsHttpModule())
                .build().injectTopNews(this);
    }


    @Override
    public void refreshView(NewsListBean data) {

    }

    @Override
    public void refreshActivityView(NewsDetailBean newsDetailBean) {
        setState(AppConstants.STATE_SUCCESS);
        if (TextUtils.isEmpty(newsDetailBean.getBody())){
            return;
        }
        htNewsContent.setHtmlFromString(newsDetailBean.getBody(), new HtmlTextView.LocalImageGetter());
        setToolBar(toolbarZhihuDetail, newsDetailBean.getTitle());
        detailBarCopyright.setText(newsDetailBean.getSource());
        GlideUtils.load(this, url, detailBarImage);
    }
}
