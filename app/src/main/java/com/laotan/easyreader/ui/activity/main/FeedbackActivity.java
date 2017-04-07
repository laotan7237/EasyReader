package com.laotan.easyreader.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.laotan.easyreader.R;
import com.laotan.easyreader.ui.activity.base.ToolbarBaseActivity;
import com.laotan.easyreader.webview.WebViewActivity;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by quantan.liu on 2017/4/1.
 */

public class FeedbackActivity extends ToolbarBaseActivity {

    private String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=502325525&version=1";

    @OnClick(R.id.tv_issues)
    public void issues() {
        WebViewActivity.loadUrl(this, "https://github.com/laotan7237/EasyReader/issues", "加载中。。。");
    }

    @OnClick(R.id.tv_qq)
    public void qq() {
        if (hasQQClientAvailable(this)) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
        } else {
            ToastUtils.showShortToast("您没安装QQ，请先安装QQ客户端");
        }
    }

    @OnClick(R.id.tv_jianshu)
    public void jianshu() {
        WebViewActivity.loadUrl(this, "http://www.jianshu.com/users/d2f73b699192/timeline", "加载中。。。");
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initUI() {
        setToolBar(toolbarBaseActivity, "意见反馈");
    }

    /**
     * 判断 用户是否安装QQ客户端
     */
    public static boolean hasQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                LogUtils.e("pn = " + pn);
                if (pn.equalsIgnoreCase("com.tencent.qqlite") || pn.equalsIgnoreCase("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }
}
