package com.brasileirao.android;


import com.brasileirao.android.fragment.Splash_Fragment;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;


public class Welcome extends FragmentActivity {
	
		
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);

	      setContentView(R.layout.activity_extra);

	        //----hide action bar---
	        getActionBar().hide();


  	      android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
  	      android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
  	      fragmentTransaction.replace(R.id.frame_container, new Splash_Fragment());
  	      fragmentTransaction.commit();


	}
	  /*
	  @Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	      return true;
	  }
	  
	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	      switch (item.getItemId()) {
	            case android.R.id.home:

	            	finish();
	            	break;
	      }
	      return true;
	    }
	    */
}
