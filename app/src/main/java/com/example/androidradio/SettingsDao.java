package com.example.androidradio;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface SettingsDao {
    @Query("SELECT * FROM Settings")
    LiveData<List<Settings>> getAll();

    @Insert
    void insertAll(Settings... settings);

    @Insert
    void insert(Settings settings);
}
