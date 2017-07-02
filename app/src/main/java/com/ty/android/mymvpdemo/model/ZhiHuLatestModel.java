package com.ty.android.mymvpdemo.model;

import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuLatestListener;

/**
 * Created by Android on 2017/6/26.
 */

public interface ZhiHuLatestModel {
    void loadZhiHuLatest(OnZhiHuLatestListener listener);
    void loadMore(OnZhiHuLatestListener listener);
}
