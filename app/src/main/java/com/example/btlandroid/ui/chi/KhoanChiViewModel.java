package com.example.btlandroid.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.entity.Chi;
import com.example.btlandroid.repository.LoaiChirepository;
import com.example.btlandroid.repository.Chirepository;
import java.util.List;

public class KhoanChiViewModel extends AndroidViewModel {
    private Chirepository mChirepository;
    private LoaiChirepository mLoaiChirepository;
    private LiveData<List<Chi>> mAllChi;
    private LiveData<List<LoaiChi>> mAllLoaiChi;

    public KhoanChiViewModel(@NonNull Application application) {
        super(application);
        mChirepository = new Chirepository(application);
        mAllChi = mChirepository.getAllChi();
        mLoaiChirepository = new LoaiChirepository(application);
        mAllLoaiChi = mLoaiChirepository.getAllLoaiChi();

    }

    public LiveData<List<LoaiChi>> getAllLoaiChi(){
        return mAllLoaiChi;
    }
    public LiveData<List<Chi>> getAllChi() {
        return mAllChi;
    }
    public void insert(Chi chi){
        mChirepository.insert(chi);
    }

    public void delete(Chi chi){
        mChirepository.delete(chi);
    }
    public void update(Chi chi){
        mChirepository.update(chi);
    }
}