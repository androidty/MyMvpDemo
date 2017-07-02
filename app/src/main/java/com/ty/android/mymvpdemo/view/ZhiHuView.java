package com.ty.android.mymvpdemo.view;

/**
 * Created by Android on 2017/6/26.
 */

public interface ZhiHuView {
    void onStartLoadData();
    void onLoadLatestSuccess();
    void onLoadMoreSuccess();
    void onLoadDataFailed(String error);
}
