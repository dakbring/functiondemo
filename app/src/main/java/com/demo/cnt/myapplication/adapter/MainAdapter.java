package com.demo.cnt.myapplication.adapter;

import com.demo.cnt.myapplication.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

  private Class[] mDataSet;

  public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView vText;

    public ViewHolder(View v) {
      super(v);
      vText = (TextView) v.findViewById(R.id.holder_text);
    }
  }

  public MainAdapter(Class[] dataSet) {
    mDataSet = dataSet;
  }

  @Override
  public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.holder_main_list, parent, false);
    ViewHolder viewHolder = new ViewHolder(v);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.vText.setText(mDataSet[position].toString());
  }

  @Override
  public int getItemCount() {
    return mDataSet.length;
  }
}
