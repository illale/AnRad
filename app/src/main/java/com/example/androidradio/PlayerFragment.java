package com.example.androidradio;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


public class PlayerFragment extends Fragment {
    public static String name;
    public static int image;
    public PlayerFragment() {

    }

    public static PlayerFragment newInstance(String channel, int image_id) {
        Bundle args = new Bundle();
        PlayerFragment fragment = new PlayerFragment();
        fragment.setArguments(args);
        name = channel;
        image = image_id;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(image));
        imageView.invalidate();
        TextView textView = (TextView)view.findViewById(R.id.textView2);
        textView.setHorizontallyScrolling(true);
        textView.setSelected(true);
        textView.invalidate();
        ImageButton button = (ImageButton)view.findViewById(R.id.playButton);
        if (MainActivity.PLAYING) {
            button.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_pause));
        } else {
            button.setImageDrawable(getResources().getDrawable(R.drawable.exo_controls_play));
        }
        return view;
    }

}
