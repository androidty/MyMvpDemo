package com.ty.android.mymvpdemo.api;

import com.ty.android.mymvpdemo.model.entity.ZhiHuData;
import com.ty.android.mymvpdemo.model.entity.ZhiHuLatest;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Android on 2017/6/26.
 */

public interface ZhiHuApi {
    @GET("latest")
    Observable<ZhiHuLatest> getZhiHuLatest();

    @GET("before/{date}")
    Observable<ZhiHuLatest> getBefore(@Path("date") String date);
    @GET("{id}")
    Observable<ZhiHuData> getZhiHuData(@Path("id") String id);
}
