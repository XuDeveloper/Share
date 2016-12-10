package com.example.share.activity;

import java.util.Calendar;

import com.example.share.R;
import com.example.share.model.ShareArticle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class NewShareAriticleActivity extends Activity implements OnClickListener{
	private ImageButton mBackImageButton;
	private Button mReportButton;
	private EditText mTitleEditText;
	private EditText mContentEditText;
	private RadioButton mTagStudyRadioButton;
	private RadioButton mTagSportRadioButton;
	private RadioButton mTagLifeRadioButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_share_article);
		initView();
	}
	private void initView(){
		mBackImageButton = (ImageButton) findViewById(R.id.new_share_article_back);
		mReportButton = (Button) findViewById(R.id.new_share_article_report);
		mTitleEditText = (EditText) findViewById(R.id.new_share_article_title);
		mContentEditText = (EditText) findViewById(R.id.new_share_article_content);
		mTagStudyRadioButton = (RadioButton) findViewById(R.id.new_share_article_tag_study);
		mTagSportRadioButton = (RadioButton) findViewById(R.id.new_share_article_tag_sport);
		mTagLifeRadioButton = (RadioButton) findViewById(R.id.new_share_article_tag_life);
		mBackImageButton.setOnClickListener(this);
		mReportButton.setOnClickListener(this);
	}
	private String getTime(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		return year + "/" + month + "/" + date + "/" + hour + "/" + minute + "/";	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.new_share_article_back:
			finish();
			break;
		case R.id.new_share_article_report:
			String title = mTitleEditText.getText().toString();
			String content = mContentEditText.getText().toString();
			if(title.compareTo("") == 0){
				Toast.makeText(this, "标题不能为空", Toast.LENGTH_SHORT).show();
			}else if(content.compareTo("") == 0){
				Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
			}else{
				ShareArticle mArticle = new ShareArticle();
				mArticle.setmTitle(title);
				mArticle.setContent(content);
				mArticle.setDate(getTime());
				if(mTagStudyRadioButton.isChecked()){
					mArticle.setmTag("学习");
				}else if(mTagSportRadioButton.isChecked()){

					mArticle.setmTag("运动");
				}else if(mTagLifeRadioButton.isChecked()){

					mArticle.setmTag("生活");
				}
				
				Bundle bundle = new Bundle();
				bundle.putSerializable("ARTICLE", mArticle);
				Intent intent = new Intent(this, MainActivity.class);
				intent.putExtra("ARTICLE", bundle);
				startActivity(intent);
				Toast.makeText(this, "发表成功", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
	}
}
