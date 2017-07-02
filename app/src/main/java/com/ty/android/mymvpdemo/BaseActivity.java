package com.ty.android.mymvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.ty.android.mymvpdemo.utils.CommonUtils;

/**
 * Created by Android on 2017/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags =
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|localLayoutParams.flags;
        }
    }

    protected abstract int getLayoutRes();

    protected void showProgress(String msg){
        if(mProgressDialog==null){
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setCancelable(true);
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }
    protected void hideProgress(){
      if(mProgressDialog!=null){
          mProgressDialog.dismiss();
      }
    }


    protected void startActivity(Class activity){
        startActivity(activity ,true);
    }

    private void startActivity(Class activity, boolean finish) {
        Intent intent = new Intent(this,activity);
        startActivity(intent);
        if(finish){
            finish();
        }
    }

    protected void toast(String msg) {
        CommonUtils.showTips(this, msg);
    }


}
