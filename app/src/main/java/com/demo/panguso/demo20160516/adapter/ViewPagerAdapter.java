package com.demo.panguso.demo20160516.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.utils.DensityUtils;

import java.util.ArrayList;

/**
 * Created by yangfang on 2016/5/17.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private static final int MOVE_PAGER = 0;
    private Context mContext;
    private ArrayList<View> views = new ArrayList<>();
    private int[] data = {R.drawable.a, R.drawable.b, R.drawable.e, R.drawable.d};
    private ViewPager mViewPager;
    LinearLayout mPoint;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = (mViewPager.getCurrentItem() + 1);
            mViewPager.setCurrentItem(currentItem);
            handler.sendEmptyMessageDelayed(MOVE_PAGER, 3000);
        }
    };

    public ViewPagerAdapter(Context context, ViewPager viewpager, LinearLayout point) {
        mContext = context;
        mPoint = point;
        for (int i = 0; i < data.length; i++) {
            ImageView imageview = new ImageView(mContext);
            imageview.setImageResource(data[i]);
            views.add(imageview);
            View view = new View(mContext);
            view.setBackgroundResource(R.drawable.point_shape_normal);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtils.dp2px(mContext, 5), DensityUtils.dp2px(mContext, 5));
            if (i != 0) {
                params.leftMargin = DensityUtils.dp2px(mContext, 10);
            }
            view.setLayoutParams(params);
            mPoint.addView(view);
        }
        mViewPager = viewpager;
        int item = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % views.size();
        mViewPager.setCurrentItem(item);

        if (handler != null) {
            handler.removeCallbacksAndMessages(MOVE_PAGER);
            handler.sendEmptyMessageDelayed(MOVE_PAGER, 3000);
        }

        mViewPager.setOnPageChangeListener(new CurrentPagerChangeListener());

        mViewPager.setOnTouchListener(new ViewPagerTounch());

    }

    /**
     * 屏幕个数
     *
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
    public void destroyItem(View container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        if (views.size() != 0) {
            view = views.get(position % views.size());
        }
        Log.e("TAG", "position" + position);
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                container.removeView(view);
            }
        }
        container.addView(view);
        return view;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        int position = mViewPager.getCurrentItem();
        Log.e("TAG", "position+++++++" + position);
        if (position == 0) {
            position = views.size();
            mViewPager.setCurrentItem(position, false);
        } else if (position == Integer.MAX_VALUE - 1) {
            position = views.size() - 1;
            mViewPager.setCurrentItem(position, false);
        }
        Log.d("TAG", "finish update after, position=" + position);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        return super.instantiateItem(container, position);
    }

    int prePosition = 0;

    private class CurrentPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0 || views.size() == 0 || position == 0) {
            }
            mPoint.getChildAt(prePosition).setBackgroundColor(Color.WHITE);
            mPoint.getChildAt(position % views.size()).setBackgroundColor(Color.GRAY);
            prePosition = position % views.size();
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    private class ViewPagerTounch implements View.OnTouchListener {
        float x = 0;
        float y = 0;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float dx = event.getX() - x;
                    float dy = event.getY() - y;
                    if (dx != 0) {
                        handler.removeMessages(MOVE_PAGER);
                    }
                    if (dy > 0) {
                        return true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    handler.sendEmptyMessageDelayed(MOVE_PAGER, 3000);
                    break;
                default:
                    break;
            }
            return false;
        }
    }
}
