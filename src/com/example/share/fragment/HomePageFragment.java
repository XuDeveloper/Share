package com.example.share.fragment;


import com.example.share.R;
import com.example.share.adapter.HomePageListViewAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomePageFragment extends Fragment{
	private ListView listView;
	private HomePageListViewAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.homepage_xml, container, false);
		listView = (ListView) rootView.findViewById(R.id.main_listview);
		adapter = new HomePageListViewAdapter(this.getContext());
		listView.setAdapter(adapter);
		return rootView;
		
	}
}
