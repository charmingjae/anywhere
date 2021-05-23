package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_ride_form);
        mAuth = FirebaseAuth.getInstance();

        rideStatusChange();
    }

    private void rideStatusChange() {
        phone = mAuth.getCurrentUser().getEmail();
        phone = phone.substring(0, 11);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("res").orderByChild("phone").equalTo(phone);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        Query query_status = issue.getRef().child("status").equalTo("out");
                        query_status.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    Intent intent = new Intent(MyPageRideActivity.this, ReviewActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }//myAdapter.notifyDataSetChanged();

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}