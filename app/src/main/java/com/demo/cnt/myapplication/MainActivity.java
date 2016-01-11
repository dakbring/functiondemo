package com.demo.cnt.myapplication;

import com.demo.cnt.myapplication.base.BaseActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.list_activity)
    RecyclerView vListView;

    @Bind(R.id.toolbar)
    Toolbar vToolbar;

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
    }

    private void initToolbar(){
        setSupportActionBar(vToolbar);
    }
}
