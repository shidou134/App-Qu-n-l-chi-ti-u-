package com.example.btlandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.btlandroid.R;
import com.example.btlandroid.entity.LoaiChi;

import java.util.List;

public class ChiSpinnerAdapter extends BaseAdapter {
    private List<LoaiChi> mList;
    private LayoutInflater mLayoutInflater;
    public ChiSpinnerAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<LoaiChi> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList==null){
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        if (mList == null){
            return null;
        }
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        KhoanChiViewHolder holder;
        if (view ==null){
            view = mLayoutInflater.inflate(R.layout.spinner_chi_item,null,false);
            holder = new KhoanChiViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (KhoanChiViewHolder) view.getTag();
        }
        holder.tvName.setText(mList.get(i).ten);
        return view;
    }
    public static class KhoanChiViewHolder{
        public TextView tvName;
        public KhoanChiViewHolder(View view){
            tvName = view.findViewById(R.id.tvName);
        }
    }
}
