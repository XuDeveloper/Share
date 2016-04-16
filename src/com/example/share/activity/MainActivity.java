package com.example.share.activity;



import java.util.ArrayList;
import java.util.List;


import com.example.share.R;
import com.example.share.adapter.MainFragmentAdapter;
import com.melnykov.fab.*;


import com.example.share.fragment.*;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity{
	private ViewPager main_vp;
	private List<Fragment> fragments;
	private MainFragmentAdapter mainFragment_adapter;
	private ImageView homePage_iv;
	private ImageView classification_iv;
	private ImageView message_iv;
	private ImageView cursor_iv;
	private ImageView img_Float;
	private int cursorWidth;
	private int initPosition = 0;
	private int currentIndex = 0;
	private WindowManager mWindowManager = null;
	private WindowManager.LayoutParams wmParams = null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_xml);
		fragments = new ArrayList<Fragment>();
		fragments.add(new HomePageFragment());
		fragments.add(new ClassificationFragment());
		fragments.add(new MessageFragment());
		mainFragment_adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
		InitImageView();
		InitCursor();
		main_vp = (ViewPager)findViewById(R.id.main_viewpager);
		main_vp.setAdapter(mainFragment_adapter);
		main_vp.setCurrentItem(0);
		main_vp.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	private void InitImageView(){
		homePage_iv = (ImageView)findViewById(R.id.main_homepage_iv);
		classification_iv = (ImageView)findViewById(R.id.main_classification_iv);
		message_iv = (ImageView)findViewById(R.id.main_message_iv);
		homePage_iv.setOnClickListener(new MyOnClickListener(0));
		classification_iv.setOnClickListener(new MyOnClickListener(1));
		message_iv.setOnClickListener(new MyOnClickListener(2));
		
	}
    private void InitCursor() {
    	cursor_iv = (ImageView) findViewById(R.id.main_cursor);
        cursorWidth = BitmapFactory.decodeResource(getResources(), R.drawable.cursor)
                .getWidth();
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
    public class MyOnPageChangeListener implements OnPageChangeListener{

        int offsetOne = (initPosition + (cursorWidth / 2)) * 2;
        int offsetTwo = offsetOne * 2;
        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currentIndex == 1) {
                        animation = new TranslateAnimation(offsetOne, 0, 0, 0);
                        classification_iv.setImageResource(R.drawable.classification_unchecked);
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
                        animation = new TranslateAnimation(offsetTwo, offsetOne, 0, 0);
                        message_iv.setImageResource(R.drawable.message_unchecked);
                    }
                    classification_iv.setImageResource(R.drawable.classification_checked);
                    break;
                case 2:
                	if (currentIndex == 0) {
                        animation = new TranslateAnimation(0, offsetTwo, 0, 0);
                        homePage_iv.setImageResource(R.drawable.homepage_unchecked);
                    } else if (currentIndex == 1) {
                        animation = new TranslateAnimation(offsetOne, offsetTwo, 0, 0);
                        classification_iv.setImageResource(R.drawable.classification_unchecked);
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
}
