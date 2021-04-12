package com.sowmitras.utils;

import android.util.Log;

/**
 * T Terminal
 * OutPut with Long String
 * */
public class Tout {

    protected static final String TAG = "tango4567";

    /**
     * @param text
     * @return Output in Terminal with tango4567 Tag
     * */
    public static void print(String text) {
        android.util.Log.wtf(TAG, text);
    }
}
