package com.example.digital_india_kids_education;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Number extends Activity {

	ImageView number_btn_writing;
	ImageView number_fill_in_blank;
	ImageView number_match_pair;
	ImageView number_find_similar;
	ImageView number_round_similar;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number);
		
		number_btn_writing=(ImageView)findViewById(R.id.number_btn_writing);
        number_fill_in_blank=(ImageView)findViewById(R.id.number_btn_fill_in_blank);
        number_match_pair=(ImageView)findViewById(R.id.number_btn_match_pair);
        number_find_similar=(ImageView)findViewById(R.id.number_btn_find_similar);
        number_round_similar=(ImageView)findViewById(R.id.number_btn_round_similar);
        
        number_btn_writing.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Number.this,Number_writing.class);
				 startActivity(intent_eng);
			}
		});
        number_fill_in_blank.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Number.this,Number_fill_in_blank.class);
				 startActivity(intent_eng);
			}
		});
        number_match_pair.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Number.this,Number_match_pair.class);
				 startActivity(intent_eng);
			}
		});
        number_find_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Number.this,Number_find_similar.class);
				 startActivity(intent_eng);
			}
		});
        number_round_similar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent_eng = new Intent(Number.this,Number_round_similar.class);
				 startActivity(intent_eng);
			}
		});
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.number, menu);
		return true;
	}

}
