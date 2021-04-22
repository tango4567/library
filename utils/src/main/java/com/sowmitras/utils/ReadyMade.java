package com.sowmitras.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

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
}
