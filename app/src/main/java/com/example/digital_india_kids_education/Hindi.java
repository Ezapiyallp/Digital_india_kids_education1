package com.example.digital_india_kids_education;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Hindi extends Activity {

	ImageView hindi_btn_writing;
	ImageView hindi_btn_fill_in_black;
	ImageView hindi_btn_match_pair;
	ImageView hindi_btn_find_similar;
	ImageView hindi_btn_round_similar;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hindi);
	

	hindi_btn_writing =(ImageView)findViewById(R.id.hindi_btn_writing);
	hindi_btn_fill_in_black=(ImageView)findViewById(R.id.hindi_btn_fill_in_black);
	hindi_btn_match_pair=(ImageView)findViewById(R.id.hindi_btn_match_pair);
    hindi_btn_find_similar=(ImageView)findViewById(R.id.hindi_btn_find_similar);
	hindi_btn_round_similar=(ImageView)findViewById(R.id.hindi_btn_round_similar);
     
    
    hindi_btn_writing.setOnClickListener(new View.OnClickListener() {
	     public void onClick(View arg0) {
	    	 Intent intent_eng = new Intent(Hindi.this,Hindi_writing.class);
			 startActivity(intent_eng);
	  	     }
     	});
    hindi_btn_fill_in_black.setOnClickListener(new View.OnClickListener() {
	     public void onClick(View arg0) {
	    	 Intent intent_eng = new Intent(Hindi.this,Hindi_fill_in_black.class);
			 startActivity(intent_eng);
	  	     }
    	});
    hindi_btn_match_pair.setOnClickListener(new View.OnClickListener() {
	     public void onClick(View arg0) {
	    	 Intent intent_eng = new Intent(Hindi.this,Hindi_match_pair.class);
			 startActivity(intent_eng);
	  	     }
    	});
    hindi_btn_find_similar.setOnClickListener(new View.OnClickListener() {
	     public void onClick(View arg0) {
	    	 Intent intent_eng = new Intent(Hindi.this,Hindi_find_similar.class);
			 startActivity(intent_eng);
	  	     }
    	});
    hindi_btn_round_similar.setOnClickListener(new View.OnClickListener() {
	     public void onClick(View arg0) {
	    	 Intent intent_eng = new Intent(Hindi.this,Hindi_round_similar.class);
			 startActivity(intent_eng);
	  	     }
   	});
   
    
    
    
    
    
    
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hindi, menu);
		return true;
	}

}
