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

    //sm
    String stopData;
    String busData;
    String busArrive;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rservation);

        doReservation = (Button)findViewById(R.id.btnReservation);

        //sm
        TextView txtBusStop = (TextView)findViewById(R.id.txtBusStop);
        TextView txtBusNum = (TextView)findViewById(R.id.txtBus);
        TextView txtBusArrive = (TextView)findViewById(R.id.txtBusArrive);
        Button btnReservation = (Button)findViewById(R.id.btnReservation);

        //예약에 필요한 데이터를 intent로 받음
        Intent intent = getIntent();
        stopData = intent.getStringExtra("stopname");
        busData = intent.getStringExtra("busnum");

        //임의의 도착 예정지
        busArrive = "이태원역";
        
        //예약할 정보들을 화면에 띄움
        txtBusStop.setText(stopData);
        txtBusNum.setText(busData);
        txtBusArrive.setText(busArrive);

        //예약 버튼 클릭 시
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//actibity_reservation_form의 컴포넌트
                TextView txtBus = (TextView) findViewById(R.id.txtBus);
                TextView txtDepart = (TextView) findViewById(R.id.txtDepart);
                TextView txtArrive = (TextView) findViewById(R.id.txtArrive);

                //최종 예약 정보를 화면에 보여줌
                txtBus.setText(busData);
                txtDepart.setText(stopData);
                txtArrive.setText(busArrive);*/

                Intent intent = new Intent(ReservationActivity.this, MyPageActivity.class);
                intent.putExtra("bus",busData);
                intent.putExtra("depart",stopData);
                intent.putExtra("arrive",busArrive);
                startActivity(intent);
                finish();

            }
        });


    }
}
