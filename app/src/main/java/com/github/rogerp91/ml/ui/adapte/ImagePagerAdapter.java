package com.github.rogerp91.ml.ui.adapte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.rogerp91.ml.MLibre;
import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.data.model.Picture;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

    private List<Picture> mPictures;

    public void setPictures(List<Picture> mPictures) {
        this.mPictures = mPictures;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) MLibre.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup imageLayout = (ViewGroup) layoutInflater.inflate(R.layout.header_picture_item, collection, false);
        Log.w("IMG", mPictures.get(position).getUrl());
        Picasso.get().load(mPictures.get(position).getUrl()).into(((ImageView) imageLayout.findViewById(R.id.imageView)));
        collection.addView(imageLayout);
        return imageLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mPictures.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}