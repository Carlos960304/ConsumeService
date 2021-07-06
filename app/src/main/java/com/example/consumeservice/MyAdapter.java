package com.example.consumeservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumeservice.Model.Posts;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    List<Posts> results;

    public MyAdapter(Context context, List<Posts> results) {
        this.context = context;
        this.results = results;
    }

    public void setPostsList(List<Posts> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.tvUserId.setText("userId: " + String.valueOf(results.get(position).getUserId()));
        holder.tvId.setText("id: " + String.valueOf(results.get(position).getId()));
        holder.tvTitle.setText("title: " + results.get(position).getTitle());
        holder.tvBody.setText("body: " + results.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(results != null){
            return results.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId;
        TextView tvId;
        TextView tvTitle;
        TextView tvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUserId = (TextView)itemView.findViewById(R.id.tvUserId);
            tvId = (TextView)itemView.findViewById(R.id.tvId);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView)itemView.findViewById(R.id.tvBody);
        }
    }
}
