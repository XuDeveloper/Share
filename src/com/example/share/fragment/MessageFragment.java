package com.example.share.fragment;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.activity.ChatActivity;
import com.example.share.activity.MainActivity;
import com.example.share.adapter.MessageListViewAdapter;
import com.example.share.model.Message;
import com.example.share.model.User;
import com.example.share.model.UserAndMessage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MessageFragment extends Fragment implements OnItemClickListener{
	private ListView mListView;
	private List<UserAndMessage> mUserMessageList = new ArrayList<UserAndMessage>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.message_xml, container, false);
		if(mUserMessageList.size() == 0){
			initList();
		}
		initView(rootView);
		return rootView;	
	}
	private void initView(View view){
		mListView = (ListView) view.findViewById(R.id.message_listview);
		mListView.setAdapter(new MessageListViewAdapter(getActivity(), mUserMessageList));
		mListView.setOnItemClickListener(this);
	}
	private void initList(){
		User mUser = new User();
		mUser.setmName("Raymond");
		Resources res=getResources();
		Bitmap bmp=BitmapFactory.decodeResource(res, R.drawable.user_logo);
		mUser.setmLogo(bmp);
		UserAndMessage mUserMessage = new UserAndMessage(mUser);
		mUserMessageList.add(mUserMessage);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		UserAndMessage mUserAndMessage  = mUserMessageList.get(position);
		User mUser = mUserAndMessage.getmUser();
		Bundle bundle = new Bundle();
		bundle.putString("USERNAME", mUser.getmName());
//		bundle.putSerializable("MESSAGELIST", (Serializable) mMessageList);
		Intent intent = new Intent(getActivity(), ChatActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);
	}


}

