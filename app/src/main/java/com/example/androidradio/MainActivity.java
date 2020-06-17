package com.example.androidradio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    SimpleExoPlayer player = null;
    String[] channels = {"https://yleuni-f.akamaihd.net/i/yleliveradiohd_2@113879/index_64_a-p.m3u8?sd=10&rebase=on",
            "https://stream.bauermedia.fi/radionova/radionova_64.aac",
            "https://stream.bauermedia.fi/suomirock/suomirock_64.aac",
            "https://cdn.nrjaudio.fm/adwz1/fi/35001/mp3_128.mp3",
            "https://stream.bauermedia.fi/iskelma/iskelma_64.aac",
            "https://yleuni-f.akamaihd.net/i/yleliveradiohd_5@113882/index_128_a-p.m3u8?sd=10&rebase=on",
            "https://digitacdn.akamaized.net/hls/live/629243/radiohelmi/master-128000.m3u8",
            "https://digitacdn.akamaized.net/hls/live/629243/radiorock/master.m3u8",
            "https://digitacdn.akamaized.net/hls/live/629243/radiosuomipop/master-128000.m3u8",
            "https://supla.digitacdn.net/live/_definst_/supla/aitoiskelma/playlist.m3u8"
    };

    String[] channelSongs = {"https://areena.api.yle.fi/v1/songs/current.json?app_id=areena_web_personal_prod&app_key=6c64d890124735033c50099ca25dd2fe&client=yle-areena-web&language=fi&v=7&serviceId=ylex",
            "https://www.radionova.fi/feed/onair",
            "https://www.radiosuomirock.fi/feed/onair",
            "https://nrj.fi/webplayer/json/energy.json",
            "https://www.iskelma.fi/feed/onair",
            "None",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=57&next_token=&limit=20",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=52&next_token=&limit=20",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=53&next_token=&limit=20",
            "https://supla-playlist.nm-services.nelonenmedia.fi/playlist?channel=58&next_token=&limit=20"
    };
    BottomNavigationView bottomNavigationView;
    String[] channelNames = {"YLEX", "RADIO NOVA", "SUOMI-ROCK", "NRJ", "ISKELMÄ", "PUHE", "RADIO HELMI", "RADIO ROCK", "SUOMI-POP", "AITO-ISKELMÄ"};
    Uri uri = null;
    int index = 0;

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void play(View v) {
        if (player == null) {
            player = new SimpleExoPlayer.Builder(getApplicationContext()).build();
            String url = channels[index];
            uri = Uri.parse(url);
            setText(index);
            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                    Util.getUserAgent(getApplicationContext(), "AndroidRadio"));
            MediaSource audioSource = null;
            if (url.contains(".m3u8")) {
                audioSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
            } else {
                audioSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
            }
            player.prepare(audioSource);
            player.setPlayWhenReady(true);
        } else {
            Log.println(Log.INFO, "D", "Player already setup");
        }
    }

    public void stop(View v) {
        player.stop();
    }

    public void releasePlayer(View v) {
        player.release();
        player = null;
    }

    public void setText(int i) {
        TextView view = (TextView)findViewById(R.id.textView2);
        view.setText(channelNames[i]);
        view.invalidate();
    }

    public void setSong(int i) {

    }

    public int checkChannel(String channel) {
        for (int i = 0; i <= channelNames.length; i++) {
            if (channelNames[i].equals(channel)) {
                return i;
            }
        }
        return 0;
    }

    public void setUri(View v) {
        if (player != null) {
            player.release();
        }
        index = checkChannel(((TextView)v).getText().toString());
        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();
        String url = channels[index];
        uri = Uri.parse(url);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "AndroidRadio"));
        MediaSource audioSource = null;
        if (url.contains(".m3u8")) {
            audioSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        } else {
            audioSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        }
        player.prepare(audioSource);
        player.setPlayWhenReady(true);
    }

    public void nextUri(View v) {
        if (player != null) {
            player.release();
        }
        if (index == channels.length - 1) {
            index = 0;
        } else {
            index++;
        }
        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();
        String url = channels[index];
        this.setText(index);
        uri = Uri.parse(url);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "AndroidRadio"));
        MediaSource audioSource = null;
        if (url.contains(".m3u8")) {
            audioSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        } else {
            audioSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        }
        player.prepare(audioSource);
        player.setPlayWhenReady(true);
    }

    public void previousUri(View v) {
        if (player != null) {
            player.release();
        }
        player.release();
        if (index == 0) {
            index = channels.length - 1;
        } else {
            index--;
        }
        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();
        String url = channels[index];
        this.setText(index);
        uri = Uri.parse(url);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "AndroidRadio"));
        MediaSource audioSource = null;
        if (url.contains(".m3u8")) {
            audioSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        } else {
            audioSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        }
        player.prepare(audioSource);
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(PlayerFragment.newInstance(channelNames[index]));
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                    if (Item.getItemId() == R.id.navigation_player) {
                        openFragment(PlayerFragment.newInstance(channelNames[index]));
                        return true;
                    } else if (Item.getItemId() == R.id.navigation_channels) {
                        openFragment(ChannelFragment.newInstance());
                        return true;
                    } else if (Item.getItemId() == R.id.navigation_settings) {
                        openFragment(SettingsFragment.newInstance());
                        return true;
                    } else {
                        return false;
                    }
                };
            };
}
