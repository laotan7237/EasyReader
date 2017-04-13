package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.app.App;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by quantan.liu on 2017/4/13.
 */
public class RetrofitTopNewsUtilsTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void fetchNBAList() throws Exception {
        App.getAppComponent().mRetrofitTopNewsUtils().fetchNBAList(0);
    }

}