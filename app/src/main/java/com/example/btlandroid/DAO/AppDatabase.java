package com.example.btlandroid.DAO;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.btlandroid.entity.LoaiThu;
import com.example.btlandroid.entity.Thu;

import com.example.btlandroid.entity.LoaiChi;
import com.example.btlandroid.entity.Chi;

@Database(entities = {LoaiThu.class, Thu.class, Chi.class, LoaiChi.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract LoaiThuDAO loaiThuDAO();
    public abstract ThuDAO thuDAO();

    public abstract ChiDAO chiDAO();

    public abstract LoaiChiDAO loaiChiDAO();

    public static AppDatabase INSTANCE;
    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateData(INSTANCE).execute();
        }
    };
    public static AppDatabase getDatabase(final Context context){
        if (INSTANCE==null){
            synchronized (AppDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"personal_db")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }
    public static class PopulateData extends AsyncTask<Void,Void,Void>{
        private LoaiThuDAO loaiThuDAO;
        private ThuDAO thuDAO;

        private LoaiChiDAO loaiChiDAO;

        private ChiDAO chiDAO;

        public PopulateData(AppDatabase db) {
            loaiThuDAO = db.loaiThuDAO();
            thuDAO = db.thuDAO();

            loaiChiDAO = db.loaiChiDAO();
            chiDAO = db.chiDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaithus = new String[]{"Luong","Thuong","Co phieu"};
            for (String it: loaithus) {
                LoaiThu lt = new LoaiThu();
                lt.ten =it;
                loaiThuDAO.insert(lt);

            }
            Thu thu = new Thu();
            thu.ten = "Luong thang 1";
            thu.sotien = 3000;
            thu.ltid = 2;
            thu.ghichu="";
            thuDAO.insert(thu);

            Log.d("BtlAndroid","insert data");

            String[] loaichis = new String[]{"Mua sam","An uong","Di choi"};
            for (String ic: loaichis) {
                LoaiChi lc = new LoaiChi();
                lc.ten =ic;
                loaiChiDAO.insert(lc);

            }
            Chi chi = new Chi();
            chi.ten = "Tien an thang 1";
            chi.sotien = 3000;
            chi.lcid = 2;
            chi.ghichu="";
            chiDAO.insert(chi);

            Log.d("BtlAndroid","insert data");
            return null;
        }
    }
}

