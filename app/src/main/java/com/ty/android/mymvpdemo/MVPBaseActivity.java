package com.ty.android.mymvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Android on 2017/6/18.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends BaseActivity {
    protected T mPresenter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
