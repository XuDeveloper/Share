package com.example.share.fragment;

import com.example.share.R;
import com.example.share.activity.NewShareAriticleActivity;
import com.example.share.activity.NewShareBroadcastActivity;
import com.example.share.adapter.BroadcastListViewAdapter;
import com.example.share.ui.FloatingActionButton;
import com.example.share.ui.FloatingActionMenu;
import com.example.share.ui.ScrollDirectionListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;

public class Classification_BroadcastFragment extends Fragment implements OnClickListener{
	private ListView classification_broadcast_lv;
	private BroadcastListViewAdapter classification_broadcast_adapter;
	private FloatingActionButton mArticleFAB;
	private FloatingActionButton mBroadcastFAB;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.classification_broadcast_xml,
				container, false);
		
		initView(rootView);

		return rootView;
	}
	private void initView(View view){
		classification_broadcast_lv = (ListView) view
				.findViewById(R.id.classification_broadcast_lv);
		mArticleFAB = (FloatingActionButton) view.findViewById(R.id.broadcast_article_fab);
		mBroadcastFAB = (FloatingActionButton) view.findViewById(R.id.broadcast_broadcast_fab);
		classification_broadcast_adapter = new BroadcastListViewAdapter(
				this.getActivity());
		classification_broadcast_lv
				.setAdapter(classification_broadcast_adapter);
		mArticleFAB.setOnClickListener(this);
		mBroadcastFAB.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.broadcast_article_fab:
			Intent intent1 = new Intent(getActivity(), NewShareAriticleActivity.class);
			startActivity(intent1);
			break;
		case R.id.broadcast_broadcast_fab:
			Intent intent2 = new Intent(getActivity(), NewShareBroadcastActivity.class);
			startActivity(intent2);
			break;
	}
	}
}
