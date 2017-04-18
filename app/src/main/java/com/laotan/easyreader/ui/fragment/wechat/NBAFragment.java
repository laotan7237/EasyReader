package com.laotan.easyreader.ui.fragment.wechat;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.NBAAdapter;
import com.laotan.easyreader.bean.topnews.NBAListBean;
import com.laotan.easyreader.injector.component.fragment.DaggerNBAComponent;
import com.laotan.easyreader.injector.module.fragment.NBAModule;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.presenter.NBAPresenter;
import com.laotan.easyreader.presenter.impl.NBAPresenterImpl;
import com.laotan.easyreader.ui.activity.topnews.NBAActivity;
import com.laotan.easyreader.ui.fragment.BaseFragment;
import com.laotan.easyreader.view.EasyLoadMoreView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/4/12.
 */

public class NBAFragment extends BaseFragment<NBAPresenterImpl> implements NBAPresenter.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_android)
    RecyclerView rvAndroid;

    @BindView(R.id.srl_android)
    SwipeRefreshLayout srlAndroid;

    private boolean isRefresh = false;


    private int index = 0;

    @Override
    protected void loadData() {
        mPresenter.fetchNBAList(index);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_android;
    }

    @Override
    protected void initView() {
        srlAndroid.setColorSchemeColors(getResources().getColor(R.color.colorTheme));
        rvAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAndroid.setAdapter(mAdapter);
        srlAndroid.setOnRefreshListener(this);
        mAdapter.setLoadMoreView(new EasyLoadMoreView());
        mAdapter.setOnLoadMoreListener(this, rvAndroid);

        ((NBAAdapter)mAdapter).setOnItemClickListener(new NBAAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(String id, String imgUrl, View view) {
                startNBADetailActivity(id, imgUrl, view);
            }
        });
    }

    private void startNBADetailActivity(String id, String imgUrl, View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), NBAActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", imgUrl);
        /**
         * 用这个ActivityOptionsCompat比用ActivityOptions兼容性更好，前者是V4下的兼容到16后者到21.
         * ActivityOptionsCompat.makeSceneTransitionAnimation(）的第三个参数则是跳转后图片显示的transitionName的值
         *     <android.support.design.widget.AppBarLayout
         android:transitionName="zhihu_detail_title"
         android:fitsSystemWindows="true">
         */
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                view, getActivity().getResources().getString(R.string.zhihu_detail_title));
        getActivity().startActivity(intent, options.toBundle());
    }
    @Override
    protected void initInject() {
        DaggerNBAComponent.builder()
                .topNewsHttpModule(new TopNewsHttpModule())
                .nBAModule(new NBAModule())
                .build().injectNBA(this);
    }

    @Override
    public void onRefresh() {
        index = 0;
        isRefresh = true;
        mAdapter.setEnableLoadMore(false);
        mPresenter.fetchNBAList(index);
    }

    @Override
    public void onLoadMoreRequested() {
        if (index >= 60) {
            mAdapter.loadMoreEnd();
            srlAndroid.setEnabled(true);
        } else {
            loadData();
            srlAndroid.setEnabled(false);
        }
    }

    @Override
    public void refreshView(NBAListBean mData) {
        List<NBAListBean.NBABean> nbaBeenList = mData.getT1348649145984();
        if (isRefresh) {
            srlAndroid.setRefreshing(false);
            mAdapter.setEnableLoadMore(true);
            isRefresh = false;
            mAdapter.setNewData(nbaBeenList);
        } else {
            srlAndroid.setEnabled(true);
            index += 20;
            mAdapter.addData(nbaBeenList);
            mAdapter.loadMoreComplete();
        }
    }
}
