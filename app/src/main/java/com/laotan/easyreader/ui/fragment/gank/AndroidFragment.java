package com.laotan.easyreader.ui.fragment.gank;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.GankIoAndroidAdapter;
import com.laotan.easyreader.bean.gankio.GankIoDataBean;
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
    private GankIoAndroidAdapter gankIoAndroidAdapter;

    private boolean isRefresh = false;
    @Override
    public void refreshView(List<GankIoDataBean.ResultBean> data) {
        if (isRefresh){
            srlAndroid.setRefreshing(false);
            gankIoAndroidAdapter.setEnableLoadMore(true);
            isRefresh = false;
            gankIoAndroidAdapter.setNewData(data);
        }else{
            srlAndroid.setEnabled(true);
            page++;
            gankIoAndroidAdapter.addData(data);
            gankIoAndroidAdapter.loadMoreComplete();
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
        gankIoAndroidAdapter = new GankIoAndroidAdapter(data);
        rvAndroid.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAndroid.setAdapter(gankIoAndroidAdapter);
        srlAndroid.setOnRefreshListener(this);
        gankIoAndroidAdapter.setLoadMoreView(new EasyLoadMoreView());
        gankIoAndroidAdapter.setOnLoadMoreListener(this,rvAndroid);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onRefresh() {
        page = 0;
        isRefresh =true;
        gankIoAndroidAdapter.setEnableLoadMore(false);
        mPresenter.fetchGankIoData(page,PRE_PAGE);
    }

    @Override
    public void onLoadMoreRequested() {
        if (page >= 6) {
            gankIoAndroidAdapter.loadMoreEnd();
            srlAndroid.setEnabled(true);
        } else {
           loadData();
            srlAndroid.setEnabled(false);
        }
    }
}
