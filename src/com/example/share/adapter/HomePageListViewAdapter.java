package com.example.share.adapter;

/**
 * 
 * @author Xu
 * ListView��������
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import android.content.Context;
import android.os.AsyncTask;
import android.service.media.MediaBrowserService.Result;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.share.R;
import com.example.share.data.Data;
import com.example.share.data.Rank;
import com.example.share.model.ShareArticle;

public class HomePageListViewAdapter extends BaseAdapter {

	private Context mContext;
	private List<ShareArticle> mContent;
	public HomePageListViewAdapter(Context context, List<ShareArticle> mContent) {
		mContext = context;
		this.mContent = mContent;
	}
	public void refreshData(List<ShareArticle> mContent){
		

		this.mContent = mContent;
		notifyDataSetChanged();

	}
	@Override
	public int getCount() {
		return mContent.size();
	}

	@Override
	public Object getItem(int position) {
		return mContent.get(position);
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
			// ��id����
			viewgroup.name_tv = (TextView) view.findViewById(R.id.user_name);
			viewgroup.logo_iv = (ImageView) view.findViewById(R.id.user_logo);
			viewgroup.tag_tv = (TextView) view.findViewById(R.id.tag_text);
			viewgroup.title_tv = (TextView) view.findViewById(R.id.item_title);
			viewgroup.content_tv = (TextView) view.findViewById(R.id.item_content);
			viewgroup.time_tv = (TextView) view.findViewById(R.id.item_date);
			viewgroup.approve_tv = (TextView) view.findViewById(R.id.item_approved_people);
			view.setTag(viewgroup);
		} else {
			view = convertView;
			viewgroup = (Viewgroup) view.getTag();
		}
		if(mContent.size() != 0){
			ShareArticle mArticle = mContent.get(position);
			viewgroup.name_tv.setText(mArticle.getmUserName());
			viewgroup.tag_tv.setText(mArticle.getmTag());
			viewgroup.title_tv.setText(mArticle.getmTitle());
			viewgroup.content_tv.setText(setContent(mArticle.getContent()));
			viewgroup.time_tv.setText(setDate(mArticle.getDate()));
			viewgroup.approve_tv.setText(String.valueOf((mArticle.getmLikes()).size()));
		}
		// ΪTextView��������
		return view;
	}

	// ����User��������Խ������
	class Viewgroup {
		TextView name_tv;
		ImageView logo_iv;
		TextView tag_tv;
		TextView title_tv;
		TextView content_tv;
		TextView time_tv;
		TextView approve_tv;
	}
	private String setContent(String content){
		if(content.length() > 30){
			content = content.substring(0, 30);
			return content;
		}else{
			return content;
		}
	}
	private String setDate(String date){
		TimeZone tz = TimeZone.getTimeZone("GMT+8");TimeZone.setDefault(tz);
		String[] str = date.split("/");
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		month = month + 1;
		int day = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		if((Integer.parseInt(str[0]) - year) != 0){
			return year - Integer.parseInt(str[0]) + "年前";
		}else if((Integer.parseInt(str[1]) - month) != 0){
			return month - Integer.parseInt(str[1]) + "个月前";
		}else if((Integer.parseInt(str[2]) - day) != 0){
			return day - Integer.parseInt(str[2]) + "天前";
		}else if((Integer.parseInt(str[3]) - hour) != 0){
			return hour - Integer.parseInt(str[3]) + "小时前";
		}else if((Integer.parseInt(str[4]) - minute) != 0){
			return minute - Integer.parseInt(str[4]) + "分钟前";
		}else{
			return "现在";
		}
	}


}
