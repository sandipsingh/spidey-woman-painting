package com.spidey.woman;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NoImage extends Activity
{
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.no_image);
		
		TextView txt = (TextView) findViewById(R.id.textView1);  
		Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");  
		txt.setTypeface(font); 
		
		Button btn=(Button) findViewById(R.id.button1);
		btn.setTypeface(font);
		btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Splash.class);
				startActivity(i);
			}
			
		});
	}
}
