package com.ty.android.mymvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ty.android.mymvpdemo.utils.CommonUtils;

import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Android on 2017/6/18.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    protected T mPresenter;
    private ProgressDialog mProgressDialog;

    protected abstract T createPrestenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutRes(), null);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPrestenter();
        mPresenter.attachView((V) this);
    }

    protected abstract int getLayoutRes();

    protected void setTitle(String msg) {
        getActivity().getActionBar().setTitle(msg);
    }

    protected void showProgressDialog(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void startActivity(Class activity) {
        startActivity(activity,true);
    }

    protected void startActivity(Class activity,boolean finish){
        Intent intent = new Intent(getActivity(),activity);
        startActivity(intent);
        if(finish){
            getActivity().finish();
        }
    }
    protected void startActivity(Class activity,String key,String extra){
        Intent intent = new Intent(getActivity(),activity);
        intent.putExtra(key,extra);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mProgressDialog=null;
    }

    protected void toast(String msg){
        CommonUtils.showTips(getContext(),msg);
    }

}
