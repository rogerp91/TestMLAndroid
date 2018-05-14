package com.github.rogerp91.ml.detail.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.Picture;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static java.lang.String.format;

public class PictureFragment extends BaseFragment implements BindFragment {

    @BindView(R.id.carousel_view)
    CarouselView carouselView;
    @BindView(R.id.count_photo)
    TextView countPhoto;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_picture;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {

    }

    @Override
    public void bind(Object... t) {
        List<Picture> list = getListOfPictureFromObject(t[0]);
        bind(list);
    }

    private void bind(List<Picture> pictures) {
        countPhoto.setText(format(getString(R.string.photo), pictures.size()));
        setGallery(pictures);

        progressBar.setVisibility(View.GONE);
        countPhoto.setVisibility(View.VISIBLE);
        carouselView.setVisibility(View.VISIBLE);
    }

    private void setGallery(List<Picture> pictures) {
        carouselView.setImageListener((position, imageView) -> {
            if (imageView.getDrawable() == null) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                final String imageUrl = pictures.get(position).getUrl();
                Picasso.get().load(imageUrl).networkPolicy(NetworkPolicy.NO_CACHE).into(imageView);
            }
        });
        carouselView.setPageCount(pictures.size());
    }

    private List<Picture> getListOfPictureFromObject(final Object objectList) {
        List<Picture> pictureList = new ArrayList<>();
        if (objectList instanceof List<?>) {
            for (Object object : (List<?>) objectList) {
                if (object instanceof Picture) {
                    pictureList.add((Picture) object);
                }
            }
        }
        return pictureList;
    }

}