package com.laotan.easyreader.injector.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by quantan.liu on 2017/3/30.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface WeChatUrl {
}
