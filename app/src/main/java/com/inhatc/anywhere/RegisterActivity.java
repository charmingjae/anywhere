package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class RegisterActivity extends AppCompatActivity {
    // Hwi
    // declare_ref
    private Button DoRegister;


    // Hwi
    // initialize DB
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Hwi
        // Button components
        DoRegister = (Button) findViewById(R.id.btnDoRegister);

        // Hwi
        // User components
        final EditText name = (EditText) findViewById(R.id.edtUserName);
        final EditText phone = (EditText) findViewById(R.id.edtUserPhone);
        final EditText birth = (EditText) findViewById(R.id.edtUserBirth);

        // Hwi
        // 'Register' 버튼 클릭 시 로그인 화면으로 이동
        // "관리자 승인 후 알려드릴게요" 토스트 메세지 띄움
        DoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name= name.getText().toString();
                String get_phone= phone.getText().toString();
                String get_birth= birth.getText().toString();
                Toast.makeText(RegisterActivity.this, "I'll let you know after the administrator approves it.",
                        Toast.LENGTH_SHORT).show();
                //Send UserData to DB
                HashMap result = new HashMap<>();
                result.put("name", get_name);
                result.put("phone", get_phone);
                result.put("birth", get_birth);

                //firebase 정의
                mDatabase = FirebaseDatabase.getInstance().getReference();
                //firebase에 저장
                mDatabase.child("user").push().setValue(result);
                // [END single_value_read]

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }







    }





