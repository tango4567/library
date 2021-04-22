package com.sowmitras.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.sowmitras.utils.CheckEmptyString;
import com.sowmitras.utils.LocalDatabase;
import com.sowmitras.utils.ReadyMade;
import com.sowmitras.utils.TimeManagement;

import static com.sowmitras.utils.Tout.print;

public class MainActivity extends AppCompatActivity {

    LocalDatabase localDatabase;
    ReadyMade readyMade;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readyMade = new ReadyMade();
        localDatabase = new LocalDatabase(this, "library");  //<<<<<<<TODO LocalDatabase usage
        textView2 = findViewById(R.id.textView2);

        textView2.setText(readyMade.getDeviceName()); //TODO: Get device brand and model name

        LocalDatabase.writeBooleanValue("boolean", true);
        LocalDatabase.writeIntegerValue("integer", 100);
        LocalDatabase.writeStringValue("string", "Tango4567 Test");

        print(LocalDatabase.readStringValue("string"));
        print(String.valueOf(LocalDatabase.readBooleanValue("boolean")));
        print(String.valueOf(LocalDatabase.readIntegerValue("integer")));

        print(TimeManagement.getCurrentTimeAndDate()); //<<<<<<<TODO Time Management Usage

        String temp = null; //<<<<<<<TODO CheckEmptyString
        print("Null " + String.valueOf(new CheckEmptyString().check(temp)));

        temp = "";
        print("Empty " + String.valueOf(new CheckEmptyString().check(temp)));

        temp = "      ";
        print("WhiteSpace " + String.valueOf(new CheckEmptyString().check(temp)));

        temp = "   asdasdad   ";
        print("WhiteSpace with character " + String.valueOf(new CheckEmptyString().check(temp)));

        temp = "asda  sda";
        print("Character " + String.valueOf(new CheckEmptyString().check(temp)));

        SharedPreferences sharedPreferences = localDatabase.getMySharedPreference();


    }


    public void ShowSnackBar(View view) {
        Snackbar.make(view, "Hello", Snackbar.LENGTH_INDEFINITE).setAction("Show Toast", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    public void shareContent(View view) {
        readyMade.shareContent(this, "https://tarunmahajan.com", "I found great photos..", "This site content different kind of photos which is captured by *Tarun Mahajan* with the help of mobile phone. Must");
    }
}