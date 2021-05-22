package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        Intent intent = getIntent();

        //jh
        TextView txtBus = (TextView) findViewById(R.id.txtBus);
        TextView txtDepart = (TextView) findViewById(R.id.txtDepart);
        TextView txtArrive = (TextView) findViewById(R.id.txtArrive);

        //ReservationActivity.java에서 보낸 변수로 바꿔주기
        String bus = intent.getStringExtra("bus");
        String depart = intent.getStringExtra("depart");
        String arrive = intent.getStringExtra("arrive");

        txtBus.setText(bus);
        txtDepart.setText(depart);
        txtArrive.setText(arrive);
    }
}
