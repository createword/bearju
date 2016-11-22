package com.example.winter.bearju.fragment;

import com.example.winter.bearju.R;
import com.example.winter.bearju.adapter.FindRecyclerAadpter;
import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.custom.LoadingPage;
import com.example.winter.bearju.utils.UiUtils;
import android.view.View;
import android.widget.ListView;
public class FindFragment extends BaseFragment {
    private ListView listView;
    private FindRecyclerAadpter findRecyclerAadpter;
    private int[] imagId;
    @Override
    public View createSuccessView() {
        View mView = View.inflate(UiUtils.getContext(), R.layout.find_fragment, null);

        listView = (ListView) mView.findViewById(R.id.list);
        imagId=new int[]{R.mipmap.fourpic,R.mipmap.threepic,R.mipmap.fivepic,R.mipmap.threepic};
        listView.setAdapter(new FindRecyclerAadpter(imagId,mActivity));
        return mView;
    }

    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.success;
    }
}
