package com.ty.android.mymvpdemo.model.impl;

import android.util.Log;

import com.ty.android.mymvpdemo.api.ZhiHuApi;
import com.ty.android.mymvpdemo.app.Constant;
import com.ty.android.mymvpdemo.model.ZhiHuDataModel;
import com.ty.android.mymvpdemo.model.entity.ZhiHuData;
import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuDataListener;
import com.ty.android.mymvpdemo.utils.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by Android on 2017/6/27.
 */

public class ZhiHuDataModelImpl implements ZhiHuDataModel {

    private ZhiHuApi mZhiHuApi;
    private ZhiHuData mZhiHuData;


    public ZhiHuDataModelImpl() {
        mZhiHuData = new ZhiHuData();
        mZhiHuApi = RetrofitManager.getInstance().getRetrofit(Constant.ZHIHU_BASE_URL).create(ZhiHuApi.class);
    }

    public ZhiHuData getZhiHuData() {
        return mZhiHuData;
    }

    @Override
    public void LoadZhiHuData(String id, final OnZhiHuDataListener onZhiHuDataListener) {
        if (mZhiHuApi != null) {
            mZhiHuApi.getZhiHuData(id).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ZhiHuData>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull ZhiHuData zhiHuData) {
                    mZhiHuData = zhiHuData;
                    onZhiHuDataListener.onLoadSuccess(zhiHuData);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("onError", "onError: "+e.toString());
                    onZhiHuDataListener.onLoadFailed(e.toString());
                }

                @Override
                public void onComplete() {

                }
            });
        }
    }


}
