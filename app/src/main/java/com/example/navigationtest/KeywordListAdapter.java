package com.example.navigationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationtest.db.Keyword;

import java.util.List;
/*********************************************************************************
 * KeywordListAdapter
 *
 * Description:
 * This class acts as an adapter between the database and the display
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell
 * Date: November 24 2020
 *
 * Input: none
 * Output: none
 *
 ********************************************************************************/
public class KeywordListAdapter extends RecyclerView.Adapter<KeywordListAdapter.MyViewHolder> {

    private Context context;
    private List<Keyword> keywordList;
    public KeywordListAdapter(Context context) {
        this.context = context;
    }

    public void setKeywordList(List<Keyword> userList) {
        this.keywordList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public com.example.navigationtest.KeywordListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.navigationtest.KeywordListAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(this.keywordList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return  this.keywordList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvLastName;

        public MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);

        }
    }
}