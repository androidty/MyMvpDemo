package com.ty.android.mymvpdemo.presenter.impl;

import com.ty.android.mymvpdemo.BasePresenter;
import com.ty.android.mymvpdemo.model.ZhiHuLatestModel;
import com.ty.android.mymvpdemo.model.entity.ZhiHuLatest;
import com.ty.android.mymvpdemo.model.impl.ZhiHuLatestModelImpl;
import com.ty.android.mymvpdemo.presenter.ZhiHuPresenter;
import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuLatestListener;
import com.ty.android.mymvpdemo.view.ZhiHuView;

import java.util.List;

/**
 * Created by Android on 2017/6/26.
 */

public class ZhiHuPresenterImpl extends BasePresenter<ZhiHuView> implements ZhiHuPresenter, OnZhiHuLatestListener {
    private ZhiHuView mZhiHuView;
    private ZhiHuLatestModelImpl mZhiHuLatestModel;

    public ZhiHuPresenterImpl(ZhiHuView zhiHuView) {
        mZhiHuView = zhiHuView;
        mZhiHuLatestModel = new ZhiHuLatestModelImpl();
    }

    public List<ZhiHuLatest.StoriesBean> getZhiHuList(){
        return mZhiHuLatestModel.getStoriesBeanList();
    }

    @Override
    public void loadLatest() {
        mZhiHuView.onStartLoadData();
        mZhiHuLatestModel.loadZhiHuLatest(this);
    }

    @Override
    public void loadMore() {
        mZhiHuView.onStartLoadData();
        mZhiHuLatestModel.loadMore(this);
    }

    @Override
    public void onLoadLatestSuccess() {
        mZhiHuView.onLoadLatestSuccess();
    }

    @Override
    public void onLoadMoreSuccess() {
        mZhiHuView.onLoadMoreSuccess();
    }

    @Override
    public void onLoadFailed(String error) {
        mZhiHuView.onLoadDataFailed(error);
    }
}
