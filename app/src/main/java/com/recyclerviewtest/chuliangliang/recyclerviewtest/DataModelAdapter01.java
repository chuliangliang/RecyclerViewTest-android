package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/** Created by chuliangliang on 2017/5/25.
 *
 */

public class DataModelAdapter01 extends RecyclerView.Adapter<DataModelAdapter01.ViewHolder_style1> {
    private List<DataModel> mDataArray;

   static class ViewHolder_style1 extends RecyclerView.ViewHolder
   {
       ImageView imageView;
       TextView textView;

       public ViewHolder_style1(View view)
       {
           super(view);
           textView = (TextView) view.findViewById(R.id.rec_style1_text);
           imageView = (ImageView) view.findViewById(R.id.rec_style1_img);
       }
   }

   public DataModelAdapter01(List<DataModel> dataList)
   {
       mDataArray = dataList;
   }

    @Override
    public ViewHolder_style1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_style1,parent,false);
        ViewHolder_style1 vHolder = new ViewHolder_style1(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder_style1 holder, int position) {
        DataModel dataModel = mDataArray.get(position);
        holder.imageView.setImageResource(dataModel.getPid());
        holder.textView.setText(dataModel.getText());
    }

    @Override
    public int getItemCount() {
        return mDataArray.size();
    }
}
