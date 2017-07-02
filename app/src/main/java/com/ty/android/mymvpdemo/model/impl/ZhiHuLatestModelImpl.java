package com.ty.android.mymvpdemo.model.impl;

import android.support.annotation.MainThread;

import com.ty.android.mymvpdemo.api.ZhiHuApi;
import com.ty.android.mymvpdemo.app.Constant;
import com.ty.android.mymvpdemo.model.ZhiHuLatestModel;
import com.ty.android.mymvpdemo.model.entity.ZhiHuLatest;
import com.ty.android.mymvpdemo.presenter.listener.OnZhiHuLatestListener;
import com.ty.android.mymvpdemo.utils.RetrofitManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Android on 2017/6/26.
 */

public class ZhiHuLatestModelImpl implements ZhiHuLatestModel {

    private ZhiHuApi mZhiHuApiService;
    private List<ZhiHuLatest.StoriesBean> mStoriesBeanList;
    private String date;

    public ZhiHuLatestModelImpl() {
        mStoriesBeanList = new ArrayList<>();
        mZhiHuApiService = RetrofitManager.getInstance()
                .getRetrofit(Constant.ZHIHU_BASE_URL).create(ZhiHuApi.class);
    }

    public List<ZhiHuLatest.StoriesBean> getStoriesBeanList() {
        return mStoriesBeanList;
    }

    @Override
    public void loadZhiHuLatest(final OnZhiHuLatestListener listener) {
        mStoriesBeanList.clear();
        if (mZhiHuApiService != null) {
            mZhiHuApiService.getZhiHuLatest().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ZhiHuLatest>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull ZhiHuLatest zhiHuLatest) {
                            date = zhiHuLatest.getDate();
                            for (int i = 0; i < zhiHuLatest.getStories().size(); i++) {
                                mStoriesBeanList.add(zhiHuLatest.getStories().get(i));
                            }
                            listener.onLoadLatestSuccess();
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            listener.onLoadFailed(e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    @Override
    public void loadMore(final OnZhiHuLatestListener listener) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = new GregorianCalendar();
        try {
            calendar.setTime(dateFormat.parse(date));
            calendar.add(Calendar.HOUR_OF_DAY, -1);
            date = dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(mZhiHuApiService!=null){
            mZhiHuApiService.getBefore(date).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ZhiHuLatest>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull ZhiHuLatest zhiHuLatest) {
                            for(int i =0;i<zhiHuLatest.getStories().size();i++){
                                mStoriesBeanList.add(zhiHuLatest.getStories().get(i));
                            }
                            listener.onLoadMoreSuccess();
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            listener.onLoadFailed(e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }
}
