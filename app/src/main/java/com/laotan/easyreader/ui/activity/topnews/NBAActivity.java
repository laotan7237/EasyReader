package com.laotan.easyreader.ui.activity.topnews;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.laotan.easyreader.R;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.injector.component.activity.DaggerTopNewsComponent;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.presenter.NBADetailPresenter;
import com.laotan.easyreader.presenter.impl.NBADetailPresenterImpl;
import com.laotan.easyreader.ui.activity.base.LoadingBaseActivity;
import com.laotan.easyreader.utils.GlideUtils;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/4/13.
 */

public class NBAActivity extends LoadingBaseActivity<NBADetailPresenterImpl> implements NBADetailPresenter.View{

    @BindView(R.id.ht_news_content)
    HtmlTextView htNewsContent;
    private String url;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_nba_base;
    }

    @Override
    protected void loadData() {
        String id = getIntent().getStringExtra("id");//获取新闻的id
        //获取imgUrl
        url = getIntent().getStringExtra("url");
        mPresenter.fetchNBADetail(id);
    }

    @Override
    public int getContentLayoutId() {
        return  R.layout.activity_top_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
        DaggerTopNewsComponent.builder()
                .topNewsHttpModule(new TopNewsHttpModule())
                .build().injectNBA(this);
    }

    @Override
    public int setFrameLayoutId() {
        return R.id.fl_base_content;
    }
    protected ImageView detailBarImage;
    protected Toolbar toolbarZhihuDetail;
    protected TextView detailBarCopyright;
    @Override
    protected void initUI() {
        detailBarImage = (ImageView) findViewById(R.id.detail_bar_image);
        toolbarZhihuDetail = (Toolbar) findViewById(R.id.toolbar_nba_detail);
        detailBarCopyright = (TextView) findViewById(R.id.detail_bar_copyright);
        setToolBar(toolbarZhihuDetail, "");
    }

    @Override
    public void refreshView(NewsDetailBean newsDetailBean) {
        setState(AppConstants.STATE_SUCCESS);
        if (TextUtils.isEmpty(newsDetailBean.getBody())){
            return;
        }
        htNewsContent.setTextColor(getResources().getColor(R.color.bottom_text));
        htNewsContent.setHtmlFromString(newsDetailBean.getBody(), new HtmlTextView.LocalImageGetter());
        setToolBar(toolbarZhihuDetail, newsDetailBean.getTitle());
        detailBarCopyright.setText(newsDetailBean.getSource());
        GlideUtils.load(this, url, detailBarImage);
    }
}
