package com.laotan.easyreader.ui.activity.topnews;

import android.graphics.Bitmap;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.laotan.easyreader.R;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.injector.component.activity.DaggerTopNewsComponent;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.presenter.NBADetailPresenter;
import com.laotan.easyreader.presenter.impl.NBADetailPresenterImpl;
import com.laotan.easyreader.ui.activity.base.LoadingBaseActivity;
import com.laotan.easyreader.utils.ColorUtils;
import com.laotan.easyreader.utils.ShareUtils;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/4/13.
 */

public class NBAActivity extends LoadingBaseActivity<NBADetailPresenterImpl> implements NBADetailPresenter.View {

    @BindView(R.id.ht_news_content)
    HtmlTextView htNewsContent;
    private String url;
    private CollapsingToolbarLayout clptoolbar;
    private FloatingActionButton fabNBA;

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
        return R.layout.activity_top_news;
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
        clptoolbar = (CollapsingToolbarLayout) findViewById(R.id.clp_toolbar);
        fabNBA = (FloatingActionButton) findViewById(R.id.fab_nba);

        setToolBar(toolbarZhihuDetail, "");
    }

    @Override
    public void refreshView(final NewsDetailBean newsDetailBean) {
        setState(AppConstants.STATE_SUCCESS);
        if (!TextUtils.isEmpty(newsDetailBean.getBody())) {
            htNewsContent.setHtmlFromString(newsDetailBean.getBody(), new HtmlTextView.LocalImageGetter());
            setToolBar(toolbarZhihuDetail, newsDetailBean.getTitle());
            detailBarCopyright.setText(newsDetailBean.getSource());
            Glide.with(this).load(url).asBitmap()
                    .priority(Priority.IMMEDIATE).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                    detailBarImage.setImageBitmap(resource);
                    new Palette.Builder(resource).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            Palette.Swatch swatch = ColorUtils.getMostPopulousSwatch(palette);
                            if (swatch != null) {
                                int color = swatch.getRgb();
                                clptoolbar.setContentScrimColor(color);
                                clptoolbar.setStatusBarScrimColor(ColorUtils.getStatusBarColor(color));
                            }
                        }
                    });
                }
            });
        }

        fabNBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.shareText(NBAActivity.this,newsDetailBean.getSource(),newsDetailBean.getTitle());
            }
        });
    }

}
