package com.brasileirao.android;


import com.brasileirao.android.fragment.DownloadLances_Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;


public class Lances extends AppCompatActivity {
	
		
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);

	      setContentView(R.layout.activity_extra);
	      
	      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	      getSupportActionBar().setDisplayShowHomeEnabled(true);
	      
	      try {

	    	    Intent intent = getIntent();

                String host = intent.getStringExtra("sigla_host");
                String guest = intent.getStringExtra("sigla_guest");
                
    	        Fragment fragment = new DownloadLances_Fragment();
    			Bundle args = new Bundle();

    			args.putString("sigla_host", host);
    			args.putString("sigla_guest", guest);
    			
    			fragment.setArguments(args);
    			
      	      android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
      	      android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
      	      fragmentTransaction.replace(R.id.frame_container, fragment);
      	      fragmentTransaction.commit();                

	    	} catch(Exception e) {
	    	    e.printStackTrace();
	    	}
	      



	}
	
	@Override
	public boolean onSupportNavigateUp() {
		

	    onBackPressed();

	    return true;
	}
}
