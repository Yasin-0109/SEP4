package com.example.legalizeco2.dao;

import com.example.legalizeco2.model.Warning;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface WarningDao {

    @Insert
    void insert(Warning warning);

    @Query("DELETE FROM warning_table")
    void deleteAll();

    @Query("SELECT * FROM warning_table ORDER BY warning ASC")
    LiveData<List<Warning>> getAllWarnings();
}
