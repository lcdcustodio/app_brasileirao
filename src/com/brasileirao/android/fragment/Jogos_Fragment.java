package com.brasileirao.android.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.brasileirao.android.R;
import com.brasileirao.android.listview.JogoItem;
import com.brasileirao.android.listview.JogosBaseAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Jogos_Fragment extends Fragment {

	private List<JogoItem> jogoItems;
	private JogosBaseAdapter listAdapter;
	private ListView list;
	
	public Jogos_Fragment(){}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fgmt_background, container,false);
		View custom = inflater.inflate(R.layout.jogos_fgmt, null);

		getActivity().getActionBar().show();
		//getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		
		list  = (ListView) custom.findViewById(R.id.list);		
		jogoItems = new ArrayList<JogoItem>();		
		listAdapter = new JogosBaseAdapter(getActivity(),jogoItems);
		
		String jogosString = getArguments().getString("json_Obj");
		
		try {
			
			parseJsonFeed(new JSONObject(jogosString));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ViewGroup) rootView).addView(custom);
		
		return rootView;

	}

	/**
	 * Parsing json reponse and passing the data to view list adapter
	 * */
	private void parseJsonFeed(JSONObject response) {
		try {

        	if (response.getString("success") != null) {

			    String res = response.getString("success");
			    if(Integer.parseInt(res) == 1){

			    	//JSONArray jogosArray = new JSONArray(response.getString("ranking"));
			    	JSONArray jogosArray = new JSONArray(response.getString("jogos"));
			

					for (int i = 0; i < jogosArray.length(); i++) {
						JSONObject jogosObj = (JSONObject) jogosArray.get(i);
							
						JogoItem item = new JogoItem();
						

						item.setSigla_host(jogosObj.getString("sigla_host"));
						item.setPlacar_host(jogosObj.getString("placar_host"));
						item.setPicurl_host(jogosObj.getString("picurl_host"));
		
						jogoItems.add(item);
						
					}
			    }
        	}
			// notify data changes to list adapater
        	list.setAdapter(listAdapter);	
			listAdapter.notifyDataSetChanged();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
