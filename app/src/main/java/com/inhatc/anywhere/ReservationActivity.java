package com.inhatc.anywhere;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;

import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ReservationActivity extends AppCompatActivity {

    Button doReservation;

    //sm
    String stopData;
    String busData;
    String busArrive;
    Dialog checkDialog;


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

        //sm
        //dialog 초기화
        checkDialog = new Dialog(ReservationActivity.this);
        checkDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        checkDialog.setContentView(R.layout.activity_dialog);

        //예약 버튼 클릭 시
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //dialog 띄움
                showDialog();

               /* //원래 작동되는 것
                Intent intent = new Intent(ReservationActivity.this, MyPageActivity.class);
                intent.putExtra("bus",busData);
                intent.putExtra("depart",stopData);
                intent.putExtra("arrive",busArrive);
                startActivity(intent);
                finish();*/

            }
        });


    }

    //sm
    //dialog를 띄어주는 함수
    public void showDialog(){
        checkDialog.show();

        //textView 컴포넌트
        TextView txtFinalBus = (TextView)checkDialog.findViewById(R.id.txtFinalBus);
        TextView txtFinalStop = (TextView)checkDialog.findViewById(R.id.txtFinalStop);
        TextView txtFinalArrive = (TextView)checkDialog.findViewById(R.id.txtFinalArrive);
        
        txtFinalBus.setText(busData);
        txtFinalStop.setText(stopData);
        //임의의 도착값
        txtFinalArrive.setText(busArrive);

        // 아니오 버튼
        Button noBtn = checkDialog.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다이얼로그 닫기
                checkDialog.dismiss();
            }
        });
        // 네 버튼
        checkDialog.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 상세정보로 이동한다.
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
