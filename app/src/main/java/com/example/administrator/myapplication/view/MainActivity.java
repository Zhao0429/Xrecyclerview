package com.example.administrator.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.model.GoodsBean;
import com.example.administrator.myapplication.model.IModelImpl;
import com.example.administrator.myapplication.model.MyAdapter;
import com.example.administrator.myapplication.presenter.IPresenterImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private XRecyclerView recy;
    private static final String TAG = "MainActivity";
    int pscid = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initView();

    }

    private void initDate() {
        IPresenterImpl iPresenter = new IPresenterImpl();
        iPresenter.getGoods(new IModelImpl(), this);
    }

    private void initView() {
        recy = findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                IPresenterImpl iPresenter = new IPresenterImpl();
                iPresenter.getGoods(new IModelImpl(), MainActivity.this);
                recy.refreshComplete();
            }
        });
    }

    @Override
    public void ShowGoods(List<GoodsBean.DataBean> list) {
        Log.d(TAG, "ShowGoods: +++++++++++++++++++++++++++++++++++++++++++++" + list.size());
        MyAdapter myAdapter = new MyAdapter(this, list);
        recy.setAdapter(myAdapter);
    }

    @Override
    public int pscid() {
        return pscid++;
    }
}
