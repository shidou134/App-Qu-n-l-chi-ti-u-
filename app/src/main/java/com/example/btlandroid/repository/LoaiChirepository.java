package com.example.btlandroid.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.btlandroid.DAO.AppDatabase;
import com.example.btlandroid.DAO.LoaiChiDAO;
import com.example.btlandroid.entity.LoaiChi;

import java.util.List;

public class LoaiChirepository {
    private LoaiChiDAO mloaiChiDAO;
    private LiveData<List<LoaiChi>> mAllLoaiChi;

    public LoaiChirepository(Application application) {
        this.mloaiChiDAO = AppDatabase.getDatabase(application).loaiChiDAO();
        mAllLoaiChi = mloaiChiDAO.findAll();

    }

    public LiveData<List<LoaiChi>> getAllLoaiChi() {
        return mAllLoaiChi;
    }
    public void insert(LoaiChi loaiChi){
        new InsertAsyncTask(mloaiChiDAO).execute(loaiChi);
    }

    class InsertAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDAO mLoaiChiDAO;

        public InsertAsyncTask(LoaiChiDAO loaiChiDAO) {
            this.mLoaiChiDAO = loaiChiDAO;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            mloaiChiDAO.insert(loaiChis[0]);
            return null;
        }
    }
    public void update(LoaiChi loaiChi){
        new UpdateAsyncTask(mloaiChiDAO).execute(loaiChi);
    }
    class UpdateAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDAO mLoaiChiDAO;

        public UpdateAsyncTask(LoaiChiDAO loaiChiDAO) {
            this.mLoaiChiDAO = loaiChiDAO;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            mloaiChiDAO.update(loaiChis[0]);
            return null;
        }
    }
    public void delete(LoaiChi loaiChi){
        new DeleteAsyncTask(mloaiChiDAO).execute(loaiChi);
    }
    class DeleteAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDAO mLoaiChiDAO;

        public DeleteAsyncTask(LoaiChiDAO loaiChiDAO) {
            this.mLoaiChiDAO = loaiChiDAO;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            mloaiChiDAO.delete(loaiChis[0]);
            return null;
        }
    }
}
