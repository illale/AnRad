package com.example.androidradio;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ChannelRepository {
    private ChannelDao channelDao;


    public ChannelRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        channelDao = db.channelsDao();
    }

    LiveData<Channel> getChannel(int id) {
        return channelDao.getById(id);
    }

    LiveData<List<Channel>> getAllChannels() {
        return channelDao.getAll();
    }

    LiveData<List<Channel>> getOrderedChannels() { return channelDao.getOrdered(); }

}
