package com.blackseapps.interview.ui.fragment.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BaseViewHolder;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public class ListingAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;


    private List<Product> productList;


    public ListingAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_item, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (productList != null && productList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (productList != null && productList.size() > 0) {
            return productList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Product> productList) {
        this.productList.addAll(productList);
        notifyDataSetChanged();
    }


    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.productItemTitleTxt)
        TextView productItemTitleTxt;

        @BindView(R.id.productItemStockTotalTxt)
        TextView productItemStockTotalTxt;

        @BindView(R.id.productItemPriceTxt)
        TextView productItemPriceTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            productItemTitleTxt.setText("");
            productItemStockTotalTxt.setText("");
            productItemPriceTxt.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Product product = productList.get(position);


            if (product.getTitle() != null) {
                productItemTitleTxt.setText(product.getTitle());
            }

            if (product.getStockTotal() != 0) {
                productItemStockTotalTxt.setText(product.getStockTotal());
            } else
                productItemStockTotalTxt.setText(R.string.listing_adapter_stock_total);

            if (product.getPrice() != null) {
                productItemPriceTxt.setText(product.getPrice());
            }

        }
    }

    public class EmptyViewHolder extends BaseViewHolder {


        @BindView(R.id.emptyTitle)
        TextView emptyTitle;

        @BindView(R.id.emptySubtitle)
        TextView emptySubtitle;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            emptyTitle.setVisibility(View.VISIBLE);

            emptySubtitle.setVisibility(View.VISIBLE);

        }
    }
}
