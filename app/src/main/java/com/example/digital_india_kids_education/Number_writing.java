package com.example.digital_india_kids_education;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Number_writing extends Activity implements OnClickListener {

	private pad drawView;
	//buttons
	private ImageButton currPaint, drawBtn, eraseBtn;
	//sizes
	private float smallBrush, mediumBrush, largeBrush;

	ImageButton number_writing_next;
	ImageButton number_writing_prv;

	ImageView number_writing_number;
	ImageView number_writing_word;
	int count;
	int op;
	int bg;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number_writing);
		number_writing_next =(ImageButton) findViewById(R.id.number_writing_next);
		number_writing_prv =(ImageButton) findViewById(R.id.number_writing_prv);


		number_writing_number =(ImageView) findViewById(R.id.number_writing_number);
		number_writing_word =(ImageView) findViewById(R.id.number_writing_word);
		
		count=1;
		op=1; // op=1 cap op=2 small op=3 combination
		bg=0;// bg=0 show bg=1 dont show

		drawView = (pad)findViewById(R.id.number_writing_drawing);
		LinearLayout paintLayout = (LinearLayout)findViewById(R.id.number_writing_paint_colors);
		currPaint = (ImageButton)paintLayout.getChildAt(0);
		currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
		smallBrush = getResources().getInteger(R.integer.small_size);
		mediumBrush = getResources().getInteger(R.integer.medium_size);
		largeBrush = getResources().getInteger(R.integer.large_size);
		drawBtn = (ImageButton)findViewById(R.id.number_writing_draw_btn);
		drawBtn.setOnClickListener(this);
		drawView.setBrushSize(mediumBrush);
		eraseBtn = (ImageButton)findViewById(R.id.number_writing_erase_btn);
		eraseBtn.setOnClickListener(this);


		count=0;
		op=1; // op=1 cap op=2 small op=3 combination
		bg=0;// bg=0 show bg=1 dont show
		InputStream ims;
		try {
			ims = this.getResources().getAssets().open("number_data/number/num/0.png");
			Drawable d = Drawable.createFromStream(ims, null);
			number_writing_number.setImageDrawable(d);

			ims = this.getResources().getAssets().open("number_data/number/word/0.png");
			d = Drawable.createFromStream(ims, null);
			number_writing_word.setImageDrawable(d);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		number_writing_next.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				count++;
				if(count>100)
					count=0;
				try{




					InputStream tt=getAssets().open("number_data/number_background/png/"+ String.valueOf(count) +".png");
					Drawable img_bg =Drawable.createFromStream(tt, null);

					InputStream ims;
					String file_name="";
					file_name="number_data/number/num/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					//ims= getAssets().open(fileName)
					Drawable d = Drawable.createFromStream(ims, null);
					number_writing_number.setImageDrawable(d);

					file_name="number_data/number/word/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					d = Drawable.createFromStream(ims, null);
					number_writing_word.setImageDrawable(d);




					if(bg==0){
						drawView.startNew();
						drawView.setbackground(img_bg);
					}
					if(bg==1){
						drawView.startNew();
						ims = getAssets().open("english_data/background_char/blank.png");
						img_bg = Drawable.createFromStream(ims, null);
						drawView.setbackground(img_bg);
					}

				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		number_writing_prv.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				count--;
				if(count<0)
					count=100;
				try{

					InputStream tt=getAssets().open("number_data/number_background/png/"+ String.valueOf(count) +".png");
					Drawable img_bg =Drawable.createFromStream(tt, null);

					InputStream ims;
					String file_name="";
					file_name="number_data/number/num/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					//ims= getAssets().open(fileName)
					Drawable d = Drawable.createFromStream(ims, null);
					number_writing_number.setImageDrawable(d);

					file_name="number_data/number/word/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					d = Drawable.createFromStream(ims, null);
					number_writing_word.setImageDrawable(d);

					if(bg==0){
						drawView.startNew();
						drawView.setbackground(img_bg);
					}
					if(bg==1){
						drawView.startNew();
						ims = getAssets().open("english_data/background_char/blank.png");
						img_bg = Drawable.createFromStream(ims, null);
						drawView.setbackground(img_bg);
					}

				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
	public void paintClicked(View view){
		//use chosen color

		//set erase false
		drawView.setErase(false);
		drawView.setBrushSize(drawView.getLastBrushSize());

		if(view!=currPaint){
			ImageButton imgView = (ImageButton)view;
			String color = view.getTag().toString();
			drawView.setColor(color);
			//update ui
			imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
			currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
			currPaint=(ImageButton)view;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.number_writing, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId())
		{
		case R.id.number_writing_action_show_bg:
				if(bg==0)
					bg=1;
				else
					bg=0;
			return true;
		}
		return true;
	}
	
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId()==R.id.number_writing_draw_btn){
			//draw button clicked
			final Dialog brushDialog = new Dialog(this);
			brushDialog.setTitle("Brush size:");
			brushDialog.setContentView(R.layout.activity_brush_chooser);
			//listen for clicks on size buttons
			ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
			smallBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(smallBrush);
					drawView.setLastBrushSize(smallBrush);
					brushDialog.dismiss();
				}
			});
			ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
			mediumBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(mediumBrush);
					drawView.setLastBrushSize(mediumBrush);
					brushDialog.dismiss();
				}
			});
			ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
			largeBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(false);
					drawView.setBrushSize(largeBrush);
					drawView.setLastBrushSize(largeBrush);
					brushDialog.dismiss();
				}
			});
			//show and wait for user interaction
			brushDialog.show();
		}
		else if(view.getId()==R.id.number_writing_erase_btn){
			//switch to erase - choose size
			final Dialog brushDialog = new Dialog(this);
			brushDialog.setTitle("Eraser size:");
			brushDialog.setContentView(R.layout.activity_brush_chooser);
			//size buttons
			ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
			smallBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(smallBrush);
					brushDialog.dismiss();
				}
			});
			ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
			mediumBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(mediumBrush);
					brushDialog.dismiss();
				}
			});
			ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
			largeBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					drawView.setErase(true);
					drawView.setBrushSize(largeBrush);
					brushDialog.dismiss();
				}
			});
			brushDialog.show();
		}


	}

}
