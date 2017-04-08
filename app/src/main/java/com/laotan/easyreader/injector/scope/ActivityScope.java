package com.laotan.easyreader.injector.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
