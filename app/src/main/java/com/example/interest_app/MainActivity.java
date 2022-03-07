package com.example.interest_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare EditText, Button, TextView components as variables in Main Activity
    private EditText borrow,  interest, terms;
    private Button button;
    private TextView text;

    // OnCreate Method;
    // Assign variables declared in Main Activity values of xml fields
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        borrow = (EditText)findViewById(R.id.borrowing_amount);
        interest = (EditText)findViewById(R.id.interest_rate);
        terms = (EditText)findViewById(R.id.loan_terms);

        button = (Button)findViewById(R.id.button);

        // Sets an onClickListener for Calculate button
        button.setOnClickListener(new View.OnClickListener() {

            // OnClick method; parses doubles into variables declared earlier
            // toString method
            @Override
            public void onClick(View view) {
                double borrowing_amount = Double.parseDouble(borrow.getText().toString());
                double interest_rate = Double.parseDouble(interest.getText().toString());
                int term_repayments = Integer.parseInt(terms.getText().toString());
                interest_rate = interest_rate / 100 ;
                double amount_to_owe = (borrowing_amount + borrowing_amount * interest_rate) / (term_repayments * 12);

                // Intent parses result value into "SecondActivity" class
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("result", amount_to_owe);

                startActivity(i);
            }
        });

    }
}