package com.example.dungnv.android7pomodoro.activities;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dungnv.android7pomodoro.R;

public class LoginActivity extends AppCompatActivity {

   private EditText etPassword;
    private EditText etUsername;
   private Button btlogin;
   private Button btregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword=( EditText) this.findViewById(R.id.et_password);
        etUsername=(EditText)this.findViewById(R.id.et_username);
        btlogin=(Button) this.findViewById(R.id.bt_login);
        btregister=(Button)this.findViewById(R.id.bt_register);

        
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemtLogin();
            }
        });
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemtRegister();

            }
        });
    }
    private void attemtLogin(){
        String Username= etUsername.getText().toString();
        String Password=etPassword.getText().toString();
        if(Username.equals("admin")&& Password.equals("admin"))
        {
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        
    }
    private void attemtRegister(){
        String Username=etUsername.getText().toString();
        String Password=etPassword.getText().toString();
        if(Username.equals("admin")){
            Toast.makeText(this, "Register failed", Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this, "Register success", Toast.LENGTH_SHORT).show();
    }
}
