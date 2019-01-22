package com.brasileirao.android.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import com.brasileirao.android.listview.LancesBaseAdapter;

public class Lances_Fragment extends Fragment {

	private LancesBaseAdapter listAdapter;
	private ListView list;
	private List<LanceItem> lanceItems;
	
	public Lances_Fragment(){
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView2 = inflater.inflate(R.layout.fgmt_background, container,false);
		//View custom = inflater.inflate(R.layout.lances_item, null);
		View custom2 = inflater.inflate(R.layout.lances_fgmt, null);
		//*
		list  = (ListView) custom2.findViewById(R.id.list);
		
		lanceItems = new ArrayList<LanceItem>();		
		listAdapter = new LancesBaseAdapter(getActivity(),lanceItems);
		
		
		String lancesString = getArguments().getString("json_Obj");

		try {
			
			parseJsonFeed(new JSONObject(lancesString));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//*/
		((ViewGroup) rootView2).addView(custom2);
		
		return rootView2;

	}

	/**
	 * Parsing json reponse and passing the data to view list adapter
	 * */
	private void parseJsonFeed(JSONObject response) {
		try {

        	if (response.getString("success") != null) {

			    String res = response.getString("success");
			    if(Integer.parseInt(res) == 1){

			    	JSONArray lancesArray = new JSONArray(response.getString("lances"));
			

					for (int i = 0; i < lancesArray.length(); i++) {
						JSONObject jogosObj = (JSONObject) lancesArray.get(i);
							
						LanceItem item = new LanceItem();

						item.setSigla_host(jogosObj.getString("sigla_host"));
						item.setPlacar_host(jogosObj.getString("placar_host"));
						item.setPicurl_host(jogosObj.getString("picurl_host"));
						item.setPlacar_guest(jogosObj.getString("placar_guest"));
						item.setPicurl_guest(jogosObj.getString("picurl_guest"));
						item.setSigla_guest(jogosObj.getString("sigla_guest"));
						item.setEstadio(jogosObj.getString("estadio"));
						item.setStatus(jogosObj.getString("status"));
						item.setDia(jogosObj.getString("dia"));
						item.setHora(jogosObj.getString("hora"));	
						
						//-------------	
						String minutes = jogosObj.isNull("minutes") ? null : jogosObj
								.getString("minutes");								
						
						item.setMinutes(minutes);
						//-------------						
						item.setExtra_info(jogosObj.getString("extra_info"));
						//-------------	
						String text1 = jogosObj.isNull("text1") ? null : jogosObj
								.getString("text1");								
						
						item.setText1(text1);
						//-------------						
						//item.setText1(jogosObj.getString("text1"));
						item.setText2(jogosObj.getString("text2"));						
						
						lanceItems.add(item);
						
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
