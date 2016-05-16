package com.demo.panguso.demo20160516.Fragment;

import android.view.View;

import com.demo.panguso.demo20160516.BaseClass.BaseFragment;
import com.demo.panguso.demo20160516.R;

/**
 * Created by panguso on 2016/5/16.
 */
public class RecommandFragment extends BaseFragment {
    @Override
    public View initView() {
        View view  = View.inflate(mContext, R.layout.recommand_fragment,null);
        return view;
    }
}
