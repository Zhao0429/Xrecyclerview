package com.example.administrator.myapplication.view;

import com.example.administrator.myapplication.model.GoodsBean;

import java.util.List;

public interface IMainView {
    void ShowGoods(List<GoodsBean.DataBean> list);

    int pscid();
}
