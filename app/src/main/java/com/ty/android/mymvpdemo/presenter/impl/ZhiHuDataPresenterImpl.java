package com.ty.android.mymvpdemo.presenter.impl;

import com.ty.android.mymvpdemo.BasePresenter;
import com.ty.android.mymvpdemo.model.entity.ZhiHuData;
import com.ty.android.mymvpdemo.model.impl.ZhiHuDataModelImpl;
import com.ty.android.mymvpdemo.presenter.ZhiHuDataPresenter;
import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuDataListener;
import com.ty.android.mymvpdemo.view.ZhiHuDataView;

/**
 * Created by Android on 2017/6/27.
 */

public class ZhiHuDataPresenterImpl extends BasePresenter<ZhiHuDataView> implements ZhiHuDataPresenter,OnZhiHuDataListener{


    private ZhiHuDataModelImpl mZhiHuDataModel;
    private ZhiHuDataView mZhiHuDataView;
    public ZhiHuDataPresenterImpl(ZhiHuDataView zhiHuDataView){
        mZhiHuDataView = zhiHuDataView;
        mZhiHuDataModel = new ZhiHuDataModelImpl();
    }

    @Override
    public void getZhiHuData(String id) {
        mZhiHuDataView.onStartLoadData();
        mZhiHuDataModel.LoadZhiHuData(id,this);
    }

    @Override
    public void onLoadSuccess(ZhiHuData zhiHuData) {
        mZhiHuDataView.onLoadDataSuccess(zhiHuData);
    }

    @Override
    public void onLoadFailed(String error) {
        mZhiHuDataView.onloadDataFailed(error);
    }
}
