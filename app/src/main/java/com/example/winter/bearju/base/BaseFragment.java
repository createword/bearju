package com.example.winter.bearju.base;


import java.util.List;

import com.example.winter.bearju.MainActivity;
import com.example.winter.bearju.R;
import com.example.winter.bearju.custom.LoadingPage;
import com.example.winter.bearju.utils.ViewParentUtils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class BaseFragment extends Fragment {

    private LoadingPage loadingPage;
    private View RootView;
    public FrameLayout contentFrame;
    public MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            mActivity = (MainActivity) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (loadingPage == null) {
            loadingPage = new LoadingPage(getActivity()) {

                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                protected LoadResult load() {
                    return BaseFragment.this.load();
                }
            };
        } else {
            ViewParentUtils.removeParent(loadingPage);
        }

        return loadingPage;
    }

    public abstract View createSuccessView();

    protected abstract LoadingPage.LoadResult load();

    public void show() {
        if (loadingPage != null) {
            loadingPage.show();
        }
    }


    public LoadingPage.LoadResult checkData(List datas) {

        if (datas == null) {
            return LoadingPage.LoadResult.error;
        } else {
            if (datas.size() == 0) {
                return LoadingPage.LoadResult.empty;
            } else {
                return LoadingPage.LoadResult.success;
            }
        }

    }


}
