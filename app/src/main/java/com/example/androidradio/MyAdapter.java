package com.example.androidradio;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] data;
    private List<Drawable> ids;
    private int LayoutId;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public MyViewHolder(View tv) {
            super(tv);
            textView = tv.findViewById(R.id.textView);
            imageView = tv.findViewById(R.id.imageView);
        }
    }

    public MyAdapter(String[] list, List<Drawable> image_ids, int layout) {
        data = list;
        ids = image_ids;
        this.LayoutId = layout;
    }

    public MyAdapter(String[] list, int layout) {
        data = list;
        this.LayoutId = layout;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(LayoutId, parent, false);
        return new MyViewHolder(v);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
        if (ids != null) {
            holder.imageView.setImageDrawable(ids.get(position));
        }
    }

    public int getItemCount() {
        return data.length;
    }

}
