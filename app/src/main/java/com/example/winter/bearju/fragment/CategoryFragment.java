package com.example.winter.bearju.fragment;

import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.custom.LoadingPage;
import android.view.View;
import android.widget.TextView;
public class CategoryFragment extends BaseFragment {


    @Override
    public View createSuccessView() {
        TextView view = new TextView(getActivity());
        view.setText("����CategoryFragment");
        return view;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.empty;
    }


}
