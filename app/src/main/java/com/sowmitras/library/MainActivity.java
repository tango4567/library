package com.sowmitras.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

    }
}