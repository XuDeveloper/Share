package com.example.share.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class ClientThread implements Runnable{
	private Socket mSocket;
	private Handler mHandler;
	public Handler mRevHandler;
	private BufferedReader mBR = null;
	private OutputStream mOS = null;
	public ClientThread(Handler mHandler){
		this.mHandler = mHandler;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Log.i("socket", "success1");
			mSocket = new Socket("192.168.153.2", 30002);
			Log.i("socket", "success2");
			mBR = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
			mOS = mSocket.getOutputStream();
			new Thread(){
				@Override
				public void run(){
					String content = null;
					try{
						while((content = mBR.readLine()) != null){
							if(content.startsWith("@")){
								Message msg = new Message();
								msg.what = 0x00;
								msg.obj = content;
								mHandler.sendMessage(msg);
							}else{
								Message msg = new Message();
								msg.what = 0x123;
								msg.obj = content;
								mHandler.sendMessage(msg);
							}
						}
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}.start();
			Looper.prepare();
			mRevHandler = new Handler(){
				@Override
				public void handleMessage(Message msg){
					if(msg.what == 0x345){
						try{
							mOS.write((msg.obj.toString() + "\r\n").getBytes("utf-8"));
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			};
			Looper.loop();
		}catch(SocketTimeoutException e1){
			System.out.println("网络连接超时");
			Log.i("socket", "timeout");
		}catch(Exception e){
			Log.i("socket", "fail");
			e.printStackTrace();
		}
	}

}
