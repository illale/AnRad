package com.example.androidradio;

import android.app.Application;
import android.os.AsyncTask;

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

    public void insert(Channel chn) {
        new insertAsyncTask(channelDao).execute(chn);
    }

    private static class insertAsyncTask extends AsyncTask<Channel, Void, Void> {
        private ChannelDao channelDao;

        insertAsyncTask(ChannelDao dao) {
            channelDao = dao;
        }

        @Override
        protected Void doInBackground(final Channel... params) {
            channelDao.insert(params[0]);
            return null;
        }
    }
}
