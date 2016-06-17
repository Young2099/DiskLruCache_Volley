package com.demo.panguso.demo20160516.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.demo.panguso.demo20160516.R;
import com.demo.panguso.demo20160516.base.BaseFragment;

/**
 * Created by panguso on 2016/5/16.
 *
 */
public class ArriveFragment extends BaseFragment {
    String url = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=176005081,877018693&fm=111&gp=0.jpg";
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

        StringRequest request = new StringRequest(Request.Method.GET, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
