package com.example.share.adapter;

import com.example.share.R;
import com.example.share.adapter.HomePageListViewAdapter.Viewgroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BroadcastListViewAdapter extends BaseAdapter{
	private Context mContext;
	public BroadcastListViewAdapter(Context mContext){
		this.mContext = mContext;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		Viewgroup viewgroup;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.broadcast_listview_item, null);
			viewgroup = new Viewgroup();
			// 绑定id操作
			viewgroup.name_tv = (TextView) view.findViewById(R.id.broadcast_user_name);
			viewgroup.comment_iv = (ImageView) view.findViewById(R.id.broadcast_comment_iv);
			viewgroup.comment_tv = (TextView) view.findViewById(R.id.broadcast_commentcounts);
			viewgroup.user_iv = (ImageView) view.findViewById(R.id.broadcast_user_logo);
			viewgroup.content_tv = (TextView) view.findViewById(R.id.broadcast_content);
			viewgroup.time_tv = (TextView) view.findViewById(R.id.broadcast_time);
			view.setTag(viewgroup);
		} else {
			view = convertView;
			viewgroup = (Viewgroup) view.getTag();
		}
		// 为TextView加上内容
		return view;
	}

	// 根据User里面的属性进行添加
	class Viewgroup {
		TextView name_tv;
		ImageView user_iv;
		TextView content_tv;
		TextView comment_tv;
		ImageView comment_iv;
		TextView time_tv;
	}
}


