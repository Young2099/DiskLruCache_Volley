package com.demo.panguso.demo20160516.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.base.BaseFragment;

/**
 * Created by panguso on 2016/5/16.
 *
 */
public class ArriveFragment extends BaseFragment {
    String url = "http://www.wed114.cn/jiehun/uploads/allimg/160426/39_160426110624_1.jpg";
    ImageView iv;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.arrive_fragment_xml, null);
        iv = (ImageView) view.findViewById(R.id.iv_arrive);
        initData();
        return view;
    }

    private void initData() {
        mContext.getImageCacheManager().loadImage(url, new ImageLoader.ImageListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Bitmap bitmap = response.getBitmap();
                iv.setImageBitmap(bitmap);
            }
        });
    }
}
