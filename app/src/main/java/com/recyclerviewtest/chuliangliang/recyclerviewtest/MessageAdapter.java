package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chuliangliang on 2017/5/26.
 */

public class MessageAdapter extends RecyclerView.Adapter <MessageAdapter.MsgViewHolder>{
    private List<MessageModel> mMsgList;

    static  class MsgViewHolder extends RecyclerView.ViewHolder
    {
        public TextView leftTextView;
        public LinearLayout leftLayout;

        public TextView rightTextView;
        public LinearLayout rightLayout;

        public View containerView;
        public  MsgViewHolder(View view)
        {
            super(view);
            this.containerView = view;

            this.leftLayout = (LinearLayout)view.findViewById(R.id.chat_layout_left);
            this.leftTextView = (TextView)view.findViewById(R.id.chat_left_msg);

            this.rightTextView = (TextView)view.findViewById(R.id.chat_right_msg);
            this.rightLayout = (LinearLayout)view.findViewById(R.id.chat_layout_right);
        }
    }

    public MessageAdapter(List<MessageModel> msgList)
    {
        this.mMsgList = msgList;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_chat,parent,false);
        return new MsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        //控件赋值
        MessageModel messageModel = mMsgList.get(position);
        if (messageModel.getType() == MessageModel.MSG_TYPE_RECEIVED)
        {
            //接收到的消息
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftTextView.setText(messageModel.getContentText());

        }else if (messageModel.getType() == MessageModel.MSG_TYPE_SEND)
        {
            //自己发送的消息
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(messageModel.getContentText());
        }
    }

    @Override
    public int getItemCount() {
        //信息个数
        return mMsgList.size();
    }
}
