//Danny Kirby
//109826879
//06/07/2020
//CSE 390 Homework 1 Part 1

//Some code borrowed from slides/textbook

package com.example.highlowgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private int randomNumber;
    private int numGuesses;
    private int remainingGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = (int) (Math.random() * (101)+1);
        numGuesses = 0;
        remainingGuesses = 10;
        initGuesses();
        initGuessButton();
        initPlayAgainButton();
    }



    private void initGuesses(){
        final TextView guessNumber = findViewById(R.id.guesses);
        final TextView remainingNumber = findViewById(R.id.remaining);
        guessNumber.setText("Guess Count: " + numGuesses);
        remainingNumber.setText("Remaining Guesses: " + remainingGuesses);
}

    private void initPlayAgainButton(){
        final Button playagainButton1 = findViewById(R.id.playagainbutton);
        playagainButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                playagainButton1.setVisibility(View.GONE);
                randomNumber = (int) (Math.random() * (101)+1);

                numGuesses = 0;
                remainingGuesses = 10;
                TextView guessNumber2 = findViewById(R.id.guesses);
                TextView remainingNumber2 = findViewById(R.id.remaining);
                guessNumber2.setText("Guess Count: " + numGuesses);
                remainingNumber2.setText("Remaining Guesses: " + remainingGuesses);

                TextView answer2 = findViewById(R.id.answer);
                answer2.setVisibility(View.INVISIBLE);

                TextView winnerloser1 = findViewById((R.id.winlose));

                winnerloser1.setVisibility(View.GONE);

            }
        });
    }



    private void initGuessButton(){
        final Button guessButton1 = findViewById(R.id.guessButton);
        guessButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(guessButton1.getWindowToken(),0);
                EditText guess = findViewById(R.id.guessEditText);
                if (guess.getText().toString().matches("")){
                    return;
                }

                numGuesses++;
                remainingGuesses--;

                TextView guessNumber1 = findViewById(R.id.guesses);
                TextView remainingNumber1 = findViewById(R.id.remaining);
                guessNumber1.setText("Guess Count: " + numGuesses);
                remainingNumber1.setText("Remaining Guesses: " + remainingGuesses);
                Button playagain = findViewById(R.id.playagainbutton);
                TextView winnerloser = findViewById((R.id.winlose));

                TextView answer1 = findViewById(R.id.answer);
                int guessInt = Integer.parseInt(guess.getText().toString());
                guess.setText("");

                if (guessInt < randomNumber){
                    answer1.setText("You guessed: " + guessInt + ". Your guess is too low.");
                    answer1.setTextColor(0xFFDA1414);
                    answer1.setVisibility(View.VISIBLE);
                }
                else if (guessInt > randomNumber){
                    answer1.setText("You guessed: " + guessInt + " . Your guess is too high.");
                    answer1.setTextColor(0xFFDA1414);
                    answer1.setVisibility(View.VISIBLE);
                }
                else{
                    answer1.setText("You guessed: " + guessInt + ". You've guessed correctly!");
                    answer1.setTextColor(0xFF3AEC1B);
                    answer1.setVisibility(View.VISIBLE);
                    playagain.setVisibility(View.VISIBLE);
                    winnerloser.setText("YOU WIN");
                    winnerloser.setVisibility(View.VISIBLE);
                }

                if (numGuesses >= 10){
                    playagain.setVisibility(View.VISIBLE);
                    winnerloser.setText("YOU LOSE");
                    winnerloser.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}