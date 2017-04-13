package com.laotan.easyreader.ui.fragment.home;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.HomeFragmentPageAdapter;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.ui.fragment.BaseFragment;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieLatestFragment;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieTopFragment;
import com.laotan.easyreader.ui.fragment.home.child.TopNewsFragment;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuHomeFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab_gank)
    TabLayout tabGank;
    @BindView(R.id.vp_gank)
    ViewPager vpGank;

    private ArrayList<String> mTitleList = new ArrayList<>(4);
    private ArrayList<Fragment> mFragments = new ArrayList<>(4);
    private HomeFragmentPageAdapter myAdapter;

    @Override
    protected void loadData() {
        setState(AppConstants.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        initFragmentList();
        myAdapter = new HomeFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vpGank.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpGank);
    }

    @Override
    protected void initInject() {
    }

    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("知乎日报");
        mTitleList.add("头条新闻");
        mTitleList.add("排行榜");
        mTitleList.add("最新电影");
        mFragments.add(new ZhiHuHomeFragment());
        mFragments.add(new TopNewsFragment());
        mFragments.add(new DouBanMovieTopFragment());
        mFragments.add(new DouBanMovieLatestFragment());
    }
}
