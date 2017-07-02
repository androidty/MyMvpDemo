package com.ty.android.mymvpdemo.utils;

import com.ty.android.mymvpdemo.app.MyApplication;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 2017/6/20.
 */

public class RetrofitManager {
    private static RetrofitManager mRetrofitManager;

    private RetrofitManager() {
    }

    private static Interceptor netInterceptor1 = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            int maxAge = 60;//60秒内读取缓存，60秒后读取网络数据
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public,max-age=" + maxAge)
                    .build();
        }
    };

    private static class netIntercptor2 implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (NetWorkUtils.isNetWorkAvailable(MyApplication.getContext())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (true) {
                return originalResponse.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control")
                        .header("Cache-Control", "public,max-age=" + 0).build();
            } else {
                int maxAge = 4 * 24 * 60 * 60; //缓存保存时间
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-age=" + maxAge)
                        .build();
            }

        }
    }

    private static File fileCache = new File(MyApplication.getAppCacheDir(), "cache_zhihu_data");
    private static int DEFAULT_CACHE_SIZE = 20 * 1024 * 1024;
    private static Cache cache = new Cache(fileCache, DEFAULT_CACHE_SIZE);
    private static OkHttpClient client = new OkHttpClient().newBuilder()
            .addInterceptor(new netIntercptor2())
            .addNetworkInterceptor(new netIntercptor2()).cache(cache).build();


    public static RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }
        return mRetrofitManager;
    }

    private Retrofit mRetrofit;

    public Retrofit getRetrofit(String url) {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;
    }

}
