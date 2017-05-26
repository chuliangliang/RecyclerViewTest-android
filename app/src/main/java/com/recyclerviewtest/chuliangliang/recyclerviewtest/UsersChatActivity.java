package com.recyclerviewtest.chuliangliang.recyclerviewtest;

import android.content.pm.ProviderInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class UsersChatActivity extends AppCompatActivity {

    private  List<MessageModel>msgArray = new ArrayList<MessageModel>();
    private EditText        inputView;
    private Button          sendButton;
    private RecyclerView    msgRecyclerView;
    private MessageAdapter  mAdapter;

    private void loadSubViews()
    {
        this.inputView = (EditText) findViewById(R.id.editView_input);
        this.sendButton = (Button) findViewById(R.id.button_Send);
        this.msgRecyclerView = (RecyclerView) findViewById(R.id.chat_recyclerView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_chat);
        this.loadSubViews();
        this.initMessageData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.msgRecyclerView.setLayoutManager(linearLayoutManager);

        this.mAdapter = new MessageAdapter(this.msgArray);
        this.msgRecyclerView.setAdapter(this.mAdapter);
    }

    private void initMessageData()
    {

        MessageModel messageModel1 = new MessageModel("亮哥你好",MessageModel.MSG_TYPE_RECEIVED);
        this.msgArray.add(messageModel1);

        MessageModel messageModel2 = new MessageModel("同学你好",MessageModel.MSG_TYPE_SEND);
        this.msgArray.add(messageModel2);

        MessageModel messageModel3 = new MessageModel("hhdhhashdhsdhdhdh dd",MessageModel.MSG_TYPE_RECEIVED);
        this.msgArray.add(messageModel3);

        this.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = inputView.getText().toString();
                if (!inputText.equals(""))
                {
                    MessageModel msg = new MessageModel(inputText,MessageModel.MSG_TYPE_SEND);
                    msgArray.add(msg);
                    //通知适配器 想数组中插入数据了
                    mAdapter.notifyItemInserted(msgArray.size()-1);
                    //滑动视图滚动到新添加的消息位置
                    msgRecyclerView.scrollToPosition(msgArray.size()-1);
                    //清空输入框
                    inputView.setText("");
                }
            }
        });
    }

}
