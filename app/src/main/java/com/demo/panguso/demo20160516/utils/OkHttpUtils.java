package com.demo.panguso.demo20160516.utils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by yangfang on 2016/6/1.
 */
public class OkHttpUtils {

    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    private Request mRequest;
    public OkHttpUtils() {
        okHttpClient = new OkHttpClient();
    }
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    public void getAscy(String url, Callback callback) {
        mRequest = new Request.Builder().url(url).build();
        okHttpClient.newCall(mRequest).enqueue(callback);
    }

}
