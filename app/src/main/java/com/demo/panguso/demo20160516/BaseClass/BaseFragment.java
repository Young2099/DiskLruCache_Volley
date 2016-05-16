package com.demo.panguso.demo20160516.BaseClass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo20160516.MainActivity;

/**
 * Created by panguso on 2016/5/16.
 */
public abstract class BaseFragment extends Fragment {

    public MainActivity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = (MainActivity) getActivity();
        View view = initView();
        return view;
    }

    public abstract View initView();
}
