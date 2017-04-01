package com.laotan.easyreader.ui.activity.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.laotan.easyreader.R;
import com.laotan.easyreader.ui.activity.base.BaseActivity;
import com.laotan.easyreader.webview.WebViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.laotan.easyreader.R.string.about_addr;

/**
 * Created by quantan.liu on 2017/4/1.
 */

public class AboutUsActivity extends BaseActivity {

    private Unbinder bind;

    @BindView(R.id.toolbar_about_us)
    Toolbar toolbarAboutUs;

    @OnClick(R.id.cv_github)
    public void cvGithub(){
        WebViewActivity.loadUrl(this,"https://github.com/laotan7237/EasyReader","加载中。。。");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);
        setToolBar(toolbarAboutUs, "关于易读");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
