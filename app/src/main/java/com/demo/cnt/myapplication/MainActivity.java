package com.demo.cnt.myapplication;

import com.demo.cnt.myapplication.adapter.MainAdapter;
import com.demo.cnt.myapplication.base.BaseActivity;
import com.demo.cnt.myapplication.image.HandleImageActivity;
import com.demo.cnt.myapplication.map.GoogleMapActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.list_activity)
    RecyclerView vListView;

    @Bind(R.id.toolbar)
    Toolbar vToolbar;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Class[] mListDemo = {
        HandleImageActivity.class,
        GoogleMapActivity.class
    };

    @Override
    protected boolean didYouRememberToAddClassToInjectionList() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();
        initListFunction();
    }

    private void initToolbar(){
        setSupportActionBar(vToolbar);
    }

    private void initListFunction(){
        mAdapter = new MainAdapter(mListDemo);
        mLayoutManager = new LinearLayoutManager(this);
        vListView.setLayoutManager(mLayoutManager);
        vListView.setAdapter(mAdapter);
    }
}
