package com.ty.android.mymvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.ty.android.mymvpdemo.model.entity.ZhiHuLatest;
import com.ty.android.mymvpdemo.widget.ZhiHuItem;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by yiuhet on 2017/5/23.
 */

public class ZhiHuAdapter extends RecyclerView.Adapter<ZhiHuAdapter.ZhihuViewHolder> {

    private Context mContext;
    List<ZhiHuLatest.StoriesBean> mZhihuLatestList;
    private OnItemClickListener mItemClickListener;

    public ZhiHuAdapter(Context context, List<ZhiHuLatest.StoriesBean> zhihuLatestList) {
        mContext = context;
        mZhihuLatestList = zhihuLatestList;
        Log.d("ZhiHuAdapter", "ZhiHuAdapter: "+mZhihuLatestList.size());
    }

    @Override
    public ZhihuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ZhiHuItem zhihuItem = new ZhiHuItem(mContext);
        Log.d("ZhiHuAdapter", "ZhiHuAdapter: "+mZhihuLatestList.size());
        return new ZhihuViewHolder(zhihuItem);
    }

    @Override
    public void onBindViewHolder(final ZhihuViewHolder holder, int position) {
        final ZhiHuLatest.StoriesBean zhihuLatest = mZhihuLatestList.get(position);
        holder.zhihuItem.bindView(zhihuLatest);
        holder.zhihuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(zhihuLatest.getTitle(), zhihuLatest.getId());
//                    holder.zhihuItem.changeTextview();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mZhihuLatestList.size();
    }


    public class ZhihuViewHolder extends RecyclerView.ViewHolder {
        public ZhiHuItem zhihuItem;

        public ZhihuViewHolder(ZhiHuItem itemView) {
            super(itemView);
            zhihuItem = itemView;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String title, int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }
}
