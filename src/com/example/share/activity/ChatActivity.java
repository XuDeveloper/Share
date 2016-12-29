package com.example.share.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.example.share.R;
import com.example.share.adapter.ChatListViewAdapter;
import com.example.share.model.User;
import com.example.share.model.UserAndMessage;
import com.example.share.thread.ClientThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity implements OnClickListener {
	public static String mLocalSocketPort;
	private String mTargetSocketPort;
	private ListView mListView;
	private UserAndMessage mUserMessage;
	private TextView mUserNameTextView;
	private EditText mInputEditText;
	private Button mSendButton;
	private Handler mHandler;
	private List<String> mMessageList = new ArrayList<String>();
	private ChatListViewAdapter mChatAdapter;
	private ClientThread mClientThread;
	private ExecutorService executorService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_xml);
		initView();
		executorService = Executors.newSingleThreadExecutor();
	}

	private void initView() {
		Bundle bundle = getIntent().getExtras();
		String mUserName = bundle.getString("USERNAME");
		mListView = (ListView) findViewById(R.id.message_list);
		mUserNameTextView = (TextView) findViewById(R.id.chat_user_name);
		mInputEditText = (EditText) findViewById(R.id.chat_input_et);
		mSendButton = (Button) findViewById(R.id.chat_send_bt);
		mUserNameTextView.setText(mUserName);
		mSendButton.setOnClickListener(this);
		mChatAdapter = new ChatListViewAdapter(this, mMessageList);
		mListView.setAdapter(mChatAdapter);
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0x123) {
					mMessageList.add(msg.obj.toString());
					mChatAdapter.refresh(mMessageList);
				} else if (msg.what == 0x00) {
					mLocalSocketPort = msg.obj.toString().replace("@", "");
					Log.i("mLocalSocketPort4", mLocalSocketPort);
					// mUsernumber = Integer.parseInt(number);
				}
			}
		};
		mClientThread = new ClientThread(mHandler);
		Log.i("connect", "3");
		executorService.submit(mClientThread);
//		new Thread(mClientThread).start();
		Log.i("connect", "4");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.chat_send_bt:
			try {
				Message msg = new Message();
				msg.what = 0x345;
				msg.obj = mLocalSocketPort + ","
						+ mInputEditText.getText().toString();
				Log.i("connect", "1");
				if (mClientThread.mRevHandler == null) {
					Log.i("TAG", "null");
				}
				mClientThread.mRevHandler.sendMessage(msg);
				Log.i("connect", "2");
				mInputEditText.setText("");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
