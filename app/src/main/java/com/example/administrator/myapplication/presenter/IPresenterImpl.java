package com.example.administrator.myapplication.presenter;

import com.example.administrator.myapplication.http.GoodsListener;
import com.example.administrator.myapplication.http.Httpfig;
import com.example.administrator.myapplication.model.GoodsBean;
import com.example.administrator.myapplication.model.IModel;
import com.example.administrator.myapplication.view.IMainView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPresenterImpl implements IPresenter{
    @Override
    public void getGoods(IModel iModel, final IMainView iMainView) {
        Map<String,String> map=new HashMap<>();
        map.put("pscid", iMainView.pscid()+"");
        iModel.getDate(Httpfig.goods_url, map, new GoodsListener() {
            @Override
            public void GoodsSuccess(String json) {
                Gson gson=new Gson();
                GoodsBean goodsBean = gson.fromJson(json, GoodsBean.class);
                List<GoodsBean.DataBean> data = goodsBean.getData();
                iMainView.ShowGoods(data);
            }

            @Override
            public void GoodsError(String error) {

            }
        });
    }
}
