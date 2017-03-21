package com.laotan.easyreader;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.di.component.ActivityComponent;
import com.laotan.easyreader.di.component.DaggerActivityComponent;
import com.laotan.easyreader.di.module.ActivityModule;
import com.laotan.easyreader.presenter.DailyPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_title_menu)
    FrameLayout nvMenu;

    @BindView(R.id.dl_layout)
    DrawerLayout dlLayout;

    @BindView(R.id.toolbar)
    Toolbar tbToolbar;

    @OnClick(R.id.fl_title_menu)
    public void flTitleMenu() {
        dlLayout.openDrawer(GravityCompat.START);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(tbToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(false);//不显示返回键
        supportActionBar.setDisplayShowTitleEnabled(false);//去除默认标题
        getActivityComponent().inject(this);
        mDailyPresenter.getDailyData();
    }


    @Inject
    DailyPresenter mDailyPresenter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
