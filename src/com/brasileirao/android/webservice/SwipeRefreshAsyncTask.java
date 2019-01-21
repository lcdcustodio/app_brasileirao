package com.brasileirao.android.webservice;

import org.json.JSONObject;
import android.os.AsyncTask;



public class SwipeRefreshAsyncTask extends AsyncTask<String, Void, JSONObject> {
    

	
	
	@Override
    protected JSONObject doInBackground(String... params) {

		JSONObject json_Obj = GET();
		
		
		return json_Obj;
        
    }
	// onPostExecute displays the results of the AsyncTask.	
    @Override
    protected void onPostExecute(JSONObject result) {    	

    	
    
   }

    
    public static JSONObject GET(){
		
		JSONObject result = null;
						
    	UserFunctions userFunction = new UserFunctions();
    	result = userFunction.getJogos();
		
		return result;
	} 
    
}