package com.example.winter.bearju.fragment;

import com.example.winter.bearju.R;
import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.custom.LoadingPage;
import com.example.winter.bearju.utils.UiUtils;

import android.view.View;

public class AppFragment extends BaseFragment {

    @Override
    public View createSuccessView() {
        View mView = View.inflate(UiUtils.getContext(), R.layout.app_fragment, null);
        return mView;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }


}
