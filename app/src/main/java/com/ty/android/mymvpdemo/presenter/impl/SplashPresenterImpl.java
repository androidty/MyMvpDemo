package com.ty.android.mymvpdemo.presenter.impl;

import com.ty.android.mymvpdemo.BasePresenter;
import com.ty.android.mymvpdemo.model.SplashModel;
import com.ty.android.mymvpdemo.model.impl.SplashModelImpl;
import com.ty.android.mymvpdemo.presenter.SplashPresenter;
import com.ty.android.mymvpdemo.presenter.listener.OnSplashListener;
import com.ty.android.mymvpdemo.view.SplashView;

/**
 * Created by Android on 2017/6/19.
 */

public class SplashPresenterImpl extends BasePresenter<SplashView> implements
        SplashPresenter, OnSplashListener {
    private SplashModelImpl mSplashModelImpl;
    private SplashView mSplashView;

    public SplashPresenterImpl(SplashView splashView) {
        this.mSplashView = splashView;
        mSplashModelImpl = new SplashModelImpl();
    }

    @Override
    public void loadSaying() {
        mSplashModelImpl.loadSaying(this);
    }

    @Override
    public void onSuccess(String msg) {
        mSplashView.onGetSayingSuccess(msg);
    }

    @Override
    public void onFailed() {
        mSplashView.onGetSayingFailed();
    }
}
