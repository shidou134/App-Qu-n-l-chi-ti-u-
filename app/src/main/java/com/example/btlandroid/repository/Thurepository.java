package com.example.btlandroid.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.btlandroid.DAO.AppDatabase;
import com.example.btlandroid.DAO.ThuDAO;
import com.example.btlandroid.entity.ThongKeLoaiThu;
import com.example.btlandroid.entity.Thu;

import java.util.List;

public class Thurepository {
    private ThuDAO mThuDAO;
    private LiveData<List<Thu>> mAllThu;

    public Thurepository(Application application) {
        this.mThuDAO = AppDatabase.getDatabase(application).thuDAO();
        mAllThu = mThuDAO.findAll();

    }

    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }

    public LiveData<Float> sumTongThu() {
        return mThuDAO.sumTongThu();
    }

    public LiveData<List<ThongKeLoaiThu>> sumByLoaiThu() {
        return mThuDAO.sumByLoaiThu();
    }

    public void insert(Thu thu){
        new InsertAsyncTask(mThuDAO).execute(thu);
    }

    class InsertAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;

        public InsertAsyncTask(ThuDAO thuDAO) {
            this.mThuDAO = thuDAO;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mThuDAO.insert(thus[0]);
            return null;
        }
    }
    public void update(Thu thu){
        new UpdateAsyncTask(mThuDAO).execute(thu);
    }
    class UpdateAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;

        public UpdateAsyncTask(ThuDAO thuDAO) {
            this.mThuDAO = thuDAO;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mThuDAO.update(thus[0]);
            return null;
        }
    }
    public void delete(Thu thu){
        new DeleteAsyncTask(mThuDAO).execute(thu);
    }
    class DeleteAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDAO mThuDAO;

        public DeleteAsyncTask(ThuDAO thuDAO) {
            this.mThuDAO = thuDAO;
        }

        @Override
        protected Void doInBackground(Thu... thus) {
            mThuDAO.delete(thus[0]);
            return null;
        }
    }
}
