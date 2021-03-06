package com.hnyandroid.demo;

import java.util.List;

import android.R.array;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hnyandroid.demo.handler.HandlerDemo;

public class Main extends Activity implements OnItemSelectedListener,OnItemClickListener{
	
	private static String[] list = new String[]
	{
			"test handler",
			"保持通话",
			"乱世佳人(飘)",
			"乱世佳人(飘)",
			"乱世佳人(飘)",
			"怪侠一枝梅",
			"第五空间",
			"孔雀翎",
			"变形金刚3（真人版）",
			"星际传奇",
			"《大笑江湖》剧中，小鞋匠是小沈阳，他常强出头，由不懂武功的菜鸟变成武林第一高手；赵本山则是个武功高强的大盗，被不会武功的小沈阳打败；程野扮演赵本山的手下皮丘，经常拖累赵本山。 其余角色都围绕小沈阳设置。" };

	
	public static String[] getList() {
		return list;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView)findViewById(R.id.listView1);
		HNYAdapter hnyAdapter = new HNYAdapter(this);

		listView.setAdapter(hnyAdapter);
		listView.setOnItemClickListener(this);
		listView.setOnItemSelectedListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

		String string = (String)parent.getAdapter().getItem(position);
		if (string.equals("test handler")) {
			Intent intent = new Intent(this, HandlerDemo.class);
			startActivity(intent);
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		else if (string.equals("test synchronized")) {
			//
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	
	private class HNYAdapter extends BaseAdapter{

		private Context context;
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.length;
		}


		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater layoutInflater = (LayoutInflater) context
					.getSystemService(inflater);

			LinearLayout linearLayout = null;
			linearLayout = (LinearLayout) layoutInflater.inflate(
					R.layout.mainlistcell, null);


			TextView textView = (TextView)linearLayout.findViewById(R.id.textView1);
			textView.setText(getItem(position).toString());
			return linearLayout;
		}

		public HNYAdapter (Context context) {
			this.context = context;
		}
		
	}
}
