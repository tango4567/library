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
        LocalDatabase.writeValue("testKeyValue", "Tango4567 Test");
        print(LocalDatabase.readValue("testKeyValue"));

        print(TimeManagement.getCurrentTimeAndDate()); //<<<<<<<TODO Time Management Usage

    }
}