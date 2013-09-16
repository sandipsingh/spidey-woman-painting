package com.spidey.woman;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash extends Activity {
      MediaPlayer mp;
      public boolean count=false;
   //  public Button b1;
     RelativeLayout rl2;     
     private AdView ad;   
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {         
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);    
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home);
		rl2 = (RelativeLayout) findViewById(R.id.relative_home);      
	     String id = "a150250ae10b887";
		 ad = new AdView(this, AdSize.BANNER, id);   
		 rl2.addView(ad);
      	 ad.loadAd(new AdRequest());
		//  b1=(Button)findViewById(R.id.button1);  

		 ImageView more_apps=(ImageView)findViewById(R.id.imageView2);                   
		ImageView b2=(ImageView)findViewById(R.id.image_start);
		ImageView b3=(ImageView)findViewById(R.id.image_feedback);
		ImageView b4=(ImageView)findViewById(R.id.imageView1);
		//more_apps.setVisibility(View.INVISIBLE);
		
		more_apps.setOnClickListener(new OnClickListener() {
			
			             
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=kewl+apps");
				 Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
				 startActivity(intent); 

			}             
		});   
		
       b2.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  
				Splash.this.startActivity(new Intent(Splash.this,ColorActivity.class));
			}
		});
       
       b4.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Splash.this.startActivity(new Intent(Splash.this,ViewImages.class));
			}
		});
       
       b3.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i1 = new Intent(android.content.Intent.ACTION_SEND); 
					                                        
					
				         i1.setType("text/plain"); 
				         i1.putExtra(android.content.Intent.EXTRA_EMAIL  , new String[]{"info@avigma.com"} );
				         i1.putExtra(android.content.Intent.EXTRA_SUBJECT, "Send feedback of Spidey woman Painting");
				         i1.putExtra(android.content.Intent.EXTRA_TEXT   ,""); 
				        
				         startActivity(i1);

			}                 
		});    
	}


}        
