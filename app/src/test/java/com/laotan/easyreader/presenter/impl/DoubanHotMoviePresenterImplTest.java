package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.app.App;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by quantan.liu on 2017/4/6.
 */
public class DoubanHotMoviePresenterImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void fetchHotMovie() throws Exception {
        App.getAppComponent().mRetrofitDouBanUtils().fetchHotMovie();
    }

}