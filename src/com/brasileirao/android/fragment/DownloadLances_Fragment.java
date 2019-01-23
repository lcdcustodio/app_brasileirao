package com.brasileirao.android.fragment;

import org.json.JSONObject;

import com.brasileirao.android.R;

import com.brasileirao.android.webservice.UserFunctions;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.app.AppCompatActivity;

public class DownloadLances_Fragment extends Fragment {


	public DownloadLances_Fragment(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.splash_fragment, container,
				false);

		new PrefetchData().execute();
		
		return rootView;

	}
	
	/*
	 * Async Task to make http call
	 */
	private class PrefetchData extends AsyncTask<Void, Void, JSONObject> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
	
		}
		
	
		@Override
		protected JSONObject doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			String sigla_host = getArguments().getString("sigla_host");
			String sigla_guest = getArguments().getString("sigla_guest");			
			
			JSONObject json_Obj = getLances(sigla_host, sigla_guest);
				
			
			return json_Obj;
		}
		
		@Override
		protected void onPostExecute(JSONObject result) {
			super.onPostExecute(result);
			
			Fragment fragment = new Lances_Fragment();
			Bundle args = new Bundle();
			String json_Obj =result.toString();
			args.putString("json_Obj", json_Obj);
			fragment.setArguments(args);
			
			android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
			fragmentTransaction.replace(R.id.frame_container, fragment);


			fragmentTransaction.commit();




		}
		
	}
	
	
	public JSONObject getLances(String sigla_host, String sigla_guest) {
		
	
    	UserFunctions userFunc = new UserFunctions();
		JSONObject json = userFunc.getLances(sigla_host, sigla_guest);

		return json;
		
	}


}