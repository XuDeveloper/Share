package com.example.share.fragment;

import java.util.ArrayList;

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

public class Classification_ArticleFragment extends Fragment{
	private ListView classification_article_lv;
	private FloatingActionButton classification_article_fab;
	private HomePageListViewAdapter classification_article_adapter;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.classification_article_xml, container, false);
		classification_article_lv = (ListView)rootView.findViewById(R.id.classification_article_lv);
		classification_article_fab = (FloatingActionButton)rootView.findViewById(R.id.classification_article_fab);
		classification_article_adapter = new HomePageListViewAdapter(this.getActivity());
		classification_article_lv.setAdapter(classification_article_adapter);
		classification_article_fab.attachToListView(classification_article_lv, new ScrollDirectionListener() {
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
