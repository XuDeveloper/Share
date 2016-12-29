package com.example.share.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.adapter.HomePageListViewAdapter;
import com.example.share.model.ShareArticle;
import com.xu.xnetwork.XNetwork;
import com.xu.xnetwork.XNetworkClient;
import com.xu.xnetwork.call.XNetworkCallBack;
import com.xu.xnetwork.request.Request;
import com.xu.xnetwork.response.Response;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class MyArticleActivity extends Activity implements OnClickListener {
	private ImageButton myArticle_back_ib;
	private ListView myArticle_lv;
	private HomePageListViewAdapter myArticle_adapter;
	private List<ShareArticle> mShareArticleList;
	private boolean ifFirst = true;
	private XNetworkClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myarticle_xml);
		// if(ifFirst){
		// initArticle();
		// ifFirst = false;
		// }
		initArticle();
		myArticle_back_ib = (ImageButton) findViewById(R.id.myarticle_back);
		myArticle_lv = (ListView) findViewById(R.id.myarticle_lv);
		myArticle_adapter = new HomePageListViewAdapter(this, mShareArticleList);
		myArticle_lv.setAdapter(myArticle_adapter);
		myArticle_back_ib.setOnClickListener(this);
	}

	private void initArticle() {
		final ShareArticle mArticle = null;
		mShareArticleList = new ArrayList<ShareArticle>();
		mArticle.setmUserName("Raymond");
		mArticle.setContent("首先你要认真上课然后认真做作业，最重要的是考试之前那几周准备好复习资料，而这些还不是最关键的，最关键的一步就是......");
		mArticle.setDate("两天前");
		mArticle.setmTitle("C++4.0全攻略");
		mArticle.setmTag("学习");
		mShareArticleList.add(mArticle);
		mShareArticleList.add(mArticle);
		mShareArticleList.add(mArticle);
		mShareArticleList.add(mArticle);

		client = XNetwork.defaultInit(MyArticleActivity.this);
		Request request = new Request.Builder().url("http://www.baidu.com").buildGetRequest();
        client.newRequest(this, request, new XNetworkCallBack() {
            @Override
            public void onSuccess(Response response) {
//            Message message = Message.obtain();
//            message.obj = response;
//            handler.sendMessage(message);
                mArticle = response.json(ShareArticle.class);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.myarticle_back:
			finish();
		}
	}
}
