package com.example.androidradio;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ChannelList {
    private ArrayList<Channel> channels;
    private int index;

    public String loadJSON(AssetManager manager) {
        try {
            InputStream io = manager.open("channels.json");
            byte[] buffer = new byte[io.available()];
            io.read(buffer);
            io.close();
            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void build(String pathToJSON, AssetManager manager, int index)  {
        channels = new ArrayList<>();
        this.index = index;
        try {
            JSONObject json = new JSONObject(loadJSON(manager));
            JSONArray channelsJSONList = json.getJSONArray("channels");
            for (int i = 0; i < channelsJSONList.length(); i++) {
                JSONObject inside = channelsJSONList.getJSONObject(i);
                channels.add(new Channel(
                        inside.getString("name"), inside.getString("url"),
                        inside.getString("song_url"), inside.getString("image")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getChannelAudioUrl(int i) {
        return channels.get(i).getChannelAudioUrl();
    }

    public String getCurrentChannelAudioUrl() {
        return channels.get(index).getChannelAudioUrl();
    }

    public String getChannelName(int i) {
        return channels.get(i).getChannelName();
    }

    public String getCurrentChannelName() {
        return channels.get(index).getChannelName();
    }

    public String getChannelSongUrl(int i) {
        return channels.get(i).getChannelSongUrl();
    }

    public String getCurrentChannelSongUrl() {
        return channels.get(index).getChannelSongUrl();
    }

    public String getChannelImage(int i) {
        return channels.get(i).getChannelImage();
    }

    public String getCurrentChannelImage() {
        return channels.get(index).getChannelImage();
    }

    public Drawable getChannelDrawable(int i) {
        return channels.get(i).getChannelDrawable();
    }

    public Drawable getCurrentChannelDrawable() {
        return channels.get(index).getChannelDrawable();
    }

}
