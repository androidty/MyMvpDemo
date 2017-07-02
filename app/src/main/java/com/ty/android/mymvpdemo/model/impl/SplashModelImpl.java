package com.ty.android.mymvpdemo.model.impl;

import android.os.AsyncTask;

import com.ty.android.mymvpdemo.model.SplashModel;
import com.ty.android.mymvpdemo.presenter.listener.OnSplashListener;
import com.ty.android.mymvpdemo.utils.ShowApiUtils;

/**
 * Created by Android on 2017/6/19.
 */

public class SplashModelImpl implements SplashModel{

    private OnSplashListener mOnsplashListener;
    @Override
    public void loadSaying(OnSplashListener onSplashListener) {
        this.mOnsplashListener = onSplashListener;
        new MyAsyncTask().execute(ShowApiUtils.ADDRESS);
    }

    class MyAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return ShowApiUtils.parseJsonResult(ShowApiUtils.getData(strings[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null){
                mOnsplashListener.onSuccess(s);
            }else{
                mOnsplashListener.onFailed();
            }
        }
    }
}
