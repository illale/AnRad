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

    @Query("SELECT id FROM Channel WHERE channel_name = (:name)")
    LiveData<Integer> getById(String name);

    @Query("SELECT * FROM Channel ORDER BY channel_name")
    LiveData<List<Channel>> getOrdered();

    @Query("SELECT channel_audio_url FROM Channel ORDER BY channel_name")
    LiveData<List<String>> getOrderedAudioUrls();

    @Query("SELECT id FROM Channel ORDER BY channel_name")
    LiveData<List<Integer>> getOrderedIds();

    @Query("SELECT channel_image_id FROM Channel ORDER BY channel_name")
    LiveData<List<Integer>> getOrderedImageIds();

    @Query("SELECT channel_name FROM Channel ORDER BY channel_name")
    LiveData<List<String>> getOrderedNames();

    @Insert
    void insertAll(Channel... channels);

    @Insert
    void insert(Channel channel);
}
