package com.example.androidradio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] data;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(View tv) {
            super(tv);
            /*
            tv.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   System.out.println("Adapter" + getAdapterPosition() + " clicked.");
               }
            });*/

            textView = (TextView) tv.findViewById(R.id.textView);
        }
    }

    public MyAdapter(String[] list) {
        data = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println(data.length);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
    }

    public int getItemCount() {
        return data.length;
    }

}
