package com.brasileirao.android.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.NetworkImageView;
import com.brasileirao.android.Lances;
import com.brasileirao.android.R;
import com.brasileirao.android.listview.JogoItem;
import com.brasileirao.android.listview.JogosBaseAdapter;
import com.brasileirao.android.webservice.SwipeRefreshAsyncTask;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class Jogos_Fragment extends Fragment {

	private List<JogoItem> jogoItems;
	private JogosBaseAdapter listAdapter;
	private ListView list;
    SwipeRefreshLayout mSwipeRefreshLayout;
	
	public Jogos_Fragment(){}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fgmt_background, container,false);
		View custom = inflater.inflate(R.layout.jogos_fgmt, null);
		
		list  = (ListView) custom.findViewById(R.id.list);	
        mSwipeRefreshLayout = (SwipeRefreshLayout) custom.findViewById(R.id.swipeToRefresh);
        
		jogoItems = new ArrayList<JogoItem>();		
		listAdapter = new JogosBaseAdapter(getActivity(),jogoItems);
		
		
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                
            	list.setAdapter(null);
            	jogoItems.clear();
            	
    			try {
					parseJsonFeed(new SwipeRefreshAsyncTask().execute().get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
		
        
        list.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
            	
                TextView sigla_host = (TextView)view.findViewById(R.id.sigla_host);        
                TextView sigla_guest = (TextView)view.findViewById(R.id.sigla_guest);        

                String host = sigla_host.getText().toString();
                String guest = sigla_guest.getText().toString();
            	
  
                Intent intent = new Intent(getActivity(), Lances.class);

                intent.putExtra("sigla_host", host);
                intent.putExtra("sigla_guest", guest);

                startActivity(intent);

    			
                
                
            }
        });		
        
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

			    	JSONArray jogosArray = new JSONArray(response.getString("jogos"));
			

					for (int i = 0; i < jogosArray.length(); i++) {
						JSONObject jogosObj = (JSONObject) jogosArray.get(i);
							
						JogoItem item = new JogoItem();

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
