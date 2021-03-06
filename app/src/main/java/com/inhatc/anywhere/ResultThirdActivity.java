package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ResultThirdActivity extends AppCompatActivity {

    ArrayList<SampleData> busDataList;
    ArrayList<SampleData> lists;
    private SearchView editSearch;        // 검색어를 입력할 Input 창
    MyAdapter myAdapter;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultlist_third);

        // 넘겨온 버스 번호 가져오기
        Intent intent = getIntent();
        String busNum = intent.getStringExtra("busnum");
        String stopName = intent.getStringExtra("stopname");
        Log.i("BUS NUM : ", busNum);

        this.StopList();

        Log.i("list size : ", String.valueOf(lists.size()));



        ListView listView = (ListView)findViewById(R.id.lstSearchResult_third);
        myAdapter = new MyAdapter(this, lists);

        listView.setAdapter(myAdapter);

//        myAdapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getBusNumber(),
                        Toast.LENGTH_LONG).show();

                // Minjae
                // 온클릭 시 일단 예약 레이아웃으로 넘어가게 설정
                Intent intent = new Intent(ResultThirdActivity.this, ReservationActivity.class);
                intent.putExtra("busnum", busNum);
                intent.putExtra("stopname", stopName);
                intent.putExtra("dropoff", myAdapter.getItem(position).getBusNumber());
                startActivity(intent);
                finish();
            }
        });



        // input창에 검색어를 입력시 "setOnQueryTextListener" 이벤트 리스너를 정의한다.
//        editSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String text) {
//                // input창에 문자를 입력할때마다 호출된다.
//                // search 메소드를 호출한다.
////                search(text);
//                return false;
//            }
//        });


    }

    /*
    @Override
    public void onStart() {
        super.onStart();

    }
    */


//    // 검색을 수행하는 메소드
//    public void search(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        busDataList.clear();
//        if (charText.length() == 0) {
//            busDataList.addAll(list);
//        } else {
//            for (int i = 0;i < list.size(); i++) {
//                if (list.get(i).getBusNumber().toLowerCase().contains(charText)) {
//                    busDataList.add(list.get(i));
//                }
//            }
//        }
//        myAdapter.notifyDataSetChanged();
//    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    public void StopList(){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("stop");
        lists = new ArrayList<SampleData>();
//        lists.add(new SampleData("dddd",""));
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){


                        String name = issue.child("name").getValue().toString();

                        Log.w("THIRD RETURN VALUE NAME : ", name);

                        lists.add(new SampleData(name,""));

                    }
                }myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void BusList(){
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.child("bus").getChildren()) {
                    Log.d("ResultActivity", "Single ValueEventListener : " + snapshot.child("name").getValue());
                    lists.add(new SampleData(snapshot.child("num").getValue().toString(),snapshot.child("type").getValue().toString()));
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
