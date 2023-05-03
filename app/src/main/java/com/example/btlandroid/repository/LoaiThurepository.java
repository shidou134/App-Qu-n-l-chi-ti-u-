package com.example.btlandroid.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.btlandroid.DAO.AppDatabase;
import com.example.btlandroid.DAO.LoaiThuDAO;
import com.example.btlandroid.entity.LoaiThu;

import java.util.List;

public class LoaiThurepository {
    private LoaiThuDAO mloaiThuDAO;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThurepository(Application application) {
        this.mloaiThuDAO = AppDatabase.getDatabase(application).loaiThuDAO();
        mAllLoaiThu = mloaiThuDAO.findAll();

    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(mloaiThuDAO).execute(loaiThu);
    }

    class InsertAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;

        public InsertAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDAO.insert(loaiThus[0]);
            return null;
        }
    }
    public void update(LoaiThu loaiThu){
        new UpdateAsyncTask(mloaiThuDAO).execute(loaiThu);
    }
    class UpdateAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;

        public UpdateAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDAO.update(loaiThus[0]);
            return null;
        }
    }
    public void delete(LoaiThu loaiThu){
        new DeleteAsyncTask(mloaiThuDAO).execute(loaiThu);
    }
    class DeleteAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDAO mLoaiThuDAO;

        public DeleteAsyncTask(LoaiThuDAO loaiThuDAO) {
            this.mLoaiThuDAO = loaiThuDAO;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mloaiThuDAO.delete(loaiThus[0]);
            return null;
        }
    }
}
