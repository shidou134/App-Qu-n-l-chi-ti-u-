package com.example.btlandroid.ui.thongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.btlandroid.entity.ThongKeLoaiChi;
import com.example.btlandroid.entity.ThongKeLoaiThu;
import com.example.btlandroid.repository.Chirepository;
import com.example.btlandroid.repository.Thurepository;

import java.util.List;

public class ThongKeViewModel extends AndroidViewModel {
    private Thurepository mThurepository;

    private Chirepository mChirepository;
    private LiveData<Float> mTongThu,mTongChi;
    private LiveData<List<ThongKeLoaiThu>> mThongKeLoaiThus;
    private LiveData<List<ThongKeLoaiChi>> mThongKeLoaiChis;
    public ThongKeViewModel(@NonNull Application application) {
        super(application);

        mThurepository= new Thurepository(application);
        mTongThu = mThurepository.sumTongThu();
        mThongKeLoaiThus = mThurepository.sumByLoaiThu();

        mChirepository= new Chirepository(application);
        mTongChi = mChirepository.sumTongChi();
        mThongKeLoaiChis = mChirepository.sumByLoaiChi();
    }

    public LiveData<Float> getTongThu() {
        return mTongThu;
    }
    public LiveData<Float> getTongChi() {
        return mTongChi;
    }

    public LiveData<List<ThongKeLoaiChi>> getThongKeLoaiChis() {
        return mThongKeLoaiChis;
    }
    public LiveData<List<ThongKeLoaiThu>> getThongKeLoaiThus() {
        return mThongKeLoaiThus;
    }
}
