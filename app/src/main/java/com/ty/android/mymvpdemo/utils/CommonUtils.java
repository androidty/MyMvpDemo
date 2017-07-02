package com.ty.android.mymvpdemo.utils;

import android.content.Context;
import android.mtp.MtpConstants;
import android.widget.Toast;

/**
 * Created by Android on 2017/6/20.
 */

public class CommonUtils {
    public static Toast mToast;

    public static void showTips(Context context, String tips) {

        if (mToast == null) {
            mToast = Toast.makeText(context, tips, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(tips);
        }
        mToast.show();
    }
}
