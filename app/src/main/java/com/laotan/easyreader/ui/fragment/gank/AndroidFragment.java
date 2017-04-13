package com.laotan.easyreader.ui.fragment.gank;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laotan.easyreader.R;
import com.laotan.easyreader.bean.gankio.GankIoDataBean;
import com.laotan.easyreader.injector.component.fragment.DaggerAndroidComponent;
import com.laotan.easyreader.injector.module.fragment.AndroidModule;
import com.laotan.easyreader.injector.module.http.GankIoHttpModule;
import com.laotan.easyreader.presenter.GankIoAndroidPresenter;
import com.laotan.easyreader.presenter.impl.GankIoAndroidPresenterImpl;
import com.laotan.easyreader.ui.fragment.BaseFragment;
import com.laotan.easyreader.view.EasyLoadMoreView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class AndroidFragment extends BaseFragment<GankIoAndroidPresenterImpl> implements GankIoAndroidPresenter.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_android)
    RecyclerView rvAndroid;

    @BindView(R.id.srl_android)
    SwipeRefreshLayout srlAndroid;

    private int page;
    private final static int PRE_PAGE = 10;
    private List<GankIoDataBean.ResultBean> data;

    private boolean isRefresh = false;
    @Override
    public void refreshView(List<GankIoDataBean.ResultBean> data) {
        if (isRefresh){
            srlAndroid.setRefreshing(false);
            mAdapter.setEnableLoadMore(true);
            isRefresh = false;
            mAdapter.setNewData(data);
        }else{
            srlAndroid.setEnabled(true);
            page++;
            mAdapter.addData(data);
            mAdapter.loadMoreComplete();
        }
    }

    @Override
    protected void loadData() {
        mPresenter.fetchGankIoData(page,PRE_PAGE);
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
        mAdapter.setOnLoadMoreListener(this,rvAndroid);
    }

    @Override
    protected void initInject() {
        DaggerAndroidComponent.builder()
                .gankIoHttpModule(new GankIoHttpModule())
                .androidModule(new AndroidModule())
                .build().injectAndroid(this);
    }

    @Override
    public void onRefresh() {
        page = 0;
        isRefresh =true;
        mAdapter.setEnableLoadMore(false);
        mPresenter.fetchGankIoData(page,PRE_PAGE);
    }

    @Override
    public void onLoadMoreRequested() {
        if (page >= 6) {
            mAdapter.loadMoreEnd();
            srlAndroid.setEnabled(true);
        } else {
           loadData();
            srlAndroid.setEnabled(false);
        }
    }
}
