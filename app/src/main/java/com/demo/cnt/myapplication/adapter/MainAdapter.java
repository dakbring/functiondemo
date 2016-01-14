package com.demo.cnt.myapplication.adapter;

import com.demo.cnt.myapplication.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

  private Class[] mDataSet;
  private ListFunctionListener mListFunctionListener;

  public static class ViewHolder extends RecyclerView.ViewHolder {

    public TextView vText;

    public ViewHolder(View v) {
      super(v);
      vText = (TextView) v.findViewById(R.id.holder_text);
    }
  }

  public MainAdapter(Class[] dataSet, ListFunctionListener listFunctionListener) {
    mDataSet = dataSet;
    mListFunctionListener = listFunctionListener;
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
    final Class selected = mDataSet[position];
    holder.vText.setText(selected.getSimpleName());
    holder.vText.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mListFunctionListener.onItemSelected(selected);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mDataSet.length;
  }

  public interface ListFunctionListener {
    void onItemSelected(Class position);
  }
}
