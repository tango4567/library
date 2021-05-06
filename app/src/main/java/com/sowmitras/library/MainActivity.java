package com.sowmitras.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.sowmitras.utils.CheckEmptyString;
import com.sowmitras.utils.LocalDatabase;
import com.sowmitras.utils.ReadyMade;
import com.sowmitras.utils.TimeManagement;

import java.util.ArrayList;
import java.util.List;

import static com.sowmitras.utils.Tout.print;

public class MainActivity extends AppCompatActivity {

    LocalDatabase localDatabase;
    ReadyMade readyMade;
    TextView textView2;
    ArrayList<String> arrayList = new ArrayList<String>();

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


        showDialogT();



//        for(int i=0; i < s.length; i++){
//            print(s[i]);
//        }
    }

    private void showDialogT() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.list_with_search,null);
        TextInputEditText inputEditText = view.findViewById(R.id.auto_complete_text_view);
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                print(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
      //  CustomAdapter adapter = new CustomAdapter(s);
     //   recyclerView.setAdapter(adapter);
        builder.setView(view);

//        LayoutInflater layoutInflater =  getLayoutInflater();
//        builder.setView(layoutInflater.inflate(R.layout.list_with_search, null));


        builder.show();
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