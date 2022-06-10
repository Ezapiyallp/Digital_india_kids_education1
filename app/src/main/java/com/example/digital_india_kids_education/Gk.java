package com.example.digital_india_kids_education;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Gk extends Activity {

	ImageView gk_btn_writing;
	ImageView gk_btn_fill_in_blank;
	ImageView gk_btn_match_pair;
	ImageView gk_btn_find_similar;
	ImageView gk_btn_round_similar;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gk);
		
	 gk_btn_writing=(ImageView)findViewById(R.id.gk_btn_writing);
	 gk_btn_fill_in_blank=(ImageView)findViewById(R.id.gk_btn_fill_in_blank);
	 gk_btn_match_pair=(ImageView)findViewById(R.id.gk_btn_match_pair);
	 gk_btn_find_similar=(ImageView)findViewById(R.id.gk_btn_find_similar);
	 gk_btn_round_similar=(ImageView)findViewById(R.id.gk_btn_round_similar);
	 
	 gk_btn_writing.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Gk.this,Gk_writing.class);
				 startActivity(intent_eng);
		}
	});
	 
	 gk_btn_fill_in_blank.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Gk.this,Gk_fill_in_blank.class);
				 startActivity(intent_eng);
		}
	});
	 gk_btn_match_pair.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Gk.this,Gk_match_pair.class);
				 startActivity(intent_eng);
		}
	});
	 gk_btn_find_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Gk.this,Gk_find_similar.class);
				 startActivity(intent_eng);
		}
	});
	 gk_btn_round_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Gk.this,Gk_round_similar.class);
				 startActivity(intent_eng);
		}
	});
	 
	 
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gk, menu);
		return true;
	}

}
