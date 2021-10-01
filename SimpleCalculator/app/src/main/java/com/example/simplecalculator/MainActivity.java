//Danny Kirby
//109826879
//06/07/2020
//CSE390 Homework 1 Part 2

package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlusButton();
        initMultButton();
        initMinusButton();
        initDivButton();
    }


    private void initPlusButton() {
        final Button plus = findViewById(R.id.plusbutton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(plus.getWindowToken(), 0);
                EditText first = findViewById(R.id.firstinput);
                EditText second = findViewById(R.id.secondinput);

                TextView answerView = findViewById(R.id.answer);

                if (first.getText().toString().matches("") && !(second.getText().toString().matches(""))){
                    answerView.setText("Answer: " + second.getText().toString());
                    answerView.setVisibility(View.VISIBLE);
                    return;
                }

                else if (!(first.getText().toString().matches("")) && (second.getText().toString().matches(""))){
                    answerView.setText("Answer: " + first.getText().toString());
                    answerView.setVisibility(View.VISIBLE);
                    return;
                }

                else if (first.getText().toString().matches("") && (second.getText().toString().matches(""))){
                    answerView.setVisibility(View.INVISIBLE);
                    return;
                }

                    float sum = (Float.parseFloat(first.getText().toString()) + (Float.parseFloat(second.getText().toString())));

                answerView.setText("Answer: " + Float.toString(sum));

                answerView.setVisibility(View.VISIBLE);
            }

        });
    }

    private void initMinusButton() {
        final Button minus = findViewById(R.id.minusbutton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm1.hideSoftInputFromWindow(minus.getWindowToken(), 0);
                EditText first1 = findViewById(R.id.firstinput);
                EditText second1 = findViewById(R.id.secondinput);


                TextView answerView1 = findViewById(R.id.answer);


                if (first1.getText().toString().matches("") && !(second1.getText().toString().matches(""))){
                    answerView1.setText("Answer: " + second1.getText().toString());
                    answerView1.setVisibility(View.VISIBLE);
                    return;
                }

                else if (!(first1.getText().toString().matches("")) && (second1.getText().toString().matches(""))){
                    answerView1.setText("Answer: " + first1.getText().toString());
                    answerView1.setVisibility(View.VISIBLE);
                    return;
                }

                else if (first1.getText().toString().matches("") && (second1.getText().toString().matches(""))){
                    answerView1.setVisibility(View.INVISIBLE);
                    return;
                }

                float difference = (Float.parseFloat(first1.getText().toString()) - (Float.parseFloat(second1.getText().toString())));

                answerView1.setText("Answer: " + Float.toString(difference));

                answerView1.setVisibility(View.VISIBLE);
            }

        });
    }


    private void initMultButton() {
        final Button mult = findViewById(R.id.multiplybutton);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm2.hideSoftInputFromWindow(mult.getWindowToken(), 0);
                EditText first2 = findViewById(R.id.firstinput);
                EditText second2= findViewById(R.id.secondinput);
                TextView answerView2 = findViewById(R.id.answer);



                if (first2.getText().toString().matches("") && !(second2.getText().toString().matches(""))){
                    answerView2.setText("Answer: " + second2.getText().toString());
                    answerView2.setVisibility(View.VISIBLE);
                    return;
                }

                else if (!(first2.getText().toString().matches("")) && (second2.getText().toString().matches(""))){
                    answerView2.setText("Answer: " + first2.getText().toString());
                    answerView2.setVisibility(View.VISIBLE);
                    return;
                }

                else if (first2.getText().toString().matches("") && (second2.getText().toString().matches(""))){
                    answerView2.setVisibility(View.INVISIBLE);
                    return;
                }
                float product = (Float.parseFloat(first2.getText().toString()) * (Float.parseFloat(second2.getText().toString())));

                answerView2.setText("Answer: " + Float.toString(product));

                answerView2.setVisibility(View.VISIBLE);
            }

        });
    }


    private void initDivButton() {
        final Button div = findViewById(R.id.dividebutton);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm3 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm3.hideSoftInputFromWindow(div.getWindowToken(), 0);
                EditText first3 = findViewById(R.id.firstinput);
                EditText second3 = findViewById(R.id.secondinput);
                TextView answerView3 = findViewById(R.id.answer);


                if (first3.getText().toString().matches("") && !(second3.getText().toString().matches(""))){
                    answerView3.setText("Answer: " + second3.getText().toString());
                    answerView3.setVisibility(View.VISIBLE);
                    return;
                }

                else if (!(first3.getText().toString().matches("")) && (second3.getText().toString().matches(""))){
                    answerView3.setText("Answer: " + first3.getText().toString());
                    answerView3.setVisibility(View.VISIBLE);
                    return;
                }

                else if (first3.getText().toString().matches("") && (second3.getText().toString().matches(""))){
                    answerView3.setVisibility(View.INVISIBLE);
                    return;
                }

                float quotient = (Float.parseFloat(first3.getText().toString()) / (Float.parseFloat(second3.getText().toString())));

                answerView3.setText("Answer: " + Float.toString(quotient));

                answerView3.setVisibility(View.VISIBLE);
            }

        });
    }







}