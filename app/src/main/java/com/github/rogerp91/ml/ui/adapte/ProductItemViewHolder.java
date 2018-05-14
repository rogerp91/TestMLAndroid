package com.github.rogerp91.ml.ui.adapte;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.item.ItemFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imagen)
    ImageView imagen;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.price)
    TextView price;

    private ItemFragment.ClickItemListener itemListener;
    private Context mContext;
    List<Result> mResults;

    public ProductItemViewHolder(View itemView, List<Result> mResults) {
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

        if (!result.getThumbnail().isEmpty()) {
            Picasso.get().load(result.getThumbnail()).into(imagen);
        }

        setListener(result);
    }

    private void setListener(final Result result) {
        itemView.setOnClickListener(v -> {
            itemListener.onClick(result, mResults);
//            itemListener.onClick(result.getId());
        });
    }

}