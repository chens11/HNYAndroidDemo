package com.hnyandroid.demo.handler;

import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.hnyandroid.demo.R;

public class HandlerDemo extends Activity implements OnClickListener{
	public MyHandler myHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handlerdemo);
	    myHandler = new MyHandler();
	    
	    Button button1 = (Button)findViewById(R.id.button1);
	    Button button2 = (Button)findViewById(R.id.button2);
	    Button button3 = (Button)findViewById(R.id.button3);
	    Button button4 = (Button)findViewById(R.id.button4);
	    Button button5 = (Button)findViewById(R.id.button5);
	    Button button6 = (Button)findViewById(R.id.button6);

	    button1.setOnClickListener(this);
	    button2.setOnClickListener(this);
	    button3.setOnClickListener(this);
	    button4.setOnClickListener(this);
	    button5.setOnClickListener(this);
	    button6.setOnClickListener(this);
	    
	}
	public class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			Bundle bundle = msg.getData();
			
			TextView textView = (TextView)findViewById(R.id.textView1);
			
			textView.setText(bundle.getString("test"));
		}
	}
	
    public class MyRunnable implements Runnable {

		@Override
		public void run() {
			
			Message msg = new Message();
			Bundle bundle = new Bundle();//存放数据
	        bundle.putString("test", "test handler string");
	        msg.setData(bundle);
	        
	        myHandler.sendMessage(msg); //向Handler发送消息,更新UI
//	        HandlerDemo.this.myHandler.sendMessage(msg);
			// TODO Auto-generated method stub
		}
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.button1:
		{
			MyRunnable myRunnable = new MyRunnable();
			new Thread(myRunnable).start();
		}			
			break;

		case R.id.button2:
		{
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Message msg = new Message();
					Bundle bundle = new Bundle();//存放数据
			        bundle.putString("test",v.getId() + "test timer task string");
			        msg.setData(bundle);
			        
			        myHandler.sendMessage(msg); //向Handler发送消息,更新UI

				}
			};
			Timer timer = new Timer();
			timer.schedule(timerTask, 1000);
			
		}
			break;
		case R.id.button3:
		{
			MyRunnable myRunnable = new MyRunnable();
			myHandler.post(myRunnable);
		}
		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}

	
}
