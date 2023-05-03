package com.example.btlandroid.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.btlandroid.entity.Chi;
import com.example.btlandroid.entity.ThongKeLoaiChi;
import com.example.btlandroid.entity.ThongKeLoaiThu;
import com.example.btlandroid.entity.Thu;

import java.util.List;

@Dao
public interface ChiDAO {
    @Query("SELECT*FROM chi")
    LiveData<List<Chi>> findAll();

    @Query("SELECT sum(sotien) FROM chi")
    LiveData<Float> sumTongChi();

    @Query("SELECT b.lid,b.ten ,sum(a.sotien) as tong FROM chi a INNER JOIN loaichi b on a.lcid = b.lid" +
            " GROUP BY b.lid,b.ten")
    LiveData<List<ThongKeLoaiChi>> sumByLoaiChi();

    @Insert
    void insert(Chi chi);

    @Update
    void update(Chi chi);

    @Delete
    void delete(Chi chi);
}
