package com.github.rogerp91.ml.ui.adapte;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.data.model.Attribute;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.item.ItemFragment;
import com.github.rogerp91.ml.util.Const;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imagen)
    ImageView imagen;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.total)
    TextView total;
    @BindView(R.id.rating)
    RatingBar rating;

    @BindView(R.id.more)
    TextView more;

    private ItemFragment.ClickItemListener itemListener;
    private Context mContext;
    private List<Result> mResults;

    public ItemViewHolder(View itemView, List<Result> mResults) {
        super(itemView);
        mContext = itemView.getContext();
        this.mResults = mResults;
        ButterKnife.bind(this, itemView);
    }

    void bind(final Result result, ItemFragment.ClickItemListener listener) {
        itemListener = listener;

        if (result.getTitle() != null && !result.getTitle().isEmpty()) {
            title.setText(result.getTitle());
        }

        if (result.getPrice() != null) {
            price.setText(String.format("$ %s", Double.toString(result.getPrice())));
        }

        if (result.getReviews() != null) {
            if (result.getReviews().getRatingAverage() != null) {
                float f = result.getReviews().getRatingAverage().floatValue();
                rating.setRating(f);
                total.setText(String.format("(%s)", Integer.toString(result.getReviews().getTotal())));
            }
        }

        if (!result.getThumbnail().isEmpty()) {
            Picasso.get().load(result.getThumbnail()).into(imagen);
        }

        String brand = "Ukn";
        String model = "Ukn";

        if (result.getAttributes().size() != 0) {

            for (Attribute attribute : result.getAttributes()) {
                if (attribute.getId().equals(Const.MODEL)) {
                    model = attribute.getValueName();
                }
                if (attribute.getId().equals(Const.BRAND)) {
                    brand = attribute.getValueName();
                }
            }
            String mores = mContext.getString(R.string.more) + " " + brand + " " + model;
            more.setText(mores);
        }
        Picasso.get().load(result.getThumbnail()).into(imagen);

        setListener(result);
    }

    private void setListener(final Result result) {
        more.setOnClickListener(v -> {
            itemListener.onClick(result, mResults);
//            itemListener.onClick(result.getId());
        });

        itemView.setOnClickListener(v -> {
            itemListener.onClick(result, mResults);
//            itemListener.onClick(result.getId());
        });
    }

}