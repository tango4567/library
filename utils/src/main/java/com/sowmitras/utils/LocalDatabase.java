package com.sowmitras.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalDatabase {

    protected static Context context;
    protected static String preferenceName;
    protected static String keyName;
    protected static String keyValue;
    protected static SharedPreferences sharedPreferences;
    protected static SharedPreferences.Editor editor;

    public LocalDatabase() {
    }

    /**
     * @param context
     * @param preferenceName
     * */public LocalDatabase(Context context, String preferenceName) {
        this.context = context;
        this.preferenceName = preferenceName;
        this.keyName = keyName;
        this.keyValue = keyValue;
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    /**
     * @param keyName
     * @param keyValue
     * */
    public static void writeValue(String keyName, String keyValue){
        editor = sharedPreferences.edit();
        editor.putString(keyName, keyValue);
        editor.apply();
    }

    /**
     * @param keyName
     * @return String
     * */
    public static String readValue(String keyName){
        return sharedPreferences.getString(keyName,"");
    }

}
