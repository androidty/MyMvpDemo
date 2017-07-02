package com.ty.android.mymvpdemo.presenter.listener;

/**
 * Created by Android on 2017/6/26.
 */

public interface OnZhiHuLatestListener {
    void onLoadLatestSuccess();
    void onLoadMoreSuccess();
    void onLoadFailed(String error);
}
