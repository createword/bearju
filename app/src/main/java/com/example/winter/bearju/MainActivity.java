package com.example.winter.bearju;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.utils.FragmentFactoy;
import com.example.winter.bearju.utils.UiUtils;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerTabStrip pagerTabStrip;
    private String[] array;
    private Toolbar mToolBar;
private   TabLayout tabLayout;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        initView();
    }

    public void initView() {
        array = UiUtils.getStringArray(R.array.strArray);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout  = (TabLayout) findViewById(R.id.tably);

        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                super.onPageSelected(position);
                BaseFragment bf = (BaseFragment) FragmentFactoy.createFragment(position);
                bf.show();
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return array.length;
        }

        @Override
        public Fragment getItem(int position) {
            // TODO Auto-generated method stub
            return FragmentFactoy.createFragment(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return array[position];
        }
    }
}
