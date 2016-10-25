


package com.example.winter.bearju.adapter;

import android.content.Context;
import android.renderscript.Sampler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.winter.bearju.R;
import com.example.winter.bearju.library.RecyclerViewUtils;

import java.util.ArrayList;

public class mRecyclerAadpter extends RecyclerView.Adapter<mRecyclerAadpter.MyViewHolder> implements View.OnClickListener {
    private RecyclerView mRecyclerview;
    MyViewHolder myViewHolder;
    private Context mContext;
    private ArrayList<String> mList;
    private OnChildClickListener listener;
   /* private RecyclerView mRecyclerview;*/

    public mRecyclerAadpter(Context mContext, ArrayList<String> mList, RecyclerView mRecyclerView) {
        this.mContext = mContext;
        this.mList = mList;
        this.mRecyclerview = mRecyclerView;
    }

    public void setOnListener(OnChildClickListener listener) {
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mveiw = LayoutInflater.from(mContext).inflate(R.layout.app_frag_item, parent, false);
        myViewHolder = new MyViewHolder(mveiw);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder mholder, int position) {
        mholder.text.setText(mList.get(position));
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (mRecyclerview != null && listener != null) {
            int position = mRecyclerview.getChildLayoutPosition(v)-1;
            listener.onChildClick(mRecyclerview, v, position, mList.get(position));
        }
    }

    public void remove(int position) {
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(mRecyclerAadpter.this);
            text = (TextView) itemView.findViewById(R.id.info_text);

        }
    }

    public interface OnChildClickListener {
        void onChildClick(RecyclerView parent, View view, int position, String data);
    }
}