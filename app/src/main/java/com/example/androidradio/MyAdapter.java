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
    private final String[] data;
    private final List<Drawable> ids;
    private final int LayoutId;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public View view;
        public MyViewHolder(View tv) {
            super(tv);
            view = tv.findViewById(R.id.text_holder);
            textView = tv.findViewById(R.id.textView);
            imageView = tv.findViewById(R.id.imageView);
        }
    }

    public MyAdapter(String[] list, List<Drawable> image_ids, int layout) {
        data = list;
        ids = image_ids;
        this.LayoutId = layout;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(LayoutId, parent, false);
        return new MyViewHolder(v);
    }

    public void onBindViewHolder(@NotNull MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
        holder.view.setOnClickListener(v -> {
            int itemPos = holder.getLayoutPosition();
            MainActivity.Instance.setChannel(itemPos);
            System.out.println("POS: " + itemPos);

        });
        holder.imageView.setImageDrawable(ids.get(position));
    }

    public int getItemCount() {
        return data.length;
    }
}
