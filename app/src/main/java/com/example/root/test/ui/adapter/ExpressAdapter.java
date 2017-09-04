package com.example.root.test.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.test.R;
import com.example.root.test.bean.ExpressInfo;

import java.util.List;

/**
 * Created by root on 17-9-3.
 */

public class ExpressAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExpressInfo.DataBean> datas;
    private LayoutInflater inflater;

    public ExpressAdapter(Context mContext, List<ExpressInfo.DataBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ViewHolder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.item_express, viewGroup, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.mItemExpTvContent.setText(datas.get(i).getContext());
        return v;
    }

    class ViewHolder {
        private ImageView mItemExpIvStatus;
        private TextView mItemExpTvContent;

        public ViewHolder(View v) {
            mItemExpIvStatus = (ImageView) v.findViewById(R.id.item_exp_iv_status);
            mItemExpTvContent = (TextView) v.findViewById(R.id.item_exp_tv_content);
        }
    }
}
