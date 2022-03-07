package com.example.interest_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // Declare TextView
    private TextView text;

    // OnCreateMethod
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // assign text value of textView2
     text = (TextView) findViewById(R.id.textView2);

     // Grabs Value from main activity
    Double res = getIntent().getExtras().getDouble("result") ;
    text.setText(res.toString());
    }
}
