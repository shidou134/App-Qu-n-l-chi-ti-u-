package com.example.btlandroid.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.btlandroid.R;
import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.ui.chi.LoaiChiFragment;
import com.example.btlandroid.ui.chi.LoaiChiViewModel;

public class LoaiChiDetailDialog {
    private LoaiChiViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextView tvId,tvName;
    private boolean mEditMode;

    public LoaiChiDetailDialog(Context context, LoaiChiFragment fragment, LoaiChi loaiChi) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater =LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_detail_loai_chi,null);
        tvId = view.findViewById(R.id.tvId);
        tvName = view.findViewById(R.id.tvName);
        tvId.setText(""+loaiChi.lid);
        tvName.setText(""+loaiChi.ten);
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialog.dismiss();
                    }
                });
        mDialog = builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
