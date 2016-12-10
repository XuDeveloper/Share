package com.example.share.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.activity.NewShareAriticleActivity;
import com.example.share.activity.NewShareBroadcastActivity;
import com.example.share.adapter.HomePageListViewAdapter;
import com.example.share.data.Data;

import com.example.share.model.ShareArticle;
import com.example.share.ui.FloatingActionButton;
import com.example.share.ui.FloatingActionMenu;
import com.example.share.ui.ScrollDirectionListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

public class Classification_ArticleFragment extends Fragment implements OnClickListener{
	private ListView classification_article_lv;
	private FloatingActionButton mArticleFAB;
	private FloatingActionButton mBroadcastFAB;
	private HomePageListViewAdapter classification_article_adapter;
//	private List<ShareArticle> mShareArticleList;
//	private boolean ifFirst = true;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.classification_article_xml,
				container, false);
//		if(ifFirst){
//			initArticle();
//			ifFirst = false;
//		}
//		initArticle();
		initView(rootView);

		return rootView;
	}
	private void initView(View view){

		classification_article_lv = (ListView) view
				.findViewById(R.id.classification_article_lv);
		mArticleFAB = (FloatingActionButton) view.findViewById(R.id.article_article_fab);
		mBroadcastFAB = (FloatingActionButton) view.findViewById(R.id.article_broadcast_fab);
		classification_article_adapter = new HomePageListViewAdapter(
				this.getActivity(), Data.mShareArticleList);
		classification_article_lv.setAdapter(classification_article_adapter);
		mArticleFAB.setOnClickListener(this);
		mBroadcastFAB.setOnClickListener(this);
	}
//	private void initArticle(){
//		ShareArticle mArticle = new ShareArticle();
//		mShareArticleList = new ArrayList<ShareArticle>();
//		mArticle.setmUserName("Raymond");
//		mArticle.setContent("首先你要认真上课然后认真做作业，最重要的是考试之前那几周准备好复习资料，而这些还不是最关键的，最关键的一步就是......");
//		mArticle.setDate("2015/9/30/16/5");
//		mArticle.setmTitle("C++4.0全攻略");
//		mArticle.setmTag("学习");
//		mShareArticleList.add(mArticle);
//		mShareArticleList.add(mArticle);
//		mShareArticleList.add(mArticle);
//		mShareArticleList.add(mArticle);
//	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.article_article_fab:
			Intent intent1 = new Intent(getActivity(), NewShareAriticleActivity.class);
			startActivity(intent1);
			break;
		case R.id.article_broadcast_fab:
			Intent intent2 = new Intent(getActivity(), NewShareBroadcastActivity.class);
			startActivity(intent2);
			break;
	}
	}
}
