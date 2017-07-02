package com.ty.android.mymvpdemo;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Android on 2017/6/18.
 */

public abstract class BasePresenter<T> {
    protected WeakReference<T> mViewRef;
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view) ;
    }

    protected T getView(){
        return mViewRef.get();
    }

    public boolean isViewAttached(){
        return mViewRef!=null && mViewRef.get()!=null;
    }
    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
            mViewRef=null;
        }
    }

}
