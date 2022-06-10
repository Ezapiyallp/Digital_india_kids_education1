package com.example.digital_india_kids_education;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Main_option extends Activity {

	ImageView main_option_eng_btn;
	ImageView main_option_hindi_btn;
	ImageView main_option_number_btn;
	ImageView main_option_gk_btn;
	ImageView main_option_admin_btn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_option);
		main_option_eng_btn =(ImageView) findViewById(R.id.main_option_eng_btn);
		main_option_hindi_btn =(ImageView) findViewById(R.id.main_option_hindi_btn);
		main_option_number_btn =(ImageView) findViewById(R.id.main_option_number_btn);
		main_option_gk_btn =(ImageView) findViewById(R.id.main_option_gk_btn);
		main_option_admin_btn =(ImageView) findViewById(R.id.main_option_admin_btn);
		
		 	main_option_eng_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent intent_eng = new Intent(Main_option.this,English.class);
					 startActivity(intent_eng);
				}
			});
			
			main_option_hindi_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					 Intent intent_eng = new Intent(Main_option.this,Hindi.class);
					 startActivity(intent_eng);
				}
			});

			main_option_number_btn.setOnClickListener(new View.OnClickListener() {
	
	@Override
				public void onClick(View v) {
		 Intent intent_eng = new Intent(Main_option.this,Number.class);
		 startActivity(intent_eng);
		
				}
			});

			main_option_gk_btn.setOnClickListener(new View.OnClickListener() {
	
	@Override
				public void onClick(View v) {
					Intent intent_eng = new Intent(Main_option.this,Gk.class);
					startActivity(intent_eng);
				}
			});

			main_option_admin_btn.setOnClickListener(new View.OnClickListener() {
	
	@Override
				public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent_eng = new Intent(Main_option.this,Admin.class);
		startActivity(intent_eng);
				}
			});	


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_option, menu);
		return true;
	}

}
