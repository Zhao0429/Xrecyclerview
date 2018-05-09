package com.example.administrator.myapplication.model;

import com.example.administrator.myapplication.http.GoodsListener;
import com.example.administrator.myapplication.http.OKHttpUtils;

import java.util.Map;

public class IModelImpl implements IModel{

    @Override
    public void getDate(String url, Map<String, String> map, final GoodsListener goodsListener) {
        OKHttpUtils okHttpUtils=new OKHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOnLoginListener(new OKHttpUtils.LoginListener() {
            @Override
            public void loginSuccess(String json) {
                goodsListener.GoodsSuccess(json);
            }

            @Override
            public void loginError(String error) {
                goodsListener.GoodsError(error);
            }
        });
    }
}
