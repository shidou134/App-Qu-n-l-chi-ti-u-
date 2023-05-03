package com.example.btlandroid.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.btlandroid.R;
import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.ui.chi.LoaiChiFragment;
import com.example.btlandroid.ui.chi.LoaiChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiChiDialog {
    private LoaiChiViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText etId,etName;
    private boolean mEditMode;

    public LoaiChiDialog(Context context, LoaiChiFragment fragment, LoaiChi ... loaiChi) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater =LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_loai_chi,null);
        etId = view.findViewById(R.id.etId);
        etName=view.findViewById(R.id.etName);
        if (loaiChi != null && loaiChi.length>0){
            etId.setText(""+loaiChi[0].lid);
            etName.setText(loaiChi[0].ten);
            mEditMode = true;

        }else {
            mEditMode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Dong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialog.dismiss();
                    }
                })
                .setPositiveButton("Luu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiChi lt = new LoaiChi();
                        lt.ten = etName.getText().toString();
                        if (mEditMode){
                            lt.lid = Integer.parseInt(etId.getText().toString());
                            mViewModel.update(lt);
                        }else{
                        mViewModel.insert(lt);
                        Toast.makeText(context,"Loai chi duoc luu",Toast.LENGTH_SHORT).show();}


                    }
                });
        mDialog = builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
