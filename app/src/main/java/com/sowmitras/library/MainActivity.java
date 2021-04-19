package com.sowmitras.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.sowmitras.utils.CheckEmptyString;
import com.sowmitras.utils.LocalDatabase;
import com.sowmitras.utils.TimeManagement;

import static com.sowmitras.utils.Tout.print;

public class MainActivity extends AppCompatActivity {

    LocalDatabase localDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localDatabase = new LocalDatabase(this, "library");  //<<<<<<<TODO LocalDatabase usage

        LocalDatabase.writeBooleanValue("boolean", true);
        LocalDatabase.writeIntegerValue("integer", 100);
        LocalDatabase.writeStringValue("string", "Tango4567 Test");

        print(LocalDatabase.readStringValue("string"));
        print(String.valueOf(LocalDatabase.readBooleanValue("boolean")));
        print(String.valueOf(LocalDatabase.readIntegerValue("integer")));

        print(TimeManagement.getCurrentTimeAndDate()); //<<<<<<<TODO Time Management Usage

        String temp = null; //<<<<<<<TODO CheckEmptyString
        print("Null "+String.valueOf(new CheckEmptyString().check(temp)));

        temp = "";
        print("Empty "+String.valueOf(new CheckEmptyString().check(temp)));

        temp = "      ";
        print("WhiteSpace "+String.valueOf(new CheckEmptyString().check(temp)));

        temp = "   asdasdad   ";
        print("WhiteSpace with character "+String.valueOf(new CheckEmptyString().check(temp)));

        temp = "asda  sda";
        print("Character "+String.valueOf(new CheckEmptyString().check(temp)));

        SharedPreferences sharedPreferences = localDatabase.getMySharedPreference();

    }
}