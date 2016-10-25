package com.example.winter.bearju.fragment;

import com.example.winter.bearju.R;
import com.example.winter.bearju.adapter.mRecyclerAadpter;
import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.custom.LoadingPage;
import com.example.winter.bearju.library.HeaderAndFooterRecyclerViewAdapter;
import com.example.winter.bearju.library.RecyclerViewUtils;
import com.example.winter.bearju.library.SampleFooter;
import com.example.winter.bearju.library.SampleHeader;
import com.example.winter.bearju.utils.UiUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.layout.simple_list_item_1;

public class HomeFragment extends BaseFragment  {
    private RecyclerView mRecyclerView;
    ArrayList<String> listem;
    mRecyclerAadpter mRecyAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();

    }

    @Override
    public View createSuccessView() {
        View mView = View.inflate(UiUtils.getContext(), R.layout.app_fragment, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.mRecyclerView);
        ArrayList<String> listem = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            listem.add(i + "名爵爷");

        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyAdapter=new mRecyclerAadpter(mActivity, listem,mRecyclerView);

        HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(mRecyAdapter);
        mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        mRecyAdapter.setOnListener(new mRecyclerAadpter.OnChildClickListener() {
            @Override
            public void onChildClick(RecyclerView parent, View view, int position, String data) {
                Toast.makeText(mActivity, position+"*--",Toast.LENGTH_LONG).show();
            }
        });
        //add a HeaderView
        RecyclerViewUtils.setHeaderView(mRecyclerView, new SampleHeader(mActivity));
        //add a FooterView
        RecyclerViewUtils.setFooterView(mRecyclerView, new SampleFooter(mActivity));

        return mView;

    }


    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }


}
