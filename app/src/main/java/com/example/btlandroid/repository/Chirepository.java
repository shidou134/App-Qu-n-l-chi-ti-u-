package com.example.btlandroid.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.btlandroid.DAO.AppDatabase;
import com.example.btlandroid.DAO.ChiDAO;
import com.example.btlandroid.entity.ThongKeLoaiChi;
import com.example.btlandroid.entity.Chi;

import java.util.List;

public class Chirepository {
    private ChiDAO mChiDAO;
    private LiveData<List<Chi>> mAllChi;

    public Chirepository(Application application) {
        this.mChiDAO = AppDatabase.getDatabase(application).chiDAO();
        mAllChi = mChiDAO.findAll();

    }

    public LiveData<List<Chi>> getAllChi() {
        return mAllChi;
    }

    public LiveData<Float> sumTongChi() {
        return mChiDAO.sumTongChi();
    }

    public LiveData<List<ThongKeLoaiChi>> sumByLoaiChi() {
        return mChiDAO.sumByLoaiChi();
    }

    public void insert(Chi chi){
        new InsertAsyncTask(mChiDAO).execute(chi);
    }

    class InsertAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDAO mChiDAO;

        public InsertAsyncTask(ChiDAO chiDAO) {
            this.mChiDAO = chiDAO;
        }

        @Override
        protected Void doInBackground(Chi... chis) {
            mChiDAO.insert(chis[0]);
            return null;
        }
    }
    public void update(Chi chi){
        new UpdateAsyncTask(mChiDAO).execute(chi);
    }
    class UpdateAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDAO mChiDAO;

        public UpdateAsyncTask(ChiDAO chiDAO) {
            this.mChiDAO = chiDAO;
        }

        @Override
        protected Void doInBackground(Chi... chis) {
            mChiDAO.update(chis[0]);
            return null;
        }
    }
    public void delete(Chi chi){
        new DeleteAsyncTask(mChiDAO).execute(chi);
    }
    class DeleteAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDAO mChiDAO;

        public DeleteAsyncTask(ChiDAO chiDAO) {
            this.mChiDAO = chiDAO;
        }

        @Override
        protected Void doInBackground(Chi... chis) {
            mChiDAO.delete(chis[0]);
            return null;
        }
    }
}
