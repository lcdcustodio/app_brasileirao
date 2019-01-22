package com.brasileirao.android.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.brasileirao.android.R;
import com.brasileirao.android.listview.JogoItem;
import com.brasileirao.android.listview.JogosBaseAdapter;
import com.brasileirao.android.listview.LanceItem;

public class Lances_Fragment extends Fragment {

	private JogosBaseAdapter listAdapter;
	private ListView list;
	private List<LanceItem> lanceItems;
	
	public Lances_Fragment(){
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fgmt_background, container,false);
		View custom = inflater.inflate(R.layout.lances_fgmt, null);


		((ViewGroup) rootView).addView(custom);
		
		return rootView;

	}


}
