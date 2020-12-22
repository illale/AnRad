package com.example.androidradio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SimpleExoPlayer player = null;
    BottomNavigationView bottomNavigationView;
    String[] channelNames = {"YLEX", "RADIO NOVA", "SUOMI-ROCK", "NRJ", "ISKELMÄ", "PUHE", "RADIO HELMI", "RADIO ROCK", "SUOMI-POP", "AITO-ISKELMÄ"};
    int[] images = {R.drawable.ylex, R.drawable.radionova, R.drawable.suomirock, R.drawable.nrj, R.drawable.iskelma_valt, R.drawable.yle_puhe, R.drawable.helmiradio, R.drawable.radio_rock, R.drawable.radio_suomipop, R.drawable.aito_iskelma};
    Uri uri = null;
    int index = 0;
    public static boolean PLAYING = false;
    public static String song;
    public static String song_artist;
    private List<Channel> chans;
    public static String[] chan_names;
    public static List<Integer> chan_images = new ArrayList<>();
    private SharedPreferences shPref;
    public static String[] pref;
    Handler handler = new Handler();

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            setSong(index);
            handler.postDelayed(this, 5000);
        }
    };

    public static String[] getAllSettings() {
        return pref;
    }

    public void createSettings() {
        Context context = getApplicationContext();
        shPref = context.getSharedPreferences("Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shPref.edit();
        editor.putBoolean("SHOW_SONGS", true);
        editor.putBoolean("ENABLE_VISUALIZATION", false);
        editor.apply();
    }

    public void listSettings() {
        getApplicationContext();
        Map<String, ?> values = shPref.getAll();
        List<String> keys = new ArrayList<>(values.keySet());
        pref = new String[keys.size()];
        keys.toArray(pref);
    }

    public void printCurrentChannel(int id) {
        System.out.println("Current channel = " + chans.get(id).getChannelName());
    }

    public String getChannelAudioUrl(int id) {
        return chans.get(id).getChannelAudioUrl();
    }

    public String getChannelSongUrl(int id) {
        return chans.get(id).getChannelSongUrl();
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public MediaSource getAudioSource(DataSource.Factory factory, Uri address, String audioUrl) {
        /*
        Check if requested channel url contains .m3u8. If it contains, return HlsMediaSource object,
        which is used for playing HLS streams. If it does not contain, return ProgressiveMediaSource
        object which is used for playing continuous audio file streams, which are not sent to endusers
        with playlist files of small files.
        */
        if (audioUrl.contains(".m3u8")) {
            return new HlsMediaSource.Factory(factory).createMediaSource(address);
        } else {
            return new ProgressiveMediaSource.Factory(factory).createMediaSource(address);
        }
    }

    public void initPlayback(String audioUrl) {
        /*
        Create new instance of SimpleExoPlayer using
         */
        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();

        //Create uri from given url
        uri = Uri.parse(audioUrl);

        /*
        Create new DataSourceFactory, which creates new DataSource objects. DataSource is an object
        where incoming data can be read. While DefaultDataSourceFactory can be used for many types of
        streams, in this context it is used only to read data from streams that are distributed online
        */
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getApplicationContext(),
                Util.getUserAgent(getApplicationContext(), "AndroidRadio"));
        MediaSource audioSource = getAudioSource(dataSourceFactory, uri, audioUrl);

        //Inject MediaSource into SimpleExoPlayer.
        player.prepare(audioSource);
        //Start playback when SimpleExoPLayer is ready for it.
        player.setPlayWhenReady(true);
    }

    public void play(View v) {
        /*
        If player object has not been created, create one with selected channel, else
        if player object already exists, release it to stop playback, and change button state
        to play.
        */
        if (player == null) {
            String url = getChannelAudioUrl(index);
            initPlayback(url);
            PLAYING = true;
            changeButton();
            printCurrentChannel(index);
            this.setImage(index);
            this.setSong(index);
        } else {
            PLAYING = false;
            changeButton();
            releasePlayer();
        }
    }

    public void releasePlayer() {
        //Release player to stop playback, and set player variable to null
        player.release();
        player = null;
    }

    public void changeButton() {
        //Depending on the state of playback, change middle button to "play" or "stop"
        ImageButton view = findViewById(R.id.playButton);
        if (PLAYING) {
            view.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_pause));
        } else {
            view.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_play));
        }
        view.invalidate();
    }

    public void setImage(int i) {
        ImageView view = findViewById(R.id.imageView);
        view.setImageDrawable(getResources().getDrawable(images[i]));
        view.invalidate();
    }

    @SuppressLint("SetTextI18n")
    public void setSong(int i) {
        String url = getChannelSongUrl(i);

        if (url.equals("None")) {
            song = "Yle Puhe";
            song_artist = "Puhe";
        } else {
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
                try {

                    Iterator<String> rep = response.keys();
                    String key;
                    while(rep.hasNext()) {
                        key = rep.next();

                        if (response.optJSONObject(key) != null) {
                            if (response.getJSONObject(key).has("title")) {
                                song = response.getJSONObject(key).getString("title");

                                if (response.getJSONObject(key).has("artist")) {
                                    song_artist = response.getJSONObject(key).getString("artist");
                                } else if (response.getJSONObject(key).has("performer")) {
                                    song_artist = response.getJSONObject(key).getString("performer");
                                }
                                break;
                            } else if (response.getJSONObject(key).has("0")) {
                                song = response.getJSONObject(key).getJSONObject("0").getString("song");
                                song_artist = response.getJSONObject(key).getJSONObject("0").getString("artist");

                                break;
                            }
                        } else {
                            JSONObject ob = (JSONObject)response.getJSONArray("items").get(0);
                            if (ob.has("song")) {
                                song = ob.getString("song");
                                song_artist = ob.getString("artist");
                                break;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }, error -> System.out.println("JSON REQUEST ERROR"));

            queue.add(jsonObjectRequest);
        }
    }

    public int checkChannel(String channel) {
        //Finds and returns the index of given channel
        //NOTE: should be changed, when ROOM is used
        for (int i = 0; i <= channelNames.length; i++) {
            if (channelNames[i].equals(channel)) {
                return i;
            }
        }
        return 0;
    }

    public void setUri(View v) {
        /*
        This method is used only when selecting channel from recyclerview list
        */

        //Check if player instance exists, and release it if it does.
        if (player != null) {
            player.release();
        }
        //Get the index of chosen channel, that previous and next channels can be chosen correctly
        index = checkChannel(((TextView)v).getText().toString());
        String url = getChannelAudioUrl(index);
        //Initialize playback of a new channel
        PLAYING = true;
        initPlayback(url);
    }

    public void nextUri(View v) {
        /*
        Used for starting playback of a next channel in channels list
        */

        //Check that player object does not exist, and if it does release it.
        if (player != null) {
            releasePlayer();
        }

        //Check that index doesn't become greater than the length of the channels list, and if it does
        //set index to zero
        if (index == chans.size() - 1) {
            index = 0;
        } else {
            index++;
        }
        String url = getChannelAudioUrl(index);
        //Initialize playback of a new channel
        initPlayback(url);
        this.setImage(index);
        this.setSong(index);
    }

    public void previousUri(View v) {
        /*
        Used for starting playback of the previous channel from channels list
         */

        //If the player instance exists, release it, so that two medias aren't being played at the
        //same time
        if (player != null) {
            releasePlayer();
        }

        //Check that index doesn't become smaller than zero.
        if (index == 0) {
            index = chans.size() - 1;
        } else {
            index--;
        }
        String url = getChannelAudioUrl(index);
        //Initialize playback of a new channel
        initPlayback(url);
        this.setImage(index);
        this.setSong(index);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChannelViewModel viewModel = ViewModelProviders.of(this).get(ChannelViewModel.class);
        viewModel.getOrderedChannels().observe(this, channels -> {
            chans = channels;
            List<String> temp_chans = new ArrayList<>();
            List<Integer> temp_ids = new ArrayList<>();
            for (Channel chn: channels) {
                System.out.println(chn.getChannelName());
                System.out.println(chn.getChannelImageId());
                temp_chans.add(chn.getChannelName());
                temp_ids.add(chn.getChannelImageId());
            }
            chan_names = new String[ temp_chans.size()];
            temp_chans.toArray(chan_names);
            chan_images = temp_ids;

        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(PlayerFragment.newInstance(images[index]));
        createSettings();
        listSettings();
        setFragment(PlayerFragment.newInstance(images[index]));
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            Item -> {
                if (Item.getItemId() == R.id.navigation_player) {
                    openFragment(PlayerFragment.newInstance(images[index]));
                    handler.post(runnableCode);
                    return true;
                } else if (Item.getItemId() == R.id.navigation_channels) {
                    openFragment(ChannelFragment.newInstance());
                    handler.removeCallbacks(runnableCode);
                    return true;
                } else if (Item.getItemId() == R.id.navigation_settings) {
                    openFragment(SettingsFragment.newInstance());
                    handler.removeCallbacks(runnableCode);
                    return true;
                } else {
                    return false;
                }
            };
}

