package com.inhatc.anywhere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ArrayList<SampleData> movieDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultlist);

        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.lstSearchResult);
        final MyAdapter myAdapter = new MyAdapter(this, movieDataList);

        listView.setAdapter(myAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
//                Toast.makeText(getApplicationContext(),
//                        myAdapter.getItem(position).getBusNumber(),
//                        Toast.LENGTH_LONG).show();

                // Minjae
                // 온클릭 시 일단 예약 레이아웃으로 넘어가게 설정
                startActivity(new Intent(ResultActivity.this, ReservationActivity.class));
                finish();
            }
        });
    }

    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData("9200","인천 광역버스"));
        movieDataList.add(new SampleData("641","간선버스"));
        movieDataList.add(new SampleData("6411","지선버스"));
    }
}
