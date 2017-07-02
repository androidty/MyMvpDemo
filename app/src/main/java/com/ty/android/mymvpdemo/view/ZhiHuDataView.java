package com.ty.android.mymvpdemo.view;

import com.ty.android.mymvpdemo.model.entity.ZhiHuData;

/**
 * Created by Android on 2017/6/27.
 */

public interface ZhiHuDataView {
    void onStartLoadData();
    void onLoadDataSuccess(ZhiHuData zhiHuData);
    void onloadDataFailed(String error);
}
