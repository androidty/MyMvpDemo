package com.ty.android.mymvpdemo.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

/**
 * Created by Android on 2017/6/20.
 */

public class MyApplication extends Application{

    private static Context sContext;
    private static String sCacheDir="";
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        if(getExternalCacheDir()!=null&&existSdCard()){
            sCacheDir=getExternalCacheDir().toString();
        }else{
            sCacheDir=getAppCacheDir();
        }

    }


    public static Context getContext() {
        return sContext;
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }

    public boolean existSdCard(){
        return Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED);
    }
}
