package com.example.btlandroid.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.btlandroid.entity.LoaiThu;
import com.example.btlandroid.entity.Thu;
import com.example.btlandroid.repository.LoaiThurepository;
import com.example.btlandroid.repository.Thurepository;
import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    private Thurepository mThurepository;
    private LoaiThurepository mLoaiThurepository;
    private LiveData<List<Thu>> mAllThu;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public KhoanThuViewModel(@NonNull Application application) {
        super(application);
        mThurepository = new Thurepository(application);
        mAllThu = mThurepository.getAllThu();
        mLoaiThurepository = new LoaiThurepository(application);
        mAllLoaiThu = mLoaiThurepository.getAllLoaiThu();

    }

    public LiveData<List<LoaiThu>> getAllLoaiThu(){
        return mAllLoaiThu;
    }
    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }
    public void insert(Thu thu){
        mThurepository.insert(thu);
    }

    public void delete(Thu thu){
        mThurepository.delete(thu);
    }
    public void update(Thu thu){
        mThurepository.update(thu);
    }
}