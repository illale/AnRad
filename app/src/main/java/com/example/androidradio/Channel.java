package com.example.androidradio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Channel {
    //Crete structure of the Channel table in room database
    @PrimaryKey(autoGenerate = true) private int id;

    @ColumnInfo (name = "channel_name")
    private String channelName;

    @ColumnInfo (name = "channel_audio_url")
    private String channelAudioUrl;

    @ColumnInfo (name = "channel_song_url")
    private String channelSongUrl;

    @ColumnInfo (name = "channel_image_id")
    private int channelImageId;

    //Constructor to set the values for one row of the table
    public Channel(String channelName, String channelAudioUrl, String channelSongUrl, int channelImageId) {
        this.channelName = channelName;
        this.channelAudioUrl = channelAudioUrl;
        this.channelSongUrl = channelSongUrl;
        this.channelImageId = channelImageId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getChannelAudioUrl() {
        return this.channelAudioUrl;
    }

    public String getChannelSongUrl() {
        return this.channelSongUrl;
    }

    public int getId() {
        return this.id;
    }

    public int getChannelImageId() { return this.channelImageId; }

}
