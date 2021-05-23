package com.inhatc.anywhere;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyPageActivity extends AppCompatActivity {

    Button doCancel;

    Dialog cancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);


        doCancel = (Button)findViewById(R.id.btnCancelResv);

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


        // Minjae
        // dialog

        cancelDialog = new Dialog(MyPageActivity.this);
        cancelDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        cancelDialog.setContentView(R.layout.activity_dialog_cancel);

        // 예약 취소 버튼 누를 시
        doCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showDialog();
            }
        });

    }

    //sm
    //dialog를 띄어주는 함수
    public void showDialog(){
        cancelDialog.show();

        // 아니오 버튼
        Button noBtn = cancelDialog.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다이얼로그 닫기
                cancelDialog.dismiss();
            }
        });
        // 네 버튼
        cancelDialog.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelDialog.dismiss();
                finish();
            }
        });
    }
}
