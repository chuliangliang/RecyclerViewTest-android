package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaggeredActivity extends AppCompatActivity {
    private List<DataModel> mDatalist = new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);

        initData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.RecyclerV_2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        DataModelAdapter02 adapter02 = new DataModelAdapter02(mDatalist);
        recyclerView.setAdapter(adapter02);
    }

    public void initData()
    {
        for (int i = 0; i< 4; i ++)
        {
            DataModel dataModel_cm = new DataModel("草莓-"+getRanddomLengthName("jadjljdljd草莓"),R.drawable.cm);
            mDatalist.add(dataModel_cm);

            DataModel dataModel_cz = new DataModel("橙子-"+getRanddomLengthName("hksajdakh橙子"),R.drawable.cz);
            mDatalist.add(dataModel_cz);

            DataModel dataModel_pg = new DataModel("苹果-"+getRanddomLengthName("啊回到拉萨是苹果"),R.drawable.pg);
            mDatalist.add(dataModel_pg);

            DataModel dataModel_pt = new DataModel("葡萄-"+getRanddomLengthName("hdkashdk葡萄"),R.drawable.pt);
            mDatalist.add(dataModel_pt);

            DataModel dataModel_xj = new DataModel("香蕉-"+getRanddomLengthName("1234567876543香蕉"),R.drawable.xj);
            mDatalist.add(dataModel_xj);

            DataModel dataModel_yt = new DataModel("樱桃-"+getRanddomLengthName("qwertdsfdsaf樱桃"),R.drawable.yt);
            mDatalist.add(dataModel_yt);
        }

    }

    private String getRanddomLengthName(String name)
    {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for ( int i = 0; i < length; i ++)
        {
            builder.append(name);
        }
        return builder.toString();
    }
}
