package com.recyclerviewtest.chuliangliang.recyclerviewtest;

/**
 * Created by chuliangliang on 2017/5/25.
 */

public class DataModel {
    private int pid;
    private String text;
    public DataModel(String str, int imgId)
    {
        this.pid = imgId;
        this.text = str;
    }

    public int getPid() {
        return pid;
    }

    public String getText() {
        return text;
    }
}
