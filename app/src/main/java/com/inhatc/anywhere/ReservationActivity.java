package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationActivity extends AppCompatActivity {

    Button doReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rservation);

        doReservation = (Button)findViewById(R.id.btnReservation);

        //sm
        TextView txtBusStop = (TextView)findViewById(R.id.txtBusStop);
        TextView txtBusNum = (TextView)findViewById(R.id.txtBusNum);
        TextView txtDropOff = (TextView)findViewById(R.id.txtDropOff);
        Intent intent = getIntent();
        String stopData = intent.getStringExtra("stopname");
        String busData = intent.getStringExtra("busnum");
        String dropoff = intent.getStringExtra("dropoff");
        txtBusStop.setText(stopData);
        txtBusNum.setText(busData);
        txtDropOff.setText(dropoff);
    }
}
