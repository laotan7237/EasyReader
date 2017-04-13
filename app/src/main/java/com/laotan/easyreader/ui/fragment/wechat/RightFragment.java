package com.laotan.easyreader.ui.fragment.wechat;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.HomeFragmentPageAdapter;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class RightFragment extends BaseFragment {

    @BindView(R.id.tab_gank)
    TabLayout tabGank;
    @BindView(R.id.vp_gank)
    ViewPager vpGank;

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);
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
    protected void initInject() {}


    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("WeChat");
        mTitleList.add("NBA");
        mFragments.add(new WeChatFragment());
        mFragments.add(new NBAFragment());
    }
}
