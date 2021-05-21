package com.inhatc.anywhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Minjae
        // Button components
        Button goLogin = (Button)findViewById(R.id.btnGoLogin);
        Button goRegister = (Button)findViewById(R.id.btnGoRegister);

        // Minjae
        // 'Login' 버튼 클릭 시 로그인 화면으로 이동
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // Minjae
        // 'Register' 버튼 클릭 시 로그인 화면으로 이동
        goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}