package com.example.winter.bearju;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.winter.bearju.base.BaseFragment;
import com.example.winter.bearju.utils.FragmentFactoy;
import com.example.winter.bearju.utils.UiUtils;

import javax.crypto.Mac;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerTabStrip pagerTabStrip;
    private String[] array;
    private Toolbar mToolBar;
     private TabLayout tabLayout;
    public FloatingActionButton floatingActionButton;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

// Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Label One", R.mipmap.ic_launcher, Color.parseColor("#455C65"));
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Label Two", R.mipmap.ic_launcher, Color.parseColor("#00886A"));
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Label Three",R.mipmap.ic_launcher, Color.parseColor("#8B6B62"));

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);
        bottomNavigation.setAHBottomNavigationListener(new AHBottomNavigation.AHBottomNavigationListener() {
            @Override
            public void onTabSelected(int position) {
                Toast.makeText(MainActivity.this,position+"--",Toast.LENGTH_LONG).show();
                /*switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this,position+"--",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,position+"--",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,position+"--",Toast.LENGTH_LONG).show();
                        break;
                }*/
            }
        });
        initView();
    }
    public void initView() {



        array = UiUtils.getStringArray(R.array.strArray);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        tabLayout  = (TabLayout) findViewById(R.id.id_tab);
      //  floatingActionButton  = (FloatingActionButton) findViewById(R.id.fab);
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
