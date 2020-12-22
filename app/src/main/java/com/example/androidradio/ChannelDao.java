package com.example.androidradio;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChannelDao {
    @Query("SELECT * FROM Channel")
    LiveData<List<Channel>> getAll();

    @Query("SELECT * FROM Channel WHERE id = (:userId)")
    LiveData<Channel> getById(int userId);

    @Query("SELECT * FROM Channel ORDER BY channel_name")
    LiveData<List<Channel>> getOrdered();

    @Insert
    void insertAll(Channel... channels);

    @Insert
    void insert(Channel channel);
}
