package com.example.share.adapter;

import java.util.List;

import com.example.share.R;
import com.example.share.model.Message;
import com.example.share.model.User;
import com.example.share.model.UserAndMessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageListViewAdapter extends BaseAdapter{
	private Context mContext;
	private List<UserAndMessage> mContent;
	public MessageListViewAdapter(Context mContext, List<UserAndMessage> mContent){
		this.mContext = mContext;
		this.mContent = mContent;

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
			view = LayoutInflater.from(mContext).inflate(
					R.layout.message_listview_message_from_item, null);
			viewholder = new ViewHolder();
			viewholder.mUserLogo = (ImageView) view.findViewById(R.id.message_logo);
			viewholder.mUserName = (TextView) view.findViewById(R.id.message_user_name);
			viewholder.mMessageContent = (TextView) view.findViewById(R.id.message_user_content);
			viewholder.mMessageCount = (TextView) view.findViewById(R.id.message_from_counts);
			viewholder.mMessageTime = (TextView) view.findViewById(R.id.message_user_time);
			viewholder.mMessageReceive = (ImageView) view.findViewById(R.id.message_receive_iv);
			viewholder.mMessgaeSend = (ImageView) view.findViewById(R.id.message_send_iv);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		UserAndMessage mUserMessage = mContent.get(position);
		User mUser = mUserMessage.getmUser();
		List<Message> mMessageList = mUserMessage.getmMessageList();
		viewholder.mUserLogo.setImageBitmap(mUser.getmLogo());
		viewholder.mUserName.setText(mUser.getmName());
//		viewholder.mMessageCount.setText(mMessageList.size());
		if(mMessageList.size() != 0){
			Message mMessage = mMessageList.get(mMessageList.size() - 1);
			viewholder.mMessageTime.setText(mMessage.getDate().toString());
			String toName = mMessage.getTo().getmName();
			if(mUser.getmName().compareTo(toName) == 0){
				viewholder.mMessgaeSend.setVisibility(View.VISIBLE);
				viewholder.mMessageReceive.setVisibility(View.GONE);
			}else{
				viewholder.mMessgaeSend.setVisibility(View.GONE);
				viewholder.mMessageReceive.setVisibility(View.VISIBLE);
			}
		}else{
			viewholder.mMessageTime.setText("");
			viewholder.mMessgaeSend.setVisibility(View.GONE);
			viewholder.mMessageReceive.setVisibility(View.GONE);
		}

		return view;
	}
	class ViewHolder{
		ImageView mUserLogo;
		TextView mUserName;
		TextView mMessageContent;
		ImageView mMessageReceive;
		ImageView mMessgaeSend;
		TextView mMessageTime;
		TextView mMessageCount;
	}

}
