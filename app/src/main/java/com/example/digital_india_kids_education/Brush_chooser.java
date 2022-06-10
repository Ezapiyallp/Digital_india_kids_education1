package com.example.digital_india_kids_education;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Brush_chooser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brush_chooser);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brush_chooser, menu);
		return true;
	}

}
