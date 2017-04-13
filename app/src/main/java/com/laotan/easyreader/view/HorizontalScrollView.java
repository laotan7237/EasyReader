package com.laotan.easyreader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by laotan on 2017/3/6.
 */

public class HorizontalScrollView extends ViewGroup {

    /**
     * 每一步我们重点关心每一步新添加的变量。
     */
    //2、准备工作
    private int windowWidth;
    private int halfWindowWidth;//一半的屏幕宽度
    private int oneThirdWindowWidth;//三分之一屏幕宽度
    //3、重写onLayout排列子View
    private int childLeftLeft;//左边第一个的left值
    private int childRightLeft;//右边第一个的left值
    private int childCount;//子View个数
    private int childViewHeightDifference = 50;//我们把子View的高度差设为50
    private int childHalfCount;

    //4、ViewGroup滑动处理
    private int startX;
    private int lastX;
    private int totalX;

    //5、分别让两边子View动起来
    private int touchChildCenterCount;//互动时位于屏幕正中间的View
    private int leftHigh;
    private int rightHigh;

    //7、处理滑动和点击事件冲突和添加VelocityTracker
    private VelocityTracker mVelocityTracker;
    private int scllorTime;
    private int dispatchEndX;
    private int dispatchEndY;
    private int childMarginRight = 10;

    private int visualCount = 3;
    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        windowWidth = wm.getDefaultDisplay().getWidth();//获取屏幕宽度
        halfWindowWidth = windowWidth / 2;
        oneThirdWindowWidth = windowWidth / visualCount;

        mVelocityTracker = VelocityTracker.obtain();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = 0;
        int measuredHeight = 0;

        final int childCount = getChildCount();
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSizd = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSizd = MeasureSpec.getSize(heightMeasureSpec);

        if (childCount == 0) {
            setMeasuredDimension(0, 0);
        } else if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredWidth = oneThirdWindowWidth * childCount;
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(widthSpecSizd, measuredHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredWidth = oneThirdWindowWidth * childCount;
            setMeasuredDimension(measuredWidth, heightSpecSizd);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        childCount = getChildCount();
//        if (childCount < 3) {
//            try {
//                throw new Exception("HorizontalScrollView必须有3个或者3个以上的子View");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        childLeftLeft = halfWindowWidth;
        childRightLeft = halfWindowWidth;
        childHalfCount = childCount / 2;
        leftHigh = childViewHeightDifference * (childHalfCount);//初始化左边for循环的最左边View的高度位置
        rightHigh = childViewHeightDifference * (-childHalfCount);//初始化右边for循环的最左边View的高度位置，需要加上i * childViewHeightDifference
        touchChildCenterCount = childHalfCount;
        for (int i = childHalfCount; i >= 0; i--) {
            childMarginRight = 10;
            final View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                final int childWidth = oneThirdWindowWidth;
                childView.layout(childLeftLeft - childWidth / 2, childViewHeightDifference * (childHalfCount - i), childLeftLeft - childWidth / 2 + childWidth - childMarginRight,
                        childViewHeightDifference * (childHalfCount - i) + childView.getMeasuredHeight());

                childLeftLeft -= childWidth;
            }
        }

        for (int i = childHalfCount + 1; i < childCount; i++) {
            childMarginRight = 10;
            final View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                final int childWidth = oneThirdWindowWidth;
                if (i == childCount - 1) {
                    childMarginRight = 0;
                }
                childView.layout(childRightLeft + childWidth / 2, childViewHeightDifference * (i - childHalfCount),
                        childRightLeft + childWidth / 2 + childWidth - childMarginRight, childViewHeightDifference * (i - childHalfCount) + childView.getMeasuredHeight());
                childRightLeft += childWidth;
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getChildCount()<=3){
            return true;
        }
        mVelocityTracker.addMovement(event);
        startX = (int) event.getRawX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                int delatX = 0;
                //滑动冲突时不能马上获取到滑动的delatX导致突然是一个很大的值没有想到很好的办法，就只能这样子限制delatX了。
                if (lastX != 0) {
                    delatX = startX - lastX;
                    if (delatX >= 50) {
                        delatX = 50;
                    }
                    if (delatX <= -50) {
                        delatX = -50;
                    }
                }

                totalX += delatX;
                scroll();


                break;
            case MotionEvent.ACTION_UP:


                mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity) >= childViewHeightDifference) {
                    //以下20和300都是我经过多次测试选取的值，感觉运行代码损失了一些时间所以只能测试找出来不能通过计算。
                    if (xVelocity > 0) {
                        scllorTime = 20;
                        int count = (int) (xVelocity / 300);
                        int currentTotalX = totalX + count * oneThirdWindowWidth/10;
                        postDelayed(new AutoScllorRunnable(currentTotalX), 1);
                    }
                    if (xVelocity < 0) {
                        scllorTime = 20;
                        int count = (int) (Math.abs(xVelocity) / 300);
                        int currentTotalX = totalX - count * oneThirdWindowWidth/10;
                        postDelayed(new AutoScllorRunnable(currentTotalX), 1);
                    }

                }

                break;
        }
        lastX = startX;
        return true;
    }


    private void scroll() {

        childLeftLeft = halfWindowWidth;
        childRightLeft = halfWindowWidth;

        if (touchChildCenterCount - childHalfCount >= 1) {
            childLeftLeft = halfWindowWidth + (touchChildCenterCount - childHalfCount) * oneThirdWindowWidth;
            childRightLeft = halfWindowWidth + (touchChildCenterCount - childHalfCount) * oneThirdWindowWidth;
        }
        if (touchChildCenterCount - childHalfCount <= -1) {
            childLeftLeft = halfWindowWidth + (touchChildCenterCount - childHalfCount) * oneThirdWindowWidth;
            childRightLeft = halfWindowWidth + (touchChildCenterCount - childHalfCount) * oneThirdWindowWidth;
        }

        for (int i = touchChildCenterCount; i >= 0; i--) {
            childMarginRight = 10;
            final View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                if (totalX > 0) {
                    if (i == touchChildCenterCount) {
                        final int childWidth = oneThirdWindowWidth;
                        childView.layout(childLeftLeft - childWidth / 2, rightHigh + i * childViewHeightDifference,
                                childLeftLeft + childWidth / 2 - childMarginRight, rightHigh + i * childViewHeightDifference + childView.getMeasuredHeight());
                    } else {
                        final int childWidth = oneThirdWindowWidth;
                        childView.layout(childLeftLeft - 3 * childWidth / 2, leftHigh - i * childViewHeightDifference,
                                childLeftLeft - childWidth / 2 - childMarginRight, leftHigh - i * childViewHeightDifference + childView.getMeasuredHeight());
                        childLeftLeft -= childWidth;

                    }
                } else {
                    final int childWidth = oneThirdWindowWidth;
                    childView.layout(childLeftLeft - childWidth / 2, leftHigh - i * childViewHeightDifference,
                            childLeftLeft + childWidth / 2 - childMarginRight, leftHigh - i * childViewHeightDifference + childView.getMeasuredHeight());
                    childLeftLeft -= childWidth;
                }


            }

        }
        for (int i = touchChildCenterCount + 1; i < childCount; i++) {
            final View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                final int childWidth = oneThirdWindowWidth;
                childMarginRight = 10;
                if (i == childCount - 1) {
                    childMarginRight = 0;
                }
                childView.layout(childRightLeft + childWidth / 2, rightHigh + i * childViewHeightDifference,
                        childRightLeft + childWidth / 2 + childWidth - childMarginRight, rightHigh + i * childViewHeightDifference + childView.getMeasuredHeight());
                childRightLeft += childWidth;
            }
        }


        //控制范围
        if ((childCount - visualCount) % 2 == 0) {
            int totalXRange = windowWidth / visualCount * (childCount - visualCount) / 2;
            if (totalX <= -totalXRange) {
                totalX = -totalXRange;

            }
            if (totalX >= totalXRange) {
                totalX = totalXRange;
            }

        } else {
            int totalXRange = (int) (windowWidth / visualCount * ((childCount - visualCount) / 2 + 0.5));

            if (totalX >= totalXRange + windowWidth / (visualCount*2)) {
                totalX = totalXRange + windowWidth / (visualCount*2);
            }
            if (totalX <= windowWidth / (visualCount*2) - totalXRange) {
                totalX = windowWidth / (visualCount*2) - totalXRange;
            }

        }

        if (totalX * oneThirdWindowWidth >= 1 || totalX * oneThirdWindowWidth <= -1) {
            touchChildCenterCount = childHalfCount - totalX / oneThirdWindowWidth;
        }
        if (totalX * oneThirdWindowWidth == 0) {
            touchChildCenterCount = childHalfCount;
        }

        leftHigh = -totalX * childViewHeightDifference / oneThirdWindowWidth + childViewHeightDifference * (childHalfCount);
        rightHigh = totalX * childViewHeightDifference / oneThirdWindowWidth + childViewHeightDifference * (-childHalfCount);

        scrollTo(-totalX, 0);//左右滑动实际上是滑动ViewGroup的内容。

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //打开注释就可以在这个控件得到上下滑动的事件，不过我们这个控件的需求基本是左右滑动打开的话会影响体验。
        int dispatchStartX = (int) ev.getX();
        int dispatchStartY = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltax = dispatchEndX - dispatchStartX;
                int deltaY = dispatchEndY - dispatchStartY;
                if (Math.abs(deltaY) <= Math.abs(deltax)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        dispatchEndX = dispatchStartX;
        dispatchEndY = dispatchStartY;
        return super.dispatchTouchEvent(ev);
    }

    int InterceptEndX;
    int InterceptEndY;
    boolean intercept;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int dispatchStartX = (int) ev.getX();
        int dispatchStartY = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltax = InterceptEndX - dispatchStartX;
                int deltaY = InterceptEndY - dispatchStartY;
                if (Math.abs(deltaY) <= Math.abs(deltax) - 10) {
                    startX = 0;
                    lastX = 0;
                    intercept = true;
                } else {
                    intercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }
        InterceptEndX = dispatchStartX;
        InterceptEndY = dispatchStartY;
        return intercept;
    }

    private class AutoScllorRunnable implements Runnable {
        int currentTotalx;
        int totalXValue;

        public AutoScllorRunnable(int currentTotalx) {
            this.currentTotalx = currentTotalx;
            totalXValue = (currentTotalx - totalX) / 10;
        }

        @Override
        public void run() {
            if (scllorTime > 0) {
                totalX = totalX + totalXValue;
                scllorTime--;
                scroll();
                HorizontalScrollView.this.postDelayed(this, 1);
            }
        }
    }
}
