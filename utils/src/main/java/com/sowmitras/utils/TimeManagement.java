package com.sowmitras.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeManagement {

    public static String getCurrentTimeAndDate() {
        Date date = new Date();
        String strDateFormat = "yyyy-mm-dd HH:MM:SS";
        SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat, Locale.getDefault());
        return dateFormat.format(date);
    }
}
