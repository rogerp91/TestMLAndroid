package com.github.rogerp91.ml.ui.adapte;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.item.ItemFragment;

import java.util.List;

public class OtherProductAdapte extends RecyclerView.Adapter<ProductItemViewHolder> {

    private List<Result> mResults;
    private ItemFragment.ClickItemListener onClickItem;

    public OtherProductAdapte(List<Result> mResults, ItemFragment.ClickItemListener onClickItem) {
        this.mResults = mResults;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public ProductItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_horizontal, parent, false);
        return new ProductItemViewHolder(view, mResults);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemViewHolder holder, int position) {
        Log.d("TAG", "NAME: " + mResults.get(position).getTitle());
        Result result = mResults.get(position);
        holder.bind(result, onClickItem);
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }
}