package com.example.digital_india_kids_education;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class English extends Activity {

	ImageView eng_btn_writing;
	ImageView eng_btn_fill_in_blank;
	ImageView eng_btn_match_pair;
	ImageView eng_btn_find_similar;
	ImageView eng_btn_round_similar;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_english);
		
		 eng_btn_writing=(ImageView) findViewById(R.id.eng_btn_writing);
		 eng_btn_fill_in_blank=(ImageView)findViewById(R.id.eng_btn_fill_in_blank);
		 eng_btn_match_pair=(ImageView)findViewById(R.id.eng_btn_match_pair);
		 eng_btn_find_similar=(ImageView)findViewById(R.id.eng_btn_find_similar);
		 eng_btn_round_similar=(ImageView)findViewById(R.id.eng_btn_round_similar);
		
		eng_btn_writing.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(English.this,English_writing.class);
				 startActivity(intent_eng);
			}
		});
		eng_btn_fill_in_blank.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(English.this,English_fill_in_blank.class);
				 startActivity(intent_eng);
			}
		});
		eng_btn_match_pair.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Intent intent_eng = new Intent(English.this,English_match_pair.class);
				 startActivity(intent_eng);
			}
		});
		eng_btn_find_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Intent intent_eng = new Intent(English.this,English_find_similar.class);
				 startActivity(intent_eng);
			}
		});
		eng_btn_round_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {

				Intent intent_eng = new Intent(English.this,English_round_similar.class);
				 startActivity(intent_eng);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.english, menu);
		return true;
	}

}
