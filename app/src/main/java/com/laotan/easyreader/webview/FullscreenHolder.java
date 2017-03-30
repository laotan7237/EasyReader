package com.laotan.easyreader.webview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public class FullscreenHolder extends FrameLayout {

    public FullscreenHolder(Context ctx) {
        super(ctx);
        setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
