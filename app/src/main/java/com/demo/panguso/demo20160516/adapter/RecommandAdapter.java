package com.demo.panguso.demo20160516.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.panguso.demo20160516.R;

import java.util.ArrayList;

/**
 * Created by panguso on 2016/5/17.
 */
public class RecommandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private View mHeaderView;
    private ArrayList<String> mDatas = new ArrayList<>();
    Context mContext;

    public RecommandAdapter(Context context) {
        mContext = context;
        for (int i = 0; i < 10; i++) {
            mDatas.add("" + i);
        }
    }


    public void setHeadrView(View view) {
        mHeaderView = view;
        notifyItemChanged(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_HEADER;
        }
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new Holder(mHeaderView);
        }
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new Holder(layout);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            return;
        }
        if (holder instanceof Holder) {
            ((Holder) holder).mText.setText(mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        TextView mText;

        public Holder(View itemView) {
            super(itemView);
            if (itemView == mHeaderView) return;
            mText = (TextView) itemView.findViewById(R.id.tv);
        }
    }

}
