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
import com.example.btlandroid.entity.ThongKeLoaiThu;

import java.util.List;

public class ThongKeLoaiThuRecyclerviewAdapter extends RecyclerView.Adapter<ThongKeLoaiThuRecyclerviewAdapter.ThongKeLoaiThuViewHolder>{
    private LayoutInflater mLayoutInflater;
    private List<ThongKeLoaiThu> mList;

    public ThongKeLoaiThuRecyclerviewAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ThongKeLoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recyclerview_thongke_loaithu,parent,false);
        return new ThongKeLoaiThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongKeLoaiThuViewHolder holder, int position) {
        if (mList !=null){
            holder.tvTenLoaiThu.setText(mList.get(position).ten);
            holder.etTongLoaiThu.setText(""+mList.get(position).tong);
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        }
        return mList.size();
    }
    public void setList(List<ThongKeLoaiThu> list){
        this.mList=list;
        notifyDataSetChanged();
    }
    public static class ThongKeLoaiThuViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTenLoaiThu;
        public EditText etTongLoaiThu;

        public ThongKeLoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenLoaiThu = itemView.findViewById(R.id.tvTenLoaiChi);
            etTongLoaiThu = itemView.findViewById(R.id.etTongLoaiChi);
        }
    }
}
