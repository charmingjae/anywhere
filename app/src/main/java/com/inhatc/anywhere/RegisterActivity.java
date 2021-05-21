package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    // Hwi
    // User components
    EditText name = (EditText) findViewById(R.id.edtUserName);
    EditText phone = (EditText) findViewById(R.id.edtUserPhone);
    EditText birth = (EditText) findViewById(R.id.edtUserBirth);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DatabaseReference mDatabase;
        //Hwi
        // Button components
        Button DoRegister = (Button) findViewById(R.id.btnDoRegister);

        // Hwi
        // 'Register' 버튼 클릭 시 로그인 화면으로 이동
        // "관리자 승인 후 알려드릴게요" 토스트 메세지 띄움
        DoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "I'll let you know after the administrator approves it.",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    // Hwi
    // DB에 회원정보 전송
    private void SendUserData(String Uname, String Uphone, String Ubirth) {
    // Send User Data to DB
    String key = mDatabase.child("user").push().getKey();
    PostModel post = new PostModel(Uname, Uphone, Ubirth);
    Map<String, Object> postValues = post.toMap();

    Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/posts/" + key, postValues);
            childUpdates.put("/user-posts/" + Uname + "/" + key, postValues);

            mDatabase.updateChildren(childUpdates);



    }
}
