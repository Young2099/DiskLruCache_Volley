package com.demo.panguso.demo20160516.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by panguso on 2016/5/17.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList viewList;

    public ViewPagerAdapter(Context context){
        mContext=context;
    }

    /**
     * 屏幕个数
     * @return
     */
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        return super.instantiateItem(container, position);
    }
}
