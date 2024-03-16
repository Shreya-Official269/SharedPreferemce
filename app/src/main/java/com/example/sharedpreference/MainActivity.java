package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sharedpreferemce.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Intent newLogin;
                Intent afterLogin;
                newLogin = new Intent(MainActivity.this, LoginActivity.class);
                afterLogin = new Intent(MainActivity.this, HomeActivity.class);


                if (pref.contains("saved_name") && pref.contains("saved_password")) {
                    startActivity(afterLogin);
                }else {
                    startActivity(newLogin);
                }
                finish();
            }
        },4000);
    }
}