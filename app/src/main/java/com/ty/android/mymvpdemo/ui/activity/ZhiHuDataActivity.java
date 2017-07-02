package com.ty.android.mymvpdemo.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.jude.swipbackhelper.SwipeBackHelper;
import com.ty.android.mymvpdemo.MVPBaseActivity;
import com.ty.android.mymvpdemo.R;
import com.ty.android.mymvpdemo.app.Constant;
import com.ty.android.mymvpdemo.model.entity.ZhiHuData;
import com.ty.android.mymvpdemo.presenter.impl.ZhiHuDataPresenterImpl;
import com.ty.android.mymvpdemo.utils.WebUtils;
import com.ty.android.mymvpdemo.view.ZhiHuDataView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 2017/6/27.
 */

public class ZhiHuDataActivity extends MVPBaseActivity<ZhiHuDataView,ZhiHuDataPresenterImpl> implements ZhiHuDataView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.zhihu_data_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.wv_zhihu)
    WebView mWebView;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.iv_title)
    ImageView mIvTitle;

    String mZhiHuId;
    String mZhiHuTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        ButterKnife.bind(this);
        initToolBar();
        initView();

    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    private void initView(){
        mZhiHuId = getIntent().getStringExtra(Constant.ZHIHU_ID);
        mZhiHuTitle = getIntent().getStringExtra(Constant.ZHIHU_TITLE);
        Log.d("initView", "initView: "+mZhiHuId);
        mPresenter.getZhiHuData(mZhiHuId);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "已添加进收藏夹（待做功能）", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mWebView.setVerticalScrollBarEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setAppCachePath(getCacheDir().getAbsolutePath()+"webViewCache");
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);//显示或不显示缩放按钮（wap网页不支持）。
        //指定WebView的页面布局显示形式，调用该方法会引起页面重绘
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setWebChromeClient(new WebChromeClient());
    }


    @Override
    public void onStartLoadData() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadDataSuccess(ZhiHuData zhiHuData) {
        mProgressBar.setVisibility(View.GONE);
        mToolbarLayout.setTitle(zhiHuData.getTitle());
        if(zhiHuData.getBody()==null){
            mWebView.loadUrl(zhiHuData.getShare_url());
        }else {
            String data = WebUtils.buildHtmlWithCss(zhiHuData.getBody(),zhiHuData.getCss());
            mWebView.loadDataWithBaseURL(WebUtils.BASE_URL,data,WebUtils.MIME_TYPE,WebUtils.ENCODING,WebUtils.FAIL_URL);
            Glide.with(this).load(zhiHuData.getImage()).into(mIvTitle);
        }
    }

    @Override
    public void onloadDataFailed(String error) {
        mProgressBar.setVisibility(View.GONE);
        toast(error);
    }

    @Override
    protected ZhiHuDataPresenterImpl createPresenter() {
        return new ZhiHuDataPresenterImpl(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_zhihu_data;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        if(mWebView!=null){
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
        }
        mWebView.destroy();
        mWebView=null;
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }
}
