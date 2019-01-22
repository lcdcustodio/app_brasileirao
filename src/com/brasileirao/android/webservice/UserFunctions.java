package com.brasileirao.android.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.util.Log;

public class UserFunctions {

    private JSONParser jsonParser;

    private static String brasileiraoURL = "http://ec2-52-90-92-199.compute-1.amazonaws.com/xmiles/login/";
    
    private static String jogos_tag = "jogos";
    private static String lances_tag = "lances";

    // constructor
    public UserFunctions(){

    	jsonParser = new JSONParser();
        
    }


    public JSONObject getJogos(){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", jogos_tag));
        JSONObject json = jsonParser.getJSONFromUrl(brasileiraoURL, params);
        return json;
    }
    
    public JSONObject getLances(String sigla_host, String sigla_guest){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", lances_tag));
        params.add(new BasicNameValuePair("sigla_host", sigla_host));
        params.add(new BasicNameValuePair("sigla_guest", sigla_guest));
        JSONObject json = jsonParser.getJSONFromUrl(brasileiraoURL, params);
        return json;
    }
    

}