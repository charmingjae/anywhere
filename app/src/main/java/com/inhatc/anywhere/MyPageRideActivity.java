package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyPageRideActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String phone;

    TextView txtBus;
    TextView txtDepart;
    TextView txtArrive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_ride_form);
        mAuth = FirebaseAuth.getInstance();

        txtBus = (TextView)findViewById(R.id.txtBus);
        txtDepart = (TextView)findViewById(R.id.txtDepart);
        txtArrive = (TextView)findViewById(R.id.txtArrive);

        String busnum = getIntent().getStringExtra("busnum");
        String depart = getIntent().getStringExtra("depart");
        String arrive = getIntent().getStringExtra("arrive");

        Log.i("Get Extras : ", busnum);
        Log.i("Get Extras : ", depart);
        Log.i("Get Extras : ", arrive);

        txtBus.setText(busnum);
        txtDepart.setText(depart);
        txtArrive.setText(arrive);

        rideStatusChange();
    }

    private void rideStatusChange() {
        phone = mAuth.getCurrentUser().getEmail();
        phone = phone.substring(0, 11);
        Log.i("RIDE NOW PHONE : ", phone);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Log.d("","start log");
        Query query = reference.child("res").orderByChild("phone").equalTo(phone);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot issue : snapshot.getChildren()) {
                    Log.d("","CHANGEDCHANGEDCHANGEDCHANGEDCHANGEDCHANGEDCHANGEDCHANGEDCHANGED");

                    Log.i("keyssssss", issue.child("status").getValue().toString());
                    if(issue.child("status").getValue().toString().equals("out")){
                        Intent intent = new Intent(MyPageRideActivity.this, ReviewActivity.class);
                        startActivity(intent);
                        finish();
                    }
//                    String status = issue.getRef().child("status").toString();
//                    Log.d("",status);
//                    if (status.equals("ride")){
//                        Log.d("","hi hi~");
//                        Intent intent = new Intent(MyPageRideActivity.this, ReviewActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
                    /*
                    Query query_status = issue.getRef().child("status").equalTo("out");
                    query_status.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot issue : snapshot.getChildren()) {
                                Log.d("","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                                Intent intent = new Intent(MyPageRideActivity.this, ReviewActivity.class);
                                startActivity(intent);
                                finish();

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                     */
                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}