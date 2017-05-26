package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chuliangliang on 2017/5/25.
 */

public class DataModelAdapter02 extends RecyclerView.Adapter<DataModelAdapter02.ViewHolder_style2> {
    private List<DataModel> mDataArray2;

    static class ViewHolder_style2 extends RecyclerView.ViewHolder
    {
        View containnerView;
        ImageView imageView;
        TextView textView;


        public ViewHolder_style2(View view)
        {
            super(view);
            containnerView = view;
            textView = (TextView) view.findViewById(R.id.rec_style2_text);
            imageView = (ImageView) view.findViewById(R.id.rec_style2_img);
        }
    }

    public DataModelAdapter02(List<DataModel> dataList)
    {
        mDataArray2 = dataList;
    }

    @Override
    public DataModelAdapter02.ViewHolder_style2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_item_style2,parent,false);
        final DataModelAdapter02.ViewHolder_style2 vHolder = new DataModelAdapter02.ViewHolder_style2(view);

        //整个子选项添加点击事件
        vHolder.containnerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vHolder.getAdapterPosition();
                DataModel dataModel = mDataArray2.get(position);
                Toast.makeText(v.getContext(), "点击子选项了-点击的内容为"+dataModel.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //为子选项的图片控件添加点击事件
        vHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vHolder.getAdapterPosition();
                DataModel dataModel = mDataArray2.get(position);
                Toast.makeText(v.getContext(), "点击图片了-点击的内容为"+dataModel.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(DataModelAdapter02.ViewHolder_style2 holder, int position) {
        DataModel dataModel = mDataArray2.get(position);
        holder.imageView.setImageResource(dataModel.getPid());
        holder.textView.setText(dataModel.getText());
    }

    @Override
    public int getItemCount() {
        return mDataArray2.size();
    }
}
