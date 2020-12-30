package com.example.androidradio;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChannelFragment extends Fragment {
    String[] channels;
    List<Integer> channel_images;

    public ChannelFragment() {
    }

    @NonNull
    public static ChannelFragment newInstance() {
        Bundle args = new Bundle();
        ChannelFragment fragment = new ChannelFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channels, container, false);
        FragmentActivity ct = getActivity();
        channels = MainActivity.chan_names;
        channel_images = MainActivity.chan_images;
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(ct);
        recyclerView.setLayoutManager(manager);
        List<Drawable> d = new ArrayList<>();
        for (Integer img: channel_images) {
            d.add(getResources().getDrawable(img));
        }
        RecyclerView.Adapter<MyAdapter.MyViewHolder> adapter = new MyAdapter(channels, d, R.layout.my_text_view);
        recyclerView.setAdapter(adapter);

        TransitionInflater transitionInflater = TransitionInflater.from(getContext());
        setEnterTransition(transitionInflater.inflateTransition(R.transition.slide_out));
        setExitTransition(transitionInflater.inflateTransition(R.transition.slide_out));

        return view;
    }
}
