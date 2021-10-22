package com.blackseapps.interview.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.blackseapps.interview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public class CommonUtils {

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static AlertDialog.Builder showAlertDialog(Context context, DialogInterface.OnClickListener positive, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.app_name));
        builder.setMessage(title);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Okay", positive);
        return builder;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable getRandomImageData(Context context) {

        int number = (int) (Math.random() * 4);
        List<Drawable> list = new ArrayList<>();

        list.add(context.getResources().getDrawable(R.drawable.empty_image_1));
        list.add(context.getResources().getDrawable(R.drawable.empty_image_2));
        list.add(context.getResources().getDrawable(R.drawable.empty_image_3));
        list.add(context.getResources().getDrawable(R.drawable.empty_image_4));
        return list.get(number);
    }

}
