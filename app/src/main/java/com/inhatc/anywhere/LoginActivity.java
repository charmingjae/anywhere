package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnDoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Minjae
        // Button components
        btnDoLogin = (Button)findViewById(R.id.btnDoLogin);

        // Minjae
        // Button OnClickListener
        btnDoLogin.setOnClickListener(this);
    }

    // Login Method
    private void userLogin(){
        finish();
        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
    }

    // Minjae
    // Onclick Method
    @Override
    public void onClick(View view){
        if(view == btnDoLogin){
            userLogin();
        }
    }
}
