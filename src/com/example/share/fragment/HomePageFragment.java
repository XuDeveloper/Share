package com.example.share.fragment;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.share.R;
import com.example.share.activity.NewShareAriticleActivity;
import com.example.share.activity.NewShareBroadcastActivity;
import com.example.share.activity.ShareDetailActivity;
import com.example.share.adapter.HomePageListViewAdapter;
import com.example.share.data.Data;
import com.example.share.data.Rank;
import com.example.share.model.ShareArticle;
import com.example.share.ui.FloatingActionButton;
import com.example.share.ui.FloatingActionMenu;
import com.example.share.ui.RefreshableView;
import com.example.share.ui.RefreshableView.PullToRefreshListener;
import com.example.share.ui.ScrollDirectionListener;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.service.media.MediaBrowserService.Result;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class HomePageFragment extends Fragment implements OnClickListener, OnItemClickListener{
	private ListView homePage_lv;
	private HomePageListViewAdapter homePage_adapter;
	private FloatingActionButton mArticleFAB;
	private FloatingActionButton mBroadcastFAB;
//	private List<ShareArticle> mShareArticleList;
//	private static boolean ifFirst = true;
	private RefreshableView mRefreshableView;
	private Handler mHandler;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.homepage_xml, container,
				false);
//		if(ifFirst){
//			initArticle();
//			ifFirst = false;
//		}
//		initArticle();
		initView(rootView);


		return rootView;

	}
	private void initView(View view){
		Bundle bundle = getArguments();
		if(bundle != null){
			ShareArticle mShareArticle = (ShareArticle) bundle.getSerializable("ARTICLE");
			Data.mShareArticleList.add(mShareArticle);
		}
		mRefreshableView = (RefreshableView) view.findViewById(R.id.refresh_view);
		homePage_lv = (ListView) view.findViewById(R.id.main_listview);
		mArticleFAB = (FloatingActionButton) view.findViewById(R.id.homepage_article);
		mBroadcastFAB = (FloatingActionButton) view.findViewById(R.id.homepage_broadcast);
		homePage_adapter = new HomePageListViewAdapter(this.getActivity(), Data.mShareArticleList);
		homePage_lv.setAdapter(homePage_adapter);
		mArticleFAB.setOnClickListener(this);
		mBroadcastFAB.setOnClickListener(this);
		homePage_lv.setOnItemClickListener(this);
		mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg){
				if(msg.what == 0x011){
					Log.i("messgae", "1");
					homePage_adapter.refreshData(Data.mShareArticleList);
					for(ShareArticle sa : Data.mShareArticleList){
						Log.i("show", sa.getScore() + "");
					}
				}
			}
		};
		mRefreshableView.setOnRefreshListener(new PullToRefreshListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				try {
					for(ShareArticle sa : Data.mShareArticleList){
						sa.setScore(Rank.rank(Data.mUser, sa));
					}
					Collections.sort(Data.mShareArticleList);
									
				     Thread.sleep(3000);
				     Message msg = new Message();
						msg.what = 0x011;
						mHandler.sendMessage(msg);
				    } catch (InterruptedException e) {
				     e.printStackTrace();
				    } catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				mRefreshableView.finishRefreshing();
			}
		}, 0);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.homepage_article:
				Intent intent1 = new Intent(getActivity(), NewShareAriticleActivity.class);
				startActivity(intent1);
				break;
			case R.id.homepage_broadcast:
				Intent intent2 = new Intent(getActivity(), NewShareBroadcastActivity.class);
				startActivity(intent2);
				break;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Bundle bundle = new Bundle();
		bundle.putSerializable("ARTICLE", Data.mShareArticleList.get(position));
		bundle.putInt("ARTICLEPOSITION", position);
		Intent intent = new Intent(getActivity(), ShareDetailActivity.class);
		intent.putExtra("ARTICLE", bundle);
		startActivity(intent);
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
}
