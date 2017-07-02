package com.ty.android.mymvpdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ty.android.mymvpdemo.R;
import com.ty.android.mymvpdemo.model.entity.ZhiHuLatest;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ty.android.mymvpdemo.R.id.imageView;

/**
 * Created by Android on 2017/6/26.
 */

public class ZhiHuItem extends RelativeLayout{

    private Context mContext;

    @BindView(R.id.zhihu_iv)
    ImageView mImageView;
    @BindView(R.id.zhihu_title)
    TextView mTextView;

    public ZhiHuItem(Context context) {
        this(context, null);
    }

    public ZhiHuItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.view_zhihu_item,this);
        ButterKnife.bind(this,this);
    }

    public void bindView(ZhiHuLatest.StoriesBean zhiHuLatest){
        mTextView.setText(zhiHuLatest.getTitle());
        String url = zhiHuLatest.getImages().get(0);
        Glide.with(getContext()).load(url).into(mImageView);
    }
}
