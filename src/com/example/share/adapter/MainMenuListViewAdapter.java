package com.example.share.adapter;

import java.util.List;

import com.example.share.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenuListViewAdapter extends BaseAdapter{
	private List<String> contents;
	private Context mContext;
	public MainMenuListViewAdapter(Context mContext, List<String> contents){
		this.mContext = mContext;
		this.contents = contents;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contents.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return contents.get(position);
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
					R.layout.main_menu_listview_item, null);
			viewgroup = new Viewgroup();
			// 绑定id操作
			viewgroup.content = (TextView) view.findViewById(R.id.main_menu_tv);
			viewgroup.content.setText(contents.get(position));
			view.setTag(viewgroup);
		} else {
			view = convertView;
			viewgroup = (Viewgroup) view.getTag();
		}
		// 为TextView加上内容
		return view;
	}
}




// 根据User里面的属性进行添加
class Viewgroup {
	TextView content;
}
