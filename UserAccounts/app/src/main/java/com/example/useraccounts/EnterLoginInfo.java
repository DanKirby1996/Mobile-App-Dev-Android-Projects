//Danny Kirby
//109826879
//6/17/20
//CSE 390 Midterm Coding part 2

package com.example.useraccounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.useraccounts.MainActivity.getDefault;

public class EnterLoginInfo extends AppCompatActivity {
    private EditText username2;
    private EditText password2;
    private Button actualLogInButton;
    private ImageButton addUserButton2;
    private ImageButton loginButton2;
    SharedPreferences preferences2;
    String usernameString2;
    String passwordString2;

    String loginHit;
    String usernameString3;
    String passwordString3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_login_info);


        username2 = findViewById(R.id.activity2UsernameEditText);
        password2 = findViewById(R.id.activity2PasswordEditText);
        actualLogInButton = findViewById(R.id.loginbutton);
        addUserButton2 = findViewById(R.id.activity2newUser);
        loginButton2 = findViewById(R.id.activity2login);

        preferences2 = getSharedPreferences("SP_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences2.edit();
        initLoginButton();
        addUserButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterLoginInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initLoginButton () {
        Button login = findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameString2 = username2.getText().toString();
                passwordString2 = password2.getText().toString();

                usernameString3 = preferences2.getString("USERNAME", "");
                passwordString3 = preferences2.getString("PASSWORD", "");



                if (usernameString2.matches(usernameString3) && passwordString2.matches(passwordString3)){
                    Intent intent2 = new Intent(EnterLoginInfo.this, MainActivity.class);
                   /* EditText usernametext = findViewById(R.id.usernameEditText);

                    usernametext.setText(usernameString2);

                    EditText passwordtext = findViewById(R.id.passwordEditText);
                    passwordtext.setText(passwordString2);

                    EditText nametext = findViewById(R.id.fullNameEditText);
                    nametext.setText(getDefault("NAME", getApplicationContext()));*/
                    loginHit = "T";
                    intent2.putExtra("loggedin", loginHit);
                    startActivity(intent2);
                }
                else{
                    TextView incorrect = findViewById(R.id.textView2);
                    incorrect.setVisibility(View.VISIBLE);
                }


            }
        });

    }





}