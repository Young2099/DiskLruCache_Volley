package com.demo.panguso.demo20160516.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.demo.panguso.demo20160516.R;

/**
 * Created by panguso on 2016/6/8.
 */
public class DiscountHolder extends RecyclerView.ViewHolder {
    public TextView tv;

    public DiscountHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }
}
