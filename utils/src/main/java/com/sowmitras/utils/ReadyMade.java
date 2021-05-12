package com.sowmitras.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.Snackbar;

public class ReadyMade {

    /**
     * @param context
     * @param title
     * @param content
     * @implNote Call and use
     ***/
    public void shareContent(Context context, String link, String title, String content) {
        Intent shareContentIntent = new Intent();
        shareContentIntent.setAction(Intent.ACTION_SEND);
        shareContentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareContentIntent.putExtra(Intent.EXTRA_TEXT, title + "\n" + content + "\n*Visit:* " + link);
        shareContentIntent.setType("text/plain");
        context.startActivity(shareContentIntent);
    }

    /**
     * Get device brand and model name
     */
    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    /**
     * Hide KeyBoard
     */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
       if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Calculate Number of Columns
     **/
    public static int calculateNoOfColumns(Context context, float width, float correction) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float main = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (main / width + correction);
    }

    /**
     * Return ArrayAdapter for Spinner
     * @param context
     * @param arrayList
     * @param item
     * @param dropDownItem
     **/
    public static ArrayAdapter<CharSequence> setSpinner(Context context, int arrayList, int item, int dropDownItem){
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, arrayList,item);
        arrayAdapter.setDropDownViewResource(dropDownItem);
        return arrayAdapter;
    }

}
