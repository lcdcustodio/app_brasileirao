package com.brasileirao.android;



import com.brasileirao.android.fragment.Splash_Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;


public class Welcome extends AppCompatActivity {
	
		
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);

	      setContentView(R.layout.activity_extra);

  	      android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
  	      android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
  	      fragmentTransaction.replace(R.id.frame_container, new Splash_Fragment());
  	      fragmentTransaction.commit();


	}
	
	@Override
	public boolean onSupportNavigateUp() {
		
	    onBackPressed();
		

	    return true;
	}
}
