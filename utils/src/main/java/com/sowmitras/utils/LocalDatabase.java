package com.sowmitras.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

/**
 * @author tango4567
 * @version 0.0.1+
 ***/


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
     */
    public LocalDatabase(Context context, String preferenceName) {
        this.context = context;
        this.preferenceName = preferenceName;
        this.keyName = keyName;
        this.keyValue = keyValue;
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    /**
     * @param keyName  Give key name
     * @param keyValue Give Key Value
     *                 * Write String Value to Shared Preference
     */
    public static void writeStringValue(String keyName, String keyValue) {
        editor = sharedPreferences.edit();
        editor.putString(keyName, keyValue);
        editor.apply();
    }

    /**
     * @param keyName
     * @return String
     */
    public static String readStringValue(String keyName) {
        return sharedPreferences.getString(keyName, "");
    }

    /**
     * @param keyName
     * @param keyValue
     */
    public static void writeBooleanValue(String keyName, boolean keyValue) {
        editor = sharedPreferences.edit();
        editor.putBoolean(keyName, keyValue);
        editor.apply();
    }

    /**
     * @param keyName
     * @return Boolean
     */
    public static Boolean readBooleanValue(String keyName) {
        return sharedPreferences.getBoolean(keyName, false);
    }


    /**
     * @param keyName
     * @param keyValue
     */
    public static void writeIntegerValue(String keyName, Integer keyValue) {
        editor = sharedPreferences.edit();
        editor.putInt(keyName, keyValue);
        editor.apply();
    }

    /**
     * @param keyName
     * @return Boolean
     */
    public static Integer readIntegerValue(String keyName) {
        return sharedPreferences.getInt(keyName, 0);
    }

    /**
     * @return SharedPreference
     */
    public static SharedPreferences getMySharedPreference() {
        return sharedPreferences;
    }

    /**
     * @return SharedPreference.Editor
     */
    public static SharedPreferences.Editor getMySharedPreferenceEditor() {
        editor = sharedPreferences.edit();
        return editor;
    }
}
