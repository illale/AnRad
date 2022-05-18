package com.example.androidradio;


import android.graphics.drawable.Drawable;

public class Channel {
        //Crete structure of the Channel table in room database
        private final String channelName;
        private final String channelAudioUrl;
        private final String channelSongUrl;
        private final String channelImage;
        private final Drawable channelDrawable;

        public Channel(String channelName, String channelAudioUrl, String channelSongUrl, String channelImage) {
            this.channelName = channelName;
            this.channelAudioUrl = channelAudioUrl;
            this.channelSongUrl = channelSongUrl;
            this.channelImage = channelImage;
            this.channelDrawable = Drawable.createFromPath(this.channelImage);
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

        public String getChannelImage() { return this.channelImage; }

        public Drawable getChannelDrawable() { return this.channelDrawable; }

}
