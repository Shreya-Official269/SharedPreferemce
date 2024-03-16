package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sharedpreferemce.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtusername,edtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtusername = findViewById(R.id.username);
        edtpassword = findViewById(R.id.password);


        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();



                //code for verification

                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("saved_name",username);
                editor.putString("saved_password",password);
                editor.commit();
                editor.apply();

                Intent loginSuccess = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(loginSuccess);
            }
        });


    }
}