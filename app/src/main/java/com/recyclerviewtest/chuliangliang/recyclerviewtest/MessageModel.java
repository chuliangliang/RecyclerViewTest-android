package com.recyclerviewtest.chuliangliang.recyclerviewtest;

/**
 * Created by chuliangliang on 2017/5/26.
 */

public class MessageModel {
    public static final int MSG_TYPE_RECEIVED = 0;
    public static  final int MSG_TYPE_SEND = 1;

    private int type;
    private String contentText;

    public MessageModel(String text,int type)
    {
        this.contentText = text;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContentText() {
        return contentText;
    }
}
