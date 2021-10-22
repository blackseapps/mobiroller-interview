package com.blackseapps.interview.ui.dilalog.CategoryAddDialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Category;
import com.blackseapps.interview.data.network.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {


    List<Category> categories;

    public CategoryAdapter(@NonNull Context context, ArrayList<Category> categories) {
        super(context, R.layout.spinner_adapter_category,R.id.categoryText, categories);
    }


    public void addItems(List<Category> categories) {
        this.categories.addAll(categories);
       // notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_adapter_category, parent, false);
        }

        Category rowItem = getItem(position);


        TextView txtTitle = (TextView) convertView.findViewById(R.id.categoryText);
        txtTitle.setText(rowItem.getName());

        return convertView;
    }
}
