package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.WeChatModule;
import com.laotan.easyreader.injector.module.http.WeChatHttpModule;
import com.laotan.easyreader.ui.fragment.wechat.WeChatFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { WeChatHttpModule.class,WeChatModule.class})
public interface WeChatComponent {
    void injectWeChat(WeChatFragment weChatFragment);
}
