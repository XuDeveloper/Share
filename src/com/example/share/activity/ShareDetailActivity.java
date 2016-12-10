package com.example.share.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.example.share.R;
import com.example.share.adapter.ShareDetailListViewAdapter;
import com.example.share.data.Data;
import com.example.share.model.Comment;
import com.example.share.model.ShareArticle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShareDetailActivity extends Activity implements OnClickListener {
	private ListView mListView;
	private View mArticleView;
	private ImageButton mBackImageButton;
	private TextView mArticleTitle;
	private TextView mArticleUserName;
	private TextView mArticleTime;
	private TextView mArticleContent;
	private Button mCommentButton;
	private EditText mCommentEditText;
	private ShareArticle mShareArticle;
	private int mArticlePosition;
	private ShareDetailListViewAdapter mShareDetailListViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_detail);
		initView();
	}

	private String setTime(String time) {
		String[] str = time.split("/");
		return str[0] + "年" + str[1] + "月" + str[2] + "日" + str[3] + "时"
				+ str[4] + "分";
	}

	private void setArticle(ShareArticle mArticle) {
		mArticleTitle.setText(mArticle.getmTitle());
		mArticleUserName.setText(mArticle.getmUserName());
		mArticleContent.setText(mArticle.getContent());
		mArticleTime.setText(setTime(mArticle.getDate()));
	}

	private void initView() {
		Bundle bundle = getIntent().getBundleExtra("ARTICLE");
		mListView = (ListView) findViewById(R.id.share_detail_lv);
		mBackImageButton = (ImageButton) findViewById(R.id.share_detail_back);
		mCommentButton = (Button) findViewById(R.id.share_detail_comment);
		mCommentEditText = (EditText) findViewById(R.id.share_detail_comment_content);
		mArticleView = LayoutInflater.from(this).inflate(
				R.layout.share_detail_article, null);
		mArticleView.setPadding(0, 0, 0, 20);
		mArticleTitle = (TextView) mArticleView
				.findViewById(R.id.share_detail_article_title);
		mArticleUserName = (TextView) mArticleView
				.findViewById(R.id.share_detail_article_user_name);
		mArticleTime = (TextView) mArticleView
				.findViewById(R.id.share_detail_article_time);
		mArticleContent = (TextView) mArticleView
				.findViewById(R.id.share_detail_article_content);
		if (bundle != null) {
			Log.i("bundle", "not null");
			mShareArticle = (ShareArticle) bundle.getSerializable("ARTICLE");
			mArticlePosition = (int) bundle.getInt("ARTICLEPOSITION");
			setArticle(mShareArticle);

			mShareDetailListViewAdapter = new ShareDetailListViewAdapter(this,
					mShareArticle.getmComments());
			mListView.setAdapter(mShareDetailListViewAdapter);

		}
		mListView.addHeaderView(mArticleView);
		mBackImageButton.setOnClickListener(this);
		mCommentButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.share_detail_back:
			finish();
			break;
		case R.id.share_detail_comment:
			String content = mCommentEditText.getText().toString();
			if (content.compareTo("") == 0) {
				Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();

			} else {
				Comment mComment = new Comment();
				mComment.setmComment(content);
				mComment.setmDate(getDate());
				mComment.setmUserName("Raymond");
				List<Comment> mCommenList = mShareArticle.getmComments();
				mCommenList.add(mComment);
				mShareArticle.setmComments(mCommenList);
				Data.mShareArticleList.set(mArticlePosition, mShareArticle);
				mShareDetailListViewAdapter.refreshData(mCommenList);
				mCommentEditText.setText("");

			}
			break;

		}
	}

	private String getDate() {
		TimeZone tz = TimeZone.getTimeZone("GMT+8");
		TimeZone.setDefault(tz);
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		return year + "/" + month + "/" + day + "/" + hour + "/" + minute + "/";
	}
}
