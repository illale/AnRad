package com.example.androidradio;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class PlayerFragment extends Fragment {
    Handler handler = new Handler();
    public PlayerFragment() {

    }

    public static PlayerFragment newInstance() {
        Bundle args = new Bundle();
        PlayerFragment fragment = new PlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Runnable updateUI = new Runnable() {
        @Override
        public void run() {
            TextView song = getView().findViewById(R.id.channelSong);
            TextView artist = getView().findViewById(R.id.channelArtist);
            ImageView image = getView().findViewById(R.id.imageView);
            song.setText(MainActivity.song);
            artist.setText(MainActivity.song_artist);
            image.setImageDrawable(getResources().getDrawable(MainActivity.image));
            song.invalidate();
            artist.invalidate();
            handler.postDelayed(this, 500);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        handler.post(updateUI);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(updateUI);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        TextView textView = view.findViewById(R.id.channelSong);
        textView.setHorizontallyScrolling(true);
        textView.setSelected(true);
        textView.setText(MainActivity.song);
        textView.invalidate();
        TextView artistText = view.findViewById(R.id.channelArtist);
        artistText.setText(MainActivity.song_artist);
        artistText.invalidate();
        ImageButton button = view.findViewById(R.id.playButton);
        if (MainActivity.PLAYING) {
            button.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_pause));
        } else {
            button.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_play));
        }
        button.invalidate();
        return view;
    }

}
