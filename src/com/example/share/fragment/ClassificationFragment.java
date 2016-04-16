package com.example.share.fragment;


import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.adapter.MainFragmentAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassificationFragment extends Fragment{
	ImageView classification_article_iv;
	ImageView classification_broadcast_iv;
	TextView classification_article_tv;
	TextView classification_broadcast_tv;
	FragmentTransaction classification_ft;
	Fragment classification_articleFragment;
	Fragment classification_broadcastFragment;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.classification_xml, container, false);
		classification_article_iv = (ImageView)rootView.findViewById(R.id.classfication_article_iv);
		classification_broadcast_iv = (ImageView)rootView.findViewById(R.id.classfication_broadcast_iv);
		classification_article_tv = (TextView)rootView.findViewById(R.id.classfication_article_tv);
		classification_broadcast_tv = (TextView)rootView.findViewById(R.id.classfication_broadcast_tv);
		classification_articleFragment = new Classification_ArticleFragment();
		classification_broadcastFragment = new Classification_BroadcastFragment();
		classification_ft = getActivity().getSupportFragmentManager().beginTransaction();
		classification_ft.replace(R.id.classification_fragment, new Classification_ArticleFragment());
		classification_ft.commit();
		if(getActivity() != null){
			Log.i("TAG", "hahah");
		}
		classification_article_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				classification_ft = getActivity().getSupportFragmentManager().beginTransaction();
				classification_ft.replace(R.id.classification_fragment, new Classification_ArticleFragment());
				classification_ft.commit();
				classification_article_iv.setVisibility(0);
				classification_article_tv.setTextColor(0xFFffffff);
				classification_broadcast_iv.setVisibility(4);
				classification_broadcast_tv.setTextColor(0xFFa2a2a2);
			}
		});
		classification_broadcast_tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				classification_ft = getActivity().getSupportFragmentManager().beginTransaction();
				classification_ft.replace(R.id.classification_fragment, new Classification_BroadcastFragment());
				classification_ft.commit();
				classification_article_iv.setVisibility(4);
				classification_article_tv.setTextColor(0xFFa2a2a2);
				classification_broadcast_iv.setVisibility(0);
				classification_broadcast_tv.setTextColor(0xFFffffff);
			}
		});
		return rootView;	
	}

}
