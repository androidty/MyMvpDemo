package com.ty.android.mymvpdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ty.android.mymvpdemo.BaseFragment;
import com.ty.android.mymvpdemo.R;
import com.ty.android.mymvpdemo.adapter.ZhiHuAdapter;
import com.ty.android.mymvpdemo.app.Constant;
import com.ty.android.mymvpdemo.presenter.impl.ZhiHuPresenterImpl;
import com.ty.android.mymvpdemo.ui.activity.ZhiHuDataActivity;
import com.ty.android.mymvpdemo.view.ZhiHuView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * Created by Android on 2017/6/26.
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuView, ZhiHuPresenterImpl> implements ZhiHuView {

    @BindView(R.id.recycle_zhihu)
    RecyclerView mRecyclerView;
    Unbinder mUnbinder;
    @BindView(R.id.prograss)
    ProgressBar mProgressBar;

    private ZhiHuAdapter mZhiHuAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, rootView);
        init();
        mPresenter.loadLatest();
        return rootView;
    }

    private void init() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isScrollToBottom(recyclerView)) {
                    mPresenter.loadMore();
                }
            }
        });
        mZhiHuAdapter = new ZhiHuAdapter(getContext(), mPresenter.getZhiHuList());
        mZhiHuAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mZhiHuAdapter);
    }

    private boolean isScrollToBottom(RecyclerView recyclerView) {
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    private ZhiHuAdapter.OnItemClickListener mOnItemClickListener = new ZhiHuAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String title, int id) {
//            toast(String.valueOf(id));
            Intent intent = new Intent(getContext(), ZhiHuDataActivity.class);
            intent.putExtra(Constant.ZHIHU_TITLE,title);
            intent.putExtra(Constant.ZHIHU_ID,String.valueOf(id));
            Log.d("initView", "onItemClick: "+id);
            startActivity(intent);
        }


    };

    @Override
    public void onStartLoadData() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadLatestSuccess() {
        mProgressBar.setVisibility(View.GONE);
        mZhiHuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMoreSuccess() {
        mProgressBar.setVisibility(View.GONE);
        mZhiHuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadDataFailed(String error) {

    }

    @Override
    protected ZhiHuPresenterImpl createPrestenter() {
        return new ZhiHuPresenterImpl(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_zhihu;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mUnbinder.unbind();
    }
}
