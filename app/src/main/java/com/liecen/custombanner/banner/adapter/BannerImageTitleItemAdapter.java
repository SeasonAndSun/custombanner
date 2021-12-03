package com.liecen.custombanner.banner.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.liecen.custombanner.BaseApplication;
import com.liecen.custombanner.R;

import java.util.List;


/**
 * com.firesports.videos.ui.fragment
 * Author by MengQianYi, Date on 2021/7/21.
 * Not easy to write code, please indicate.
 */

public class BannerImageTitleItemAdapter extends BannerAdapter<String, BannerImageTitleItemAdapter.ImageTitleHolder> {

    public BannerImageTitleItemAdapter(List<String> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageTitleHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new ImageTitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, parent, false));
    }

    @Override
    public void onBindView(ImageTitleHolder holder, String bean, int position, int size) {
        Glide.with(BaseApplication.getInstance()).load(bean)
                .placeholder(R.drawable.banner_default_bg)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(view -> {

        });
    }

    public class ImageTitleHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ImageTitleHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
        }
    }
}
