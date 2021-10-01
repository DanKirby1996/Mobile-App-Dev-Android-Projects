//Danny Kirby
//109826879
//CSE390 Midterm
//Coding Exam Part 1
//6/17/20



package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button fifteen;
    private Button eighteen;
    private TextView amount;
    private EditText billEditText;
    private double tip;
    private double bill;
    private double totalBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fifteen = findViewById(R.id.fifteenbutton);
        eighteen = findViewById(R.id.eighteenbutton);
        billEditText = findViewById(R.id.editText);
        amount = findViewById(R.id.textView);

        initFifteenButton();
        initeighteenButton();
    }


    private void initFifteenButton() {
        fifteen = findViewById(R.id.fifteenbutton);
        fifteen.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                if (billEditText.getText().toString().matches("")){
                    return;
                }
                bill = Double.parseDouble(billEditText.getText().toString());

                if (bill > 0.00){
                    tip = bill * .15;
                }
                else{
                    return;
                }

                totalBill = bill + tip;
                amount.setText("Tip: $"+ tip + "   Total Bill: $" + totalBill);
                billEditText.setText("");

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(billEditText.getWindowToken(), 0);

            }

        });
    }



    private void initeighteenButton() {
        eighteen = findViewById(R.id.eighteenbutton);
        eighteen.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                if (billEditText.getText().toString().matches("")){
                    return;
                }
                bill = Double.parseDouble(billEditText.getText().toString());

                if (bill > 0.00){
                    tip = bill * .18;
                }
                else{
                    return;
                }

                totalBill = bill + tip;
                amount.setText("Tip: $"+ tip + "    Total Bill: $" + totalBill);
                billEditText.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(billEditText.getWindowToken(), 0);
            }

        });
    }


}