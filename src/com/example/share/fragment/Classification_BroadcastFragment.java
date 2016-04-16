package com.example.share.fragment;

import com.example.share.R;
import com.example.share.adapter.BroadcastListViewAdapter;
import com.example.share.util.FloatingActionButtonUtil;
import com.example.share.ui.FloatingActionButton;
import com.example.share.ui.ScrollDirectionListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Classification_BroadcastFragment extends Fragment {
	private ListView classification_broadcast_lv;
	private BroadcastListViewAdapter classification_broadcast_adapter;
	private FloatingActionButton classification_broadcast_fab;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.classification_broadcast_xml,
				container, false);
		classification_broadcast_lv = (ListView) rootView
				.findViewById(R.id.classification_broadcast_lv);
		classification_broadcast_fab = (FloatingActionButton) rootView
				.findViewById(R.id.classification_broadcast_fab);
		classification_broadcast_adapter = new BroadcastListViewAdapter(
				this.getActivity());
		classification_broadcast_lv
				.setAdapter(classification_broadcast_adapter);
		classification_broadcast_fab.attachToListView(
				classification_broadcast_lv, new ScrollDirectionListener() {

					@Override
					public void onScrollUp() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onScrollDown() {
						// TODO Auto-generated method stub

					}
				});
		FloatingActionButtonUtil.setFloatingButtonProperty(getActivity(),
				classification_broadcast_fab);
		return rootView;
	}
}
