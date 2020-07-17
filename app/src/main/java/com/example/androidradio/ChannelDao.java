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

    @Query("SELECT * FROM Channel WHERE channel_name LIKE :name")
    LiveData<Channel> findByName(String name);

    @Query("SELECT channel_name FROM Channel")
    LiveData<List<String>> getChannelNames();

    @Query("SELECT COUNT(*) FROM Channel")
    LiveData<Integer> getNumberOfChannels();

    @Insert
    void insertAll(Channel... channels);

    @Insert
    void insert(Channel channel);
}
