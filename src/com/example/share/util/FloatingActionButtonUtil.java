package com.example.share.util;

/**
 * 此类设置FloatingActionButton的一些属性
 */

import android.content.Context;

import com.example.share.R;
import com.example.share.ui.FloatingActionButton;

public class FloatingActionButtonUtil {

	public static void setFloatingButtonProperty(Context context,
			FloatingActionButton floatingActionButton) {
		floatingActionButton.setColorNormal(context.getResources().getColor(
				R.color.accent));
		floatingActionButton.setColorPressed(context.getResources().getColor(
				R.color.accent_pressed));
		floatingActionButton.setColorRipple(context.getResources().getColor(
				R.color.ripple));
		floatingActionButton.setShadow(true);
	}
}
