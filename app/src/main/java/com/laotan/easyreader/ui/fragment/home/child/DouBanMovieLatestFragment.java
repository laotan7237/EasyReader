package com.laotan.easyreader.ui.fragment.home.child;

import android.animation.Animator;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.animation.BaseAnimation;
import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.MovieLatestAdapter;
import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.injector.component.fragment.DaggerDoubanMovieLatestComponent;
import com.laotan.easyreader.injector.module.fragment.DoubanMovieLatestModule;
import com.laotan.easyreader.injector.module.http.DoubanHttpModule;
import com.laotan.easyreader.presenter.DoubanHotMoviePresenter;
import com.laotan.easyreader.presenter.impl.DoubanHotMoviePresenterImpl;
import com.laotan.easyreader.ui.activity.douban.MovieTopDetailActivity;
import com.laotan.easyreader.ui.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class DouBanMovieLatestFragment extends BaseFragment<DoubanHotMoviePresenterImpl> implements DoubanHotMoviePresenter.View {

    @BindView(R.id.rcv_activity)
    RecyclerView rcvActivity;
    private List<HotMovieBean.SubjectsBean> subjectsBeanList;

    @Override
    public void refreshView(HotMovieBean data) {
        subjectsBeanList = data.getSubjects();
        mPresenter.checkState(subjectsBeanList);
        mAdapter.addData(subjectsBeanList);
    }

    @Override
    protected void loadData() {
        mPresenter.fetchHotMovie();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void initView() {
        rcvActivity.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvActivity.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                };
            }
        });
        ((MovieLatestAdapter) mAdapter).setOnItemClickListener(new MovieLatestAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(HotMovieBean.SubjectsBean positionData, View view) {
                startZhiHuDetailActivity(positionData, view);
            }
        });
    }

    @Override
    protected void initInject() {
        DaggerDoubanMovieLatestComponent.builder()
                .doubanHttpModule(new DoubanHttpModule())
                .doubanMovieLatestModule(new DoubanMovieLatestModule())
                .build().injectDoubanMovieLatest(this);
    }

    private void startZhiHuDetailActivity(HotMovieBean.SubjectsBean positionData, View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), MovieTopDetailActivity.class);
        intent.putExtra("bean", positionData);
        /**
         * 用这个ActivityOptionsCompat比用ActivityOptions兼容性更好，前者是V4下的兼容到16后者到21.
         * ActivityOptionsCompat.makeSceneTransitionAnimation(）的第三个参数则是跳转后图片显示的transitionName的值
         *     <android.support.design.widget.AppBarLayout
         android:transitionName="zhihu_detail_title"
         android:fitsSystemWindows="true">
         跳转到目标ImageView不能是addview进来的
         */
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                view, getActivity().getResources().getString(R.string.douban_detail_iamge));
        getActivity().startActivity(intent, options.toBundle());
    }
}
