package com.example.share.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.adapter.MainFragmentAdapter;
import com.example.share.adapter.MainMenuListViewAdapter;

import com.example.share.fragment.*;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class MainActivity extends FragmentActivity implements OnClickListener,
		OnDismissListener, OnItemClickListener {
	private ViewPager main_vp;
	private List<Fragment> fragments;
	private MainFragmentAdapter mainFragment_adapter;
	private ImageView homePage_iv;
	private ImageView classification_iv;
	private ImageView message_iv;
	private ImageView cursor_iv;
	private ImageButton mainMenu_ib;
	private ImageButton mainSearch_ib;
	private ListView mainMenu_lv;
	private int cursorWidth;
	private int initPosition = 0;
	private int currentIndex = 0;
	private PopupWindow mainMenu_pw;
	private PopupWindow search_pw;
	private int screenWidth;
	private int screenHeight;
	private WindowManager main_wm;
	private View popupView;
	private View popupSearchView;
	private MainMenuListViewAdapter mainMenu_adapter;
	private List<String> mainMenuList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_xml);
		Init();
		InitCursor();
		main_vp = (ViewPager) findViewById(R.id.main_viewpager);
		main_vp.setAdapter(mainFragment_adapter);
		main_vp.setCurrentItem(0);
		main_vp.setOnPageChangeListener(new MyOnPageChangeListener());

	}

	private void Init() {
		fragments = new ArrayList<Fragment>();
		mainMenuList = new ArrayList<String>();
		fragments.add(new HomePageFragment());
		fragments.add(new ClassificationFragment());
		fragments.add(new MessageFragment());
		mainMenuList.add("我的文章");
		mainMenuList.add("我赞过的");
		mainMenuList.add("设置");
		mainMenuList.add("关于");
		main_wm = this.getWindowManager();
		screenWidth = main_wm.getDefaultDisplay().getWidth();
		screenHeight = main_wm.getDefaultDisplay().getHeight();
		popupView = getLayoutInflater().inflate(
				R.layout.main_menupopupwindow_xml, null);
		popupSearchView = getLayoutInflater().inflate(
				R.layout.main_searchdialog_xml, null);
		mainFragment_adapter = new MainFragmentAdapter(
				getSupportFragmentManager(), fragments);
		mainMenu_pw = new PopupWindow(popupView, screenWidth - 100,
				screenHeight - 100, true);
		mainMenu_pw.setAnimationStyle(R.style.anim_menu_inandout);
		mainMenu_pw.setBackgroundDrawable(new BitmapDrawable());
		search_pw = new PopupWindow(popupSearchView, screenWidth,
				screenHeight, true);
		search_pw.setBackgroundDrawable(new BitmapDrawable());
		mainMenu_lv = (ListView) popupView.findViewById(R.id.main_menu_lv);
		homePage_iv = (ImageView) findViewById(R.id.main_homepage_iv);
		classification_iv = (ImageView) findViewById(R.id.main_classification_iv);
		message_iv = (ImageView) findViewById(R.id.main_message_iv);
		mainMenu_ib = (ImageButton) findViewById(R.id.main_menu_ib);
		mainSearch_ib = (ImageButton) findViewById(R.id.main_search_bt);
		mainMenu_adapter = new MainMenuListViewAdapter(MainActivity.this,
				mainMenuList);
		homePage_iv.setOnClickListener(new MyOnClickListener(0));
		classification_iv.setOnClickListener(new MyOnClickListener(1));
		message_iv.setOnClickListener(new MyOnClickListener(2));
		mainMenu_ib.setOnClickListener(this);
		mainMenu_lv.setAdapter(mainMenu_adapter);
		mainMenu_pw.setOnDismissListener(this);
		search_pw.setOnDismissListener(this);
		search_pw.setOutsideTouchable(true);
		mainMenu_lv.setOnItemClickListener(this);
		mainSearch_ib.setOnClickListener(this);
	}

	private void InitCursor() {
		cursor_iv = (ImageView) findViewById(R.id.main_cursor);
		cursorWidth = BitmapFactory.decodeResource(getResources(),
				R.drawable.cursor).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		initPosition = (screenW / 6) - (cursorWidth / 2);
		Matrix matrix = new Matrix();
		matrix.postTranslate(initPosition, 0);
		cursor_iv.setImageMatrix(matrix);
	}

	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			main_vp.setCurrentItem(index);
		}
	};

	public class MyOnPageChangeListener implements OnPageChangeListener {

		int offsetOne = (initPosition + (cursorWidth / 2)) * 2;
		int offsetTwo = offsetOne * 2;

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currentIndex == 1) {
					animation = new TranslateAnimation(offsetOne, 0, 0, 0);
					classification_iv
							.setImageResource(R.drawable.classification_unchecked);
				} else if (currentIndex == 2) {
					animation = new TranslateAnimation(offsetTwo, 0, 0, 0);
					message_iv.setImageResource(R.drawable.message_unchecked);
				}
				homePage_iv.setImageResource(R.drawable.homepage_checked);
				break;
			case 1:
				if (currentIndex == 0) {
					animation = new TranslateAnimation(0, offsetOne, 0, 0);
					homePage_iv.setImageResource(R.drawable.homepage_unchecked);
				} else if (currentIndex == 2) {
					animation = new TranslateAnimation(offsetTwo, offsetOne, 0,
							0);
					message_iv.setImageResource(R.drawable.message_unchecked);
				}
				classification_iv
						.setImageResource(R.drawable.classification_checked);
				break;
			case 2:
				if (currentIndex == 0) {
					animation = new TranslateAnimation(0, offsetTwo, 0, 0);
					homePage_iv.setImageResource(R.drawable.homepage_unchecked);
				} else if (currentIndex == 1) {
					animation = new TranslateAnimation(offsetOne, offsetTwo, 0,
							0);
					classification_iv
							.setImageResource(R.drawable.classification_unchecked);
				}
				message_iv.setImageResource(R.drawable.message_checked);
				break;
			default:
				break;

			}
			currentIndex = arg0;
			animation.setFillAfter(true);
			animation.setDuration(100);
			cursor_iv.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.main_menu_ib:
			mainMenu_pw.showAtLocation(findViewById(R.id.main_menu_ib),
					Gravity.NO_GRAVITY, 0, 0);
			setBackgroundDark();
			Log.i("TAG", "show");
			break;
		case R.id.main_search_bt:
			search_pw.showAtLocation(findViewById(R.id.main_search_bt),
					Gravity.TOP, 0, 0);
			setBackgroundDark();
			
			break;
		}
	}

	private void setBackgroundDark() {
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 0.7f;
		getWindow().setAttributes(lp);
	}

	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.alpha = 1f;
		getWindow().setAttributes(lp);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			Intent intent = new Intent(MainActivity.this,
					MyArticleActivity.class);
			startActivity(intent);
		}
	}

}
