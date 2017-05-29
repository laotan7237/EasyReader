package com.laotan.easyreader.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.blankj.utilcode.utils.SPUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.HomeFragmentPageAdapter;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.injector.component.ActivityComponent;
import com.laotan.easyreader.injector.component.DaggerActivityComponent;
import com.laotan.easyreader.injector.module.ActivityModule;
import com.laotan.easyreader.rx.RxBus;
import com.laotan.easyreader.ui.activity.base.BaseActivity;
import com.laotan.easyreader.ui.fragment.gank.AndroidFragment;
import com.laotan.easyreader.ui.fragment.home.HomeFragment;
import com.laotan.easyreader.ui.fragment.wechat.RightFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_title_menu)
    FrameLayout nvMenu;

    @BindView(R.id.dl_layout)
    DrawerLayout dlLayout;

    @BindView(R.id.toolbar)
    Toolbar tbToolbar;

    @BindView(R.id.rg_home_viewpager_contorl)
    RadioGroup rgHomeViewpagerContorl;

    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.view_search)
    MaterialSearchView searchView;

    @OnClick(R.id.fl_title_menu)
    public void flTitleMenu() {
        dlLayout.openDrawer(GravityCompat.START);
    }

    @OnClick(R.id.fl_exit_app)
    public void exitApp() {
        this.killAll();
    }

    @OnClick(R.id.fl_feedback)
    public void feedback() {
        startActivity(new Intent(this, FeedbackActivity.class));
    }

    @OnClick(R.id.fl_about_us)
    public void aboutUs() {
        startActivity(new Intent(this, AboutUsActivity.class));
    }

    @OnClick(R.id.fl_setting)
    public void setting() {
        ToastUtils.showShortToast("设置暂时还没有开发哦");
    }

    @OnClick(R.id.fl_theme_color)
    public void themeColor() {
        ToastUtils.showShortToast("个性换肤暂时还没有开发");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setToolBar(tbToolbar, "", false);
        initView();
        //初始化首页栏目顺序
        SPUtils spUtils = new SPUtils("home_list");
        if (!spUtils.getBoolean("home_list_boolean")) {
            spUtils.putString("home_list", "知乎日报&&知乎热门&&知乎主题&&知乎专栏&&");
            spUtils.putBoolean("home_list_boolean", true);
        }

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                vpContent.setCurrentItem(2);
                RxBus.getDefault().post(AppConstants.WECHA_SEARCH, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    private void initView() {
        rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                switch (i) {
                    case R.id.rb_home_pager:
                        vpContent.setCurrentItem(0);// 设置当前页面
//                        vpContent.setCurrentItem(0,false);// false去掉viewpager切换页面的动画
                        break;
                    case R.id.rb_music_pager:
                        vpContent.setCurrentItem(1);
                        break;
                    case R.id.rb_friend_pager:
                        vpContent.setCurrentItem(2);
                        break;
                }
            }
        });
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new AndroidFragment());
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new RightFragment());
        vpContent.setAdapter(new HomeFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        vpContent.setCurrentItem(1);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rgHomeViewpagerContorl.check(R.id.rb_home_pager);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_music_pager);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_friend_pager);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_search:
//                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void onBackPressed() {
        if (dlLayout.isDrawerOpen(GravityCompat.START)) {
            dlLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }


    /**
     * 按返回键不退出应用。
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (dlLayout.isDrawerOpen(GravityCompat.START)) {
                dlLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onUserInteraction();
        }
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

}
