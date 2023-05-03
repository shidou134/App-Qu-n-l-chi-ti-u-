package com.example.btlandroid.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.example.btlandroid.MainActivity;
import com.example.btlandroid.R;
import com.example.btlandroid.adapter.ChiSpinnerAdapter;
import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.entity.Chi;
import com.example.btlandroid.ui.chi.KhoanChiFragment;
import com.example.btlandroid.ui.chi.KhoanChiViewModel;
import com.example.btlandroid.ui.chi.LoaiChiFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ChiDialog {
    private KhoanChiViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText etId,etName,etAmount,etNote;
    private Spinner spType;

    private boolean mEditMode;
    private ChiSpinnerAdapter mAdapter;

    public ChiDialog(Context context, KhoanChiFragment fragment, Chi ... chi) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater =LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_chi,null);
        etId = view.findViewById(R.id.etId);
        etName=view.findViewById(R.id.etName);
        etAmount = view.findViewById(R.id.etAmount);
        etNote = view.findViewById(R.id.etNote);
        spType =view.findViewById(R.id.spType);
        mAdapter = new ChiSpinnerAdapter(fragment.getActivity());
        mViewModel.getAllLoaiChi().observe(fragment.getActivity(), new Observer<List<LoaiChi>>() {
            @Override
            public void onChanged(List<LoaiChi> loaiChis) {

                mAdapter.setList(loaiChis);
            }
        });
        spType.setAdapter(mAdapter);
        if (chi != null && chi.length>0){
            etId.setText(""+chi[0].tid);
            etName.setText(chi[0].ten);
            etAmount.setText(""+chi[0].sotien);
            etNote.setText(chi[0].ghichu);
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
                        Chi lt = new Chi();
                        lt.ten = etName.getText().toString();
                        lt.sotien = Float.parseFloat(etAmount.getText().toString());
                        lt.ghichu = etNote.getText().toString();
                        lt.lcid = ((LoaiChi) mAdapter.getItem(spType.getSelectedItemPosition())).lid;
                        if (mEditMode){
                            lt.tid = Integer.parseInt(etId.getText().toString());
                            mViewModel.update(lt);
                        }else{
                        mViewModel.insert(lt);
                        Toast.makeText(context,"Khoan chi duoc luu",Toast.LENGTH_SHORT).show();}


                    }
                });
        mDialog = builder.create();
    }
    public void show(){
        mDialog.show();
    }
}
