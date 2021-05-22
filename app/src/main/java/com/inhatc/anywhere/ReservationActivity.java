package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationActivity extends AppCompatActivity {

    Button doReservation = (Button)findViewById(R.id.btnReservation);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rservation);

        //jh
        Intent intent = new Intent(this, MyPageActivity.class); // 인텐트를 생성
        intent.putExtra("bus", "400");   // Intent에 이메일 주소 넣기
        intent.putExtra("depart", "Seoul");
        intent.putExtra("arrive", "Seoul");
        startActivity(intent);





    }
}
