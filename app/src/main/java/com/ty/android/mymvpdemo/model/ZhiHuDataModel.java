package com.ty.android.mymvpdemo.model;

import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuDataListener;

/**
 * Created by Android on 2017/6/27.
 */

public interface ZhiHuDataModel {
    void LoadZhiHuData(String id, OnZhiHuDataListener onZhiHuDataListener);
}
