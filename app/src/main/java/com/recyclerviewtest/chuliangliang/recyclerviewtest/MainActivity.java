package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button vButton = (Button)findViewById(R.id.button_1);
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerActivity.StartRecyclerActivity(MainActivity.this,RecyclerActivity.REC_VERTICAL);
            }
        });


        Button hButton = (Button)findViewById(R.id.button_2);
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerActivity.StartRecyclerActivity(MainActivity.this,RecyclerActivity.REC_HORIZONTAL);
            }
        });

        Button sButton = (Button)findViewById(R.id.button_3);
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StaggeredActivity.class);
                startActivity(intent);
            }
        });

        Button chatButton = (Button)findViewById(R.id.button_4);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UsersChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
