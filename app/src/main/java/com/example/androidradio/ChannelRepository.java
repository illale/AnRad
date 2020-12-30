package com.example.androidradio;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ChannelRepository {
    private final ChannelDao channelDao;


    public ChannelRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        channelDao = db.channelsDao();
    }


    LiveData<List<Channel>> getAllChannels() {
        return channelDao.getAll();
    }

    LiveData<List<Channel>> getOrderedChannels() { return channelDao.getOrdered(); }

    LiveData<List<String>> getOrderedAudioUrls() { return channelDao.getOrderedAudioUrls(); }

    LiveData<List<Integer>> getOrderedIds() { return channelDao.getOrderedIds(); }

    LiveData<List<Integer>> getOrderedImageIds() { return channelDao.getOrderedImageIds(); }

    LiveData<Integer> getById(String name) { return channelDao.getById(name); }

    LiveData<List<String>> getOrderedNames() { return channelDao.getOrderedNames(); }

}
