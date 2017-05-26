package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<DataModel> mDatalist = new ArrayList<DataModel>();

    final static int REC_VERTICAL = 200;   //竖直
    final static int REC_HORIZONTAL = 300; //水平

    private int scrollToOrientation = REC_VERTICAL;

    public static void StartRecyclerActivity(Context ctx, int orientation)
    {
        Intent intent = new Intent(ctx,RecyclerActivity.class);
        intent.putExtra("Orientation",orientation);
        ctx.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        this.scrollToOrientation = intent.getIntExtra("Orientation",REC_VERTICAL);
        this.initData();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerV_1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        switch (this.scrollToOrientation){
            case REC_HORIZONTAL:
            {
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            }
            break;
            case REC_VERTICAL:
            {
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            }
            break;
        }
        DataModelAdapter01 adapter = new DataModelAdapter01(mDatalist);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void initData()
    {
        for (int i = 0; i< 2; i ++)
        {
            DataModel dataModel_cm = new DataModel("草莓",R.drawable.cm);
            mDatalist.add(dataModel_cm);

            DataModel dataModel_cz = new DataModel("橙子",R.drawable.cz);
            mDatalist.add(dataModel_cz);

            DataModel dataModel_pg = new DataModel("苹果",R.drawable.pg);
            mDatalist.add(dataModel_pg);

            DataModel dataModel_pt = new DataModel("葡萄",R.drawable.pt);
            mDatalist.add(dataModel_pt);

            DataModel dataModel_xj = new DataModel("香蕉",R.drawable.xj);
            mDatalist.add(dataModel_xj);

            DataModel dataModel_yt = new DataModel("樱桃",R.drawable.yt);
            mDatalist.add(dataModel_yt);
        }

    }
}
