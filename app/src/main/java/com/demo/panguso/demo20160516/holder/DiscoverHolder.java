package com.demo.panguso.demo20160516.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.demo.panguso.demo20160516.R;

/**
 * Created by panguso on 2016/6/8.
 */
public class DiscoverHolder extends RecyclerView.ViewHolder {
    public ImageView iv;
    public ImageView iv1;
    public ImageView iv2;
    public DiscoverHolder(View itemView) {
        super(itemView);
        iv = (ImageView) itemView.findViewById(R.id.iv_first1);
//        iv1 = (ImageView) itemView.findViewById(R.id.iv_second1);
//        iv2 = (ImageView) itemView.findViewById(R.id.iv_second2);
    }
}
