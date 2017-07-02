package com.ty.android.mymvpdemo.presenter.listener;

import com.ty.android.mymvpdemo.model.entity.ZhiHuData;

/**
 * Created by Android on 2017/6/27.
 */

public interface OnZhiHuDataListener {
    void onLoadSuccess(ZhiHuData zhiHuData);
    void onLoadFailed(String error);
}
