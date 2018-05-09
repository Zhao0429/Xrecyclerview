package com.example.administrator.myapplication.model;

import com.example.administrator.myapplication.http.GoodsListener;

import java.util.Map;

public interface IModel {
    void getDate(String url, Map<String,String> map, GoodsListener goodsListener);
}
