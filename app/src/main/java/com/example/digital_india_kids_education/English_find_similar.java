package com.example.digital_india_kids_education;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class English_find_similar extends Activity implements OnClickListener{

	private pad drawView;
	//buttons
	private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
	//sizes
	private float smallBrush, mediumBrush, largeBrush;

	ImageButton english_find_similar_next;
	ImageButton english_find_similar_prv;
	ImageView english_find_similar_capital_char_img;
	ImageView english_find_similar_pic_img;
	ImageView english_find_similar_small_char_img;
	int count;
	int op;
	int bg;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_english_find_similar);
		
		english_find_similar_next =(ImageButton) findViewById(R.id.english_find_similar_next);
		english_find_similar_prv =(ImageButton) findViewById(R.id.english_find_similar_prv);
		
		english_find_similar_capital_char_img =(ImageView) findViewById(R.id.english_find_similar_capital_char_img);
		english_find_similar_pic_img =(ImageView) findViewById(R.id.english_find_similar_pic_img);
		english_find_similar_small_char_img =(ImageView) findViewById(R.id.english_find_similar_small_char_img);
		drawView = (pad)findViewById(R.id.english_find_similar_drawing);
		count=1;
		op=1; // op=1 cap op=2 small op=3 combination
		bg=0;// bg=0 show bg=1 dont show
		InputStream ims;
		try {
			ims = this.getResources().getAssets().open("english_data/char/capital/1.png");
			Drawable d = Drawable.createFromStream(ims, null);
			english_find_similar_capital_char_img.setImageDrawable(d);
		
			ims = this.getResources().getAssets().open("english_data/char/small/1.png");
			d = Drawable.createFromStream(ims, null);
			english_find_similar_pic_img.setImageDrawable(d);
		
			ims = this.getResources().getAssets().open("english_data/char/pic/1.png");
			d = Drawable.createFromStream(ims, null);
			english_find_similar_small_char_img.setImageDrawable(d);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		english_find_similar_next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				count++;
				if(count>26)
				count=1;
				try{
					InputStream tt=getAssets().open("english_data/background_char/blank.png");
					Drawable img_bg =Drawable.createFromStream(tt, null);
				
				InputStream ims;
				 String file_name="";
				 file_name="english_data/char/capital/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				//ims= getAssets().open(fileName)
				Drawable d = Drawable.createFromStream(ims, null);
				english_find_similar_capital_char_img.setImageDrawable(d);
				
				file_name="english_data/char/small/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				english_find_similar_small_char_img.setImageDrawable(d);
			
				file_name="english_data/char/pic/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				english_find_similar_pic_img.setImageDrawable(d);
				//drawView.startNew();

					/*file_name="english_data/similar_round/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					Drawable img_bg1 = Drawable.createFromStream(ims, null);
					drawView.startNew();
					drawView.setbackground(img_bg1);*/


				if(op==1){
					//background_char capital
					file_name="english_data/similar_round/capital/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					img_bg = Drawable.createFromStream(ims, null);
					drawView.startNew();
					drawView.setbackground(img_bg);
					english_find_similar_small_char_img.setVisibility(View.INVISIBLE);
					english_find_similar_capital_char_img.setVisibility(View.VISIBLE);
					
				}
				if(op==2){
					//background_char capital
					file_name="english_data/similar_round/small/"+ String.valueOf(count) +".png" ;
					ims = getAssets().open(file_name);
					img_bg = Drawable.createFromStream(ims, null);
					drawView.startNew();
					drawView.setbackground(img_bg);
					english_find_similar_small_char_img.setVisibility(View.VISIBLE);
					english_find_similar_capital_char_img.setVisibility(View.INVISIBLE);
				}
				
		
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
		english_find_similar_prv.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				count--;
				if(count<1)
				count=26;
				try{
					InputStream tt=getAssets().open("english_data/background_char/blank.png");
					Drawable img_bg =Drawable.createFromStream(tt, null);
				
				InputStream ims;
				 String file_name="";
				 file_name="english_data/char/capital/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				//ims= getAssets().open(fileName)
				Drawable d = Drawable.createFromStream(ims, null);
				english_find_similar_capital_char_img.setImageDrawable(d);
				
				file_name="english_data/char/small/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				english_find_similar_small_char_img.setImageDrawable(d);
			
				file_name="english_data/char/pic/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				english_find_similar_pic_img.setImageDrawable(d);
				drawView.startNew();

					if(op==1){
						//background_char capital
						file_name="english_data/similar_round/capital/"+ String.valueOf(count) +".png" ;
						ims = getAssets().open(file_name);
						img_bg = Drawable.createFromStream(ims, null);
						drawView.startNew();
						drawView.setbackground(img_bg);
						english_find_similar_small_char_img.setVisibility(View.INVISIBLE);
						english_find_similar_capital_char_img.setVisibility(View.VISIBLE);

					}
					if(op==2){
						//background_char capital
						file_name="english_data/similar_round/small/"+ String.valueOf(count) +".png" ;
						ims = getAssets().open(file_name);
						img_bg = Drawable.createFromStream(ims, null);
						drawView.startNew();
						drawView.setbackground(img_bg);
						english_find_similar_small_char_img.setVisibility(View.VISIBLE);
						english_find_similar_capital_char_img.setVisibility(View.INVISIBLE);
					}
				
		
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		

		
		//get the palette and first color button
				LinearLayout paintLayout = (LinearLayout)findViewById(R.id.english_find_similar_paint_colors);
				currPaint = (ImageButton)paintLayout.getChildAt(0);
				currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

				//sizes from dimensions
				smallBrush = getResources().getInteger(R.integer.small_size);
				mediumBrush = getResources().getInteger(R.integer.medium_size);
				largeBrush = getResources().getInteger(R.integer.large_size);

				//draw button
				drawBtn = (ImageButton)findViewById(R.id.english_find_similar_draw_btn);
				drawBtn.setOnClickListener(this);

				//set initial size
				drawView.setBrushSize(mediumBrush);

				//erase button
				eraseBtn = (ImageButton)findViewById(R.id.english_find_similar_erase_btn);
				eraseBtn.setOnClickListener(this);

				//new button


				
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
	public boolean onOptionsItemSelected(MenuItem item) {
			switch(item.getItemId())
		{
		case R.id.english_find_similar_action_capital:
			op=1;
			return true;
		case R.id.english_find_similar_action_small:
			op=2;
			return true;

		}
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.english_find_similar, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId()==R.id.english_find_similar_draw_btn){
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
		else if(view.getId()==R.id.english_find_similar_erase_btn){
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
