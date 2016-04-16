package com.example.share.activity;

import com.example.share.R;
import com.example.share.adapter.HomePageListViewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class MyArticleActivity extends Activity implements OnClickListener{
	private ImageButton myArticle_back_ib;
	private ListView myArticle_lv;
	private HomePageListViewAdapter myArticle_adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myarticle_xml);
		myArticle_back_ib = (ImageButton)findViewById(R.id.myarticle_back);
		myArticle_lv = (ListView)findViewById(R.id.myarticle_lv);
		myArticle_adapter = new HomePageListViewAdapter(this);
		myArticle_lv.setAdapter(myArticle_adapter);
		myArticle_back_ib.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.myarticle_back:
				finish();
		}
	}
}
