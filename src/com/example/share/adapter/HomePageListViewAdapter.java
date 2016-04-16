package com.example.share.adapter;

/**
 * 
 * @author Xu
 * ListView的适配器
 *
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.share.R;

public class HomePageListViewAdapter extends BaseAdapter {

	private Context mContext;

	public HomePageListViewAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		Viewgroup viewgroup;
		if (convertView == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.homepage_listview_item, null);
			viewgroup = new Viewgroup();
			// 绑定id操作
			viewgroup.name_tv = (TextView) view.findViewById(R.id.user_name);
			viewgroup.logo_iv = (ImageView) view.findViewById(R.id.user_logo);
			viewgroup.tag_tv = (TextView) view.findViewById(R.id.tag_text);
			viewgroup.title_tv = (TextView) view.findViewById(R.id.main_title);
			viewgroup.content_tv = (TextView) view.findViewById(R.id.item_content);
			viewgroup.time_tv = (TextView) view.findViewById(R.id.item_date);
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
		ImageView logo_iv;
		TextView tag_tv;
		TextView title_tv;
		TextView content_tv;
		TextView time_tv;
	}

}
