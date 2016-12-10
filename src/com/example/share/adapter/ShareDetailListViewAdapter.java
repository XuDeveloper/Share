package com.example.share.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.share.R;
import com.example.share.model.Comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareDetailListViewAdapter extends BaseAdapter{
	private Context mContext;
	private List<Comment> mContent;
	public ShareDetailListViewAdapter(Context mContext){
		this.mContext = mContext;
		mContent = new ArrayList<Comment>();
	}
	public ShareDetailListViewAdapter(Context mContext, List<Comment> mContent){
		this.mContext = mContext;
		this.mContent = mContent;
	}
	public void refreshData(List<Comment> mContent){
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
			view = LayoutInflater.from(mContext).inflate(R.layout.share_detail_listview_item, null);
			viewholder = new ViewHolder();
			viewholder.mCommentContent = (TextView) view.findViewById(R.id.comment_content);
			viewholder.mCommentUserLogo = (ImageView) view.findViewById(R.id.comment_user_logo);
			viewholder.mCommentUserName = (TextView) view.findViewById(R.id.comment_user_name);
			viewholder.mCommentTime = (TextView) view.findViewById(R.id.commnet_time);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		if(mContent.size() != 0){
			Comment mComment = mContent.get(position);
			viewholder.mCommentContent.setText(mComment.getmComment());
			viewholder.mCommentUserName.setText(mComment.getmUserName());
			viewholder.mCommentTime.setText(setTime(mComment.getmDate()));
		}
		return view;
	}
	class ViewHolder{
		ImageView mCommentUserLogo;
		TextView mCommentUserName;
		TextView mCommentTime;
		TextView mCommentContent;
	}
	private String setTime(String time){
		String[] str  = time.split("/");
		return str[0] + "年" + str[1] + "月" + str[2] + "日" + str[3] + "时" + str[4] + "分";
	}

}
