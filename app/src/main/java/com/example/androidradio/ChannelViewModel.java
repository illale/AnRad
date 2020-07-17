package com.example.androidradio;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ChannelViewModel extends AndroidViewModel {
    private ChannelRepository repo;

    public ChannelViewModel(Application app) {
        super(app);
        repo = new ChannelRepository(app);
    }

    LiveData<List<Channel>> getAllChannels() {
        return repo.getAllChannels();
    }

    LiveData<Channel> getChannelById(int id) {
        return repo.getChannel(id);
    }


}
