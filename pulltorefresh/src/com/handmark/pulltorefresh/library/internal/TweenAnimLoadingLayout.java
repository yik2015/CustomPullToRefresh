package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;

/**
 * Created by Administrator on 2016/4/27.
 */
public class TweenAnimLoadingLayout extends LoadingLayout{
    private AnimationDrawable animationDrawable;

    public TweenAnimLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        mHeaderImage.setImageResource(R.drawable.home_refresh_anim);
        animationDrawable = (AnimationDrawable) mHeaderImage.getDrawable();

    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.pull_header1;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {
    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    @Override
    protected void pullToRefreshImpl() {
    }

    @Override
    protected void refreshingImpl() {
        animationDrawable.start();
    }

    @Override
    protected void releaseToRefreshImpl() {
        animationDrawable.stop();
        mHeaderImage.clearAnimation();
    }

    @Override
    protected void resetImpl() {
        mHeaderImage.setVisibility(VISIBLE);
        mHeaderImage.clearAnimation();
    }
}
