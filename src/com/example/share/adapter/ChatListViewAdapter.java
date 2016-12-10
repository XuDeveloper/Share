package com.example.share.adapter;

import java.util.List;

import com.example.share.R;
import com.example.share.activity.ChatActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatListViewAdapter extends BaseAdapter{
	private Context mContext;
	private List<String> mContent;
	public ChatListViewAdapter(Context mContext, List<String> mContent){
		this.mContent = mContent;
		this.mContext = mContext;
	}
	public void refresh(List<String> mContent){
		this.mContent = mContent;
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mContent.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mContent.get(position);
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
		ViewHolder viewholder;
		if(convertView == null){
			viewholder = new ViewHolder();
			if(mContent.size() != 0){
				String content = mContent.get(position);
				String[] str = content.split(",");
				if(str[0].compareTo(ChatActivity.mLocalSocketPort) == 0){
					view = LayoutInflater.from(mContext).inflate(
							R.layout.chat_from_msg, null);
					viewholder.mUserLogo = (ImageView) view.findViewById(R.id.user_logo_from);
					viewholder.mContent = (TextView) view.findViewById(R.id.from_content_tv);
					view.setTag(viewholder);
				}else{
					view = LayoutInflater.from(mContext).inflate(
							R.layout.chat_send_msg, null);
					viewholder.mUserLogo = (ImageView) view.findViewById(R.id.user_logo_send);
					viewholder.mContent = (TextView) view.findViewById(R.id.send_content_tv);
					view.setTag(viewholder);
				}
			}else{
				view = null;
			}

		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		if(mContent.size() != 0){
			String content = mContent.get(position);
			int index = content.indexOf(",");
			viewholder.mContent.setText(content.substring(index + 1));
		}
		return view;
	}
	class ViewHolder{
		private ImageView mUserLogo;
		private TextView mContent;
	}

}
