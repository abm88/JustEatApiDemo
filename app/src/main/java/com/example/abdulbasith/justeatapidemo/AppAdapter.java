package com.example.abdulbasith.justeatapidemo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdulbasith.justeatapidemo.model.Restaurant;
import com.example.abdulbasith.justeatapidemo.model.ResturentListModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder>{
    private List<Restaurant> resturents;
    private int row;
    private Context applicationContext;

    public AppAdapter(List<Restaurant> resturents, int row, Context applicationContext) {
        this.resturents = resturents;
        this.row = row;
        this.applicationContext = applicationContext;
    }

    @Override
    public AppAdapter.AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(row,null);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppAdapter.AppViewHolder holder, int position) {

        holder.textView.setText(resturents.get(position).getAddress());
        Picasso.with(applicationContext)
                .load((Uri) resturents.get(position).getLogo())
                .resize(150,150)
                .centerCrop()
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return resturents.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public AppViewHolder(View itemView){
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.textView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
