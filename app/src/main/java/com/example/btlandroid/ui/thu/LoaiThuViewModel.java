package com.example.btlandroid.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.btlandroid.DAO.LoaiThuDAO;
import com.example.btlandroid.entity.LoaiThu;
import com.example.btlandroid.repository.LoaiThurepository;

import java.util.List;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThurepository mLoaiThurepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;
    public LoaiThuViewModel(@NonNull Application application) {
        super(application);
        mLoaiThurepository = new LoaiThurepository(application);
        mAllLoaiThu = mLoaiThurepository.getAllLoaiThu();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        mLoaiThurepository.insert(loaiThu);
    }

    public void delete(LoaiThu loaiThu){
        mLoaiThurepository.delete(loaiThu);
    }
    public void update(LoaiThu loaiThu){
        mLoaiThurepository.update(loaiThu);
    }
}