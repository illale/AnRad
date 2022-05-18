package com.example.androidradio;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import org.jetbrains.annotations.NotNull;

public class Player {
    private SimpleExoPlayer player;
    private boolean playing;
    private int index;

    public Player() {
        this.player = null;
        this.playing = false;
        this.index = 0;
    }

    public MediaSource getAudioSource(DataSource.Factory factory, Uri address, @NotNull String audioUrl) {
        if (audioUrl.contains(".m3u8")) {
            return new HlsMediaSource.Factory(factory).createMediaSource(address);
        } else {
            return new ProgressiveMediaSource.Factory(factory).createMediaSource(address);
        }
    }

    public void initPlayBack(Context context, String audioUrl) {
        player = new SimpleExoPlayer.Builder(context).build();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context,
                Util.getUserAgent(context, "Kaiku"));
        MediaSource audioSource = getAudioSource(dataSourceFactory, Uri.parse(audioUrl), audioUrl);
        player.prepare(audioSource);
        player.setPlayWhenReady(true);
    }

    public void releasePlayer() {
        this.player.release();
        this.player = null;
    }
}
