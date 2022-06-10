package com.example.digital_india_kids_education;

import java.io.IOException;
import java.io.InputStream;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	
	ImageView wellcome_screen;
	Button wellcome_start_btn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wellcome_screen =(ImageView) findViewById(R.id.wellcome_main_img);
		wellcome_start_btn =(Button) findViewById(R.id.wellcole_start_btn);
		
		
		 InputStream ims;
		try {
			ims = this.getResources().getAssets().open("project_img/wellcome_screen.png");
			Drawable d = Drawable.createFromStream(ims, null);
			wellcome_screen.setImageDrawable(d);
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		wellcome_start_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent_eng = new Intent(MainActivity.this,Main_option.class);
				 startActivity(intent_eng);
				 
			}
		}) ;
		    //mImage.setImageDrawable(d);
		    
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
