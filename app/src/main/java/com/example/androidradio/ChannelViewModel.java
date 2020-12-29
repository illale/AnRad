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

    LiveData<List<Channel>> getOrderedChannels() { return repo.getOrderedChannels(); }

    LiveData<List<Integer>> getOrderedImageIds() { return repo.getOrderedImageIds(); }

    LiveData<List<Integer>> getOrderedIds() { return repo.getOrderedIds(); }

    LiveData<List<String>> getOrderedAudioUrls() { return repo.getOrderedAudioUrls(); }

    LiveData<Integer> getById(String name) { return repo.getById(name); }
}
