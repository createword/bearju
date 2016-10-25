package com.example.winter.bearju.fragment;

import com.example.winter.bearju.R;
import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.custom.LoadingPage;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class GameFragment extends BaseFragment {

    @Override
    public View createSuccessView() {
        View mView= LayoutInflater.from(mActivity).inflate(R.layout.app_fragment,null);
        return mView;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }


}
