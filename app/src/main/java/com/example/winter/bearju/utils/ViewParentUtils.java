package com.example.winter.bearju.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewParentUtils {
	public static void removeParent(View v) {
		ViewParent parent = v.getParent();
		if (parent instanceof ViewGroup) {
			ViewGroup vp = (ViewGroup) parent;
			vp.removeView(vp);
		}
	}
}
