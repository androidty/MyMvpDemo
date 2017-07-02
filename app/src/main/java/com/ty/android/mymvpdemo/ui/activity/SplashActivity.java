package com.ty.android.mymvpdemo.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ty.android.mymvpdemo.BaseActivity;
import com.ty.android.mymvpdemo.MVPBaseActivity;
import com.ty.android.mymvpdemo.R;
import com.ty.android.mymvpdemo.model.impl.SplashModelImpl;
import com.ty.android.mymvpdemo.presenter.impl.SplashPresenterImpl;
import com.ty.android.mymvpdemo.view.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017/6/19.
 */

public class SplashActivity extends MVPBaseActivity<SplashView, SplashPresenterImpl> implements SplashView {


    @BindView(R.id.iv_show_pic)
    ImageView mIvShowPic;
    @BindView(R.id.tv_show_saying)
    TextView mTvShowSaying;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mPresenter.loadSaying();
        startAnimMax();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public void onGetSayingSuccess(String msg) {
        mTvShowSaying.setText(msg);
    }

    @Override
    public void onGetSayingFailed() {
        mTvShowSaying.setText(getString(R.string.default_saying));
    }

    @Override
    protected SplashPresenterImpl createPresenter() {
        return new SplashPresenterImpl(this);
    }

    private void startAnimMin(){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvShowPic,"scaleX",1f,1.25f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvShowPic,"scaleY",1f,1.25f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000).play(animatorX).with(animatorY);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startAnimMax();
            }
        });
    }

    private void startAnimMax(){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvShowPic,"scaleX",1.25f,1f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvShowPic,"scaleY",1.25f,1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000).play(animatorX).with(animatorY);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(MainActivity.class);
            }
        });
    }



}