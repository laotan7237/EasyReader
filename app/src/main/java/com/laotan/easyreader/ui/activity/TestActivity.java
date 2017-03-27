//package com.laotan.easyreader.ui.activity;
//
//import android.os.SystemClock;
//import android.support.v7.app.ActionBar;
//import android.support.v7.widget.Toolbar;
//
//import com.laotan.easyreader.R;
//
//import butterknife.BindView;
//
//import static com.laotan.easyreader.app.AppConstants.STATE_SUCCESS;
//
///**
// * Created by quantan.liu on 2017/3/24.
// */
//
//public class TestActivity extends ZhihuDetailBaseActivity {
//    @BindView(R.id.toolbar)
//    Toolbar tbToolbar;
//
//    @Override
//    public void initView() {
//        setSupportActionBar(tbToolbar);
//        ActionBar supportActionBar = getSupportActionBar();
//        supportActionBar.setDisplayHomeAsUpEnabled(false);//不显示返回键
//        supportActionBar.setDisplayShowTitleEnabled(false);//去除默认标题
//    }
//
//    @Override
//    public void loadData() {
//        new Thread(){
//            @Override
//            public void run() {
//                SystemClock.sleep(2000);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mLoadingPage.state = STATE_SUCCESS;
//                        mLoadingPage.showPage();
//                        setToolbarBaseGone();
//                    }
//                });
//
//            }
//        }.start();
//    }
//
//    @Override
//    public int getContentLayoutId() {
//        return R.layout.app_bar_main;
//    }
//}
