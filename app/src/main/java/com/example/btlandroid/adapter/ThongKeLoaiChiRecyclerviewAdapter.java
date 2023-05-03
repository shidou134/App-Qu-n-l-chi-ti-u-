package com.example.btlandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btlandroid.R;
import com.example.btlandroid.entity.ThongKeLoaiChi;

import java.util.List;

public class ThongKeLoaiChiRecyclerviewAdapter extends RecyclerView.Adapter<ThongKeLoaiChiRecyclerviewAdapter.ThongKeLoaiChiViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<ThongKeLoaiChi> mList;

    public ThongKeLoaiChiRecyclerviewAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ThongKeLoaiChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recyclerview_thongke_loaichi,parent,false);
        return new ThongKeLoaiChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeLoaiChiViewHolder holder, int position) {
        if (mList !=null){
            holder.tvTenLoaiChi.setText(mList.get(position).ten);
            holder.etTongLoaiChi.setText(""+mList.get(position).tong);
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }
    public void setList(List<ThongKeLoaiChi> list){
        this.mList=list;
        notifyDataSetChanged();
    }
    public static class ThongKeLoaiChiViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTenLoaiChi;
        public EditText etTongLoaiChi;

        public ThongKeLoaiChiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenLoaiChi = itemView.findViewById(R.id.tvTenLoaiChi);
            etTongLoaiChi = itemView.findViewById(R.id.etTongLoaiChi);
        }
    }
}
