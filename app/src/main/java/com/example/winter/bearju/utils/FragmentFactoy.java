package com.example.winter.bearju.utils;

import java.util.HashMap;
import java.util.Map;


import android.support.v4.app.Fragment;

import com.example.winter.bearju.fragment.AppFragment;
import com.example.winter.bearju.fragment.CategoryFragment;
import com.example.winter.bearju.fragment.GameFragment;
import com.example.winter.bearju.fragment.HomeFragment;

public class FragmentFactoy {

    private static Map<Integer, Fragment> mFragments = new HashMap<Integer, Fragment>();

    public static Fragment createFragment(int position) {
        Fragment fragment = null;
        fragment = mFragments.get(position);
        if (fragment == null) {
            if (position == 0) {
                fragment = new HomeFragment();
            } else if (position == 1) {
                fragment = new AppFragment();
            } else if (position == 2) {
                fragment = new GameFragment();
            } else if (position == 3) {
                fragment = new CategoryFragment();
            }
            if (fragment != null) {
                mFragments.put(position, fragment);
            }
        }
        return fragment;

    }
}
