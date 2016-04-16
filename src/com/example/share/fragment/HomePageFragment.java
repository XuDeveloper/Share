package com.example.share.fragment;


import com.example.share.R;
import com.example.share.adapter.HomePageListViewAdapter;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ScrollDirectionListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

public class HomePageFragment extends Fragment{
	private ListView homePage_lv;
	private HomePageListViewAdapter homePage_adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.homepage_xml, container, false);
		homePage_lv = (ListView) rootView.findViewById(R.id.main_listview);
		homePage_adapter = new HomePageListViewAdapter(this.getActivity());
		homePage_lv.setAdapter(homePage_adapter);
        FloatingActionButton homePage_fab = (FloatingActionButton) rootView.findViewById(R.id.homepage_fab);
        homePage_fab.attachToListView(homePage_lv, new ScrollDirectionListener() {
            @Override
            public void onScrollDown() {
                Log.d("ListViewFragment", "onScrollDown()");
            }

            @Override
            public void onScrollUp() {
                Log.d("ListViewFragment", "onScrollUp()");
            }
        }, new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.d("ListViewFragment", "onScrollStateChanged()");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d("ListViewFragment", "onScroll()");
            }
        });
		return rootView;
		
	}
}
