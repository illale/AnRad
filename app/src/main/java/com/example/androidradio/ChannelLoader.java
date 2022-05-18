package com.example.androidradio;

import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ChannelLoader {

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

    public ArrayList<Channel> build(String pathToJSON, AssetManager manager) {
        ArrayList<Channel> channels = new ArrayList<>();
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
        return channels;
    }
}
