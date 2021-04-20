package com.sowmitras.utils;

import android.content.Context;
import android.content.Intent;

public class ReadyMade {

    /**
     * @implNote Call and use
     * @param context
     * @param title
     * @param content
     ***/
    public void shareContent(Context context, String link ,String title, String content) {
        Intent shareContentIntent = new Intent();
        shareContentIntent.setAction(Intent.ACTION_SEND);
        shareContentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareContentIntent.putExtra(Intent.EXTRA_TEXT, title + "\n" + content + "\n*Visit:* " + link);
        shareContentIntent.setType("text/plain");
        context.startActivity(shareContentIntent);
    }
}
