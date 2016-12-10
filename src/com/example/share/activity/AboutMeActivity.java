package com.example.share.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.share.R;
import com.example.share.ui.FloatingActionButton;

public class AboutMeActivity extends Activity implements OnClickListener {
	private ImageButton mBackImageButton;
	private Button mExitButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_me);
		initView();
	}

	private void initView() {
		mBackImageButton = (ImageButton) findViewById(R.id.about_me_back);
		mExitButton = (Button) findViewById(R.id.about_me_exit);
		mBackImageButton.setOnClickListener(this);
		mExitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.about_me_back:
			finish();
			break;
		case R.id.about_me_exit:
			break;
		}
	}
}
