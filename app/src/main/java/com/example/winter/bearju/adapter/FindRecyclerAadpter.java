package com.example.winter.bearju.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winter.bearju.MainActivity;
import com.example.winter.bearju.R;
import com.example.winter.bearju.utils.UiUtils;

import java.util.ArrayList;


public class FindRecyclerAadpter extends BaseAdapter {
    private ArrayList<Integer> list;
    private int[] imageId;
    private LayoutInflater mInflater;

    public FindRecyclerAadpter(int[] imageId, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.imageId = imageId;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.find_frag_item, null);


            holder.img = (ImageView) convertView.findViewById(R.id.findImage);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.img.setImageDrawable(UiUtils.getContext().getResources().getDrawable(imageId[position]));


        return convertView;
    }

    public final class ViewHolder {

        public ImageView img;


    }

}