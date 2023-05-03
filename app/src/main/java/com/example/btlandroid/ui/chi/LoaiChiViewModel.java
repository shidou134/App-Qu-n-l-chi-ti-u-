package com.example.btlandroid.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.btlandroid.DAO.LoaiChiDAO;
import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.repository.LoaiChirepository;

import java.util.List;

public class LoaiChiViewModel extends AndroidViewModel {
    private LoaiChirepository mLoaiChirepository;
    private LiveData<List<LoaiChi>> mAllLoaiChi;
    public LoaiChiViewModel(@NonNull Application application) {
        super(application);
        mLoaiChirepository = new LoaiChirepository(application);
        mAllLoaiChi = mLoaiChirepository.getAllLoaiChi();
    }

    public LiveData<List<LoaiChi>> getAllLoaiChi() {
        return mAllLoaiChi;
    }
    public void insert(LoaiChi loaiChi){
        mLoaiChirepository.insert(loaiChi);
    }

    public void delete(LoaiChi loaiChi){
        mLoaiChirepository.delete(loaiChi);
    }
    public void update(LoaiChi loaiChi){
        mLoaiChirepository.update(loaiChi);
    }
}