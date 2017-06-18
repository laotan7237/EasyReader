package com.laotan.easyreader.ui.activity.douban;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.ConvertUtils;
import com.bumptech.glide.Glide;
import com.laotan.easyreader.R;
import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.bean.douban.PersonBean;
import com.laotan.easyreader.injector.component.activity.DaggerMovieDetailComponent;
import com.laotan.easyreader.injector.module.http.DoubanHttpModule;
import com.laotan.easyreader.presenter.DoubanMovieDetailPresenter;
import com.laotan.easyreader.presenter.impl.DoubanMovieDetailPresenterImpl;
import com.laotan.easyreader.ui.activity.base.LoadingBaseActivity;
import com.laotan.easyreader.utils.GlideUtils;
import com.laotan.easyreader.utils.StringFormatUtil;
import com.laotan.easyreader.view.HorizontalScrollView;
import com.laotan.easyreader.webview.WebViewActivity;

import java.util.List;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class MovieTopDetailActivity extends LoadingBaseActivity<DoubanMovieDetailPresenterImpl> implements DoubanMovieDetailPresenter.View {

    private ImageView ivBaseTitlebarBg;
    private Toolbar toolbarDoubanDetail;
    private ImageView ivOnePhoto;
    private TextView tvOneRatingRate;
    private TextView tvOneRatingNumber;
    private TextView tvOneGenres;
    private TextView tvOneDay;
    private TextView tvOneCity;
    private HotMovieBean.SubjectsBean subjectsBean;
    private String id;


    @BindView(R.id.nsv_movie_top_detail)
    NestedScrollView nsvMovieTopDetail;

    @BindView(R.id.hs_film)
    HorizontalScrollView hsFilm;

    @BindView(R.id.tv_movie_top_detail)
    TextView tvMovieTopDetail;
    private String mMoreUrl;
    private String mMovieName;
    private TextView tvFormerly;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_top_detail;
    }

    @Override
    protected void loadData() {
        if (!TextUtils.isEmpty(id))
            mPresenter.fetchMovieDetail(id);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_movie_top;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
        DaggerMovieDetailComponent.builder()
                .doubanHttpModule(new DoubanHttpModule())
                .build().injectMovieDetail(this);
    }

    @Override
    public int setFrameLayoutId() {
        return R.id.fl_douban_detail_content;
    }


    @Override
    protected void initUI() {
        final AppBarLayout appbarMovieTopChild = (AppBarLayout) findViewById(R.id.appbar_movie_top_child);
        ivBaseTitlebarBg = (ImageView) findViewById(R.id.img_item_bg);
        ivOnePhoto = (ImageView) findViewById(R.id.iv_one_photo);
        tvOneRatingRate = (TextView) findViewById(R.id.tv_one_rating_rate);
        tvOneRatingNumber = (TextView) findViewById(R.id.tv_one_rating_number);
        tvOneGenres = (TextView) findViewById(R.id.tv_one_genres);
        tvOneDay = (TextView) findViewById(R.id.tv_one_day);
        tvOneCity = (TextView) findViewById(R.id.tv_one_city);
        tvFormerly = (TextView) findViewById(R.id.tv_formerly);
        toolbarDoubanDetail = (Toolbar) findViewById(R.id.toolbar_douban_detail);
        initToolBar(toolbarDoubanDetail, "");
        appbarMovieTopChild.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (appbarMovieTopChild.getBottom() > toolbarDoubanDetail.getBottom() ) {
                    toolbarDoubanDetail.setBackgroundColor(getResources().getColor(R.color.translucent));
                } else {
                    toolbarDoubanDetail.setBackgroundResource(R.color.colorTheme);
                }
            }
        });
        subjectsBean = (HotMovieBean.SubjectsBean) getIntent().getSerializableExtra("bean");
        if (subjectsBean != null) {
            toolbarDoubanDetail.setTitle(subjectsBean.getTitle());
            toolbarDoubanDetail.setSubtitleTextColor(Color.WHITE);
            setImgHeaderBg(subjectsBean.getImages().getMedium());
            GlideUtils.loadMovieTopImg(ivOnePhoto, subjectsBean.getImages().getLarge());
            tvOneRatingRate.setText("评分：" + subjectsBean.getRating().getAverage());
            tvOneGenres.setText("类型：" + StringFormatUtil.formatGenres(subjectsBean.getGenres()));
            tvOneDay.setText("上映日期：" + subjectsBean.getYear());
            //电影详情的id
            id = subjectsBean.getId();
        }

    }

    private void initToolBar(Toolbar toolbarDoubanDetail, String title) {
        setSupportActionBar(toolbarDoubanDetail);
        toolbarDoubanDetail.setTitle(title);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.icon_back);
        }
        toolbarDoubanDetail.setTitleTextColor(Color.WHITE);
        toolbarDoubanDetail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbarDoubanDetail.setTitleTextAppearance(this, R.style.ToolBar_Title);
        toolbarDoubanDetail.setSubtitleTextAppearance(this, R.style.Toolbar_SubTitle);
        toolbarDoubanDetail.inflateMenu(R.menu.base_header_menu);
        toolbarDoubanDetail.setOverflowIcon(getResources().getDrawable(R.mipmap.actionbar_more));
        toolbarDoubanDetail.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actionbar_more:// 更多信息
                        setTitleClickMore();
                        break;
                }
                return true;
            }
        });
    }

    private void setTitleClickMore() {
        WebViewActivity.loadUrl(MovieTopDetailActivity.this, mMoreUrl, mMovieName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_header_menu, menu);
        return true;
    }

    @Override
    public void refreshView(MovieDetailBean data) {
        mMoreUrl = data.getAlt();
        mMovieName = data.getTitle();
        tvFormerly.setText("原名：" + data.getOriginal_title());
        tvOneRatingNumber.setText(data.getRatings_count() + "人评分");
        tvOneCity.setText("制作国家/地区：" + data.getCountries() + "");

        List<PersonBean> castsList = data.getCasts();
        for (final PersonBean personBean : castsList) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ConvertUtils.dp2px(120), ConvertUtils.dp2px(200)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            GlideUtils.loadMovieTopImg(imageView,personBean.getAvatars().getLarge());
            hsFilm.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebViewActivity.loadUrl(MovieTopDetailActivity.this,personBean.getAlt(),"加载中。。。");
                }
            });
        }
        tvMovieTopDetail.setText(data.getSummary());
    }

    /**
     * 加载titlebar背景
     */
    private void setImgHeaderBg(String imgUrl) {
        if (!TextUtils.isEmpty(imgUrl)) {
            // 高斯模糊背景  参数：12,5
            Glide.with(this).load(imgUrl)
                    .error(R.mipmap.stackblur_default)
                    .bitmapTransform(new BlurTransformation(this, 12, 5)).into(ivBaseTitlebarBg);
        }
    }

}
