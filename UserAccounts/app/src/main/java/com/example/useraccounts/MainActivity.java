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

public class MainActivity extends AppCompatActivity {
    private EditText username1;
    private EditText password1;
    private EditText fullnameedittext;
    private Button saveButton;
    private ImageButton addUserButton1;
    private ImageButton loginButton1;
    private String username;
    private String password;
    private String fullName;
    private String loggedin;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username1 = findViewById(R.id.usernameEditText);
        password1 = findViewById(R.id.passwordEditText);
        fullnameedittext = findViewById(R.id.fullNameEditText);
        saveButton = findViewById(R.id.savebutton);
        addUserButton1 = findViewById(R.id.activity1newUser);
        loginButton1 = findViewById(R.id.activity1login);

        initSaveButton();
        sharedpreferences = getSharedPreferences("SP_NAME", MODE_PRIVATE);

        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterLoginInfo.class);
                startActivity(intent);
            }
        });





    }


    private void initSaveButton () {
        Button save = findViewById(R.id.savebutton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username1.getText().toString();
                password = password1.getText().toString();
                fullName = fullnameedittext.getText().toString();
                SharedPreferences.Editor editor  = sharedpreferences.edit();
                editor.putString("USERNAME", username);
                editor.putString("PASSWORD", password);
                editor.putString("NAME", fullName);

                editor.apply();

                setDefault("USERNAME", username, getApplicationContext());
                setDefault("PASSWORD", password, getApplicationContext());
                setDefault("NAME", fullName, getApplicationContext());
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        Intent i = getIntent();
        loggedin = i.getStringExtra("loggedin");
        if (loggedin == null){
            return;
        }
        else {
            if (loggedin.matches("T")) {
                username1.setText(sharedpreferences.getString("USERNAME", "User Not Found"));
                password1.setText(sharedpreferences.getString("PASSWORD", ""));
                fullnameedittext.setText(sharedpreferences.getString("NAME", ""));
                loggedin = "F";
            }
        }

    }


    public static void setDefault(String key, String value, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDefault (String key, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

}