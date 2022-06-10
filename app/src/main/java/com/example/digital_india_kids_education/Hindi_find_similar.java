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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Hindi_find_similar extends Activity implements OnClickListener{
	private pad drawView;
	//buttons
	private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
	//sizes
	private float smallBrush, mediumBrush, largeBrush;
	ImageButton hindi_find_similar_next;
	ImageButton hindi_find_similar_prv;
	ImageView hindi_find_similar_char_img;
	ImageView hindi_find_similar_pic_img;
	ImageView hindi_find_similar_word_img;
	int count;
	int op;
	int bg;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hindi_find_similar);
		hindi_find_similar_next =(ImageButton) findViewById(R.id.hindi_find_similar_next);
		hindi_find_similar_prv =(ImageButton) findViewById(R.id.hindi_find_similar_prv);
		
		hindi_find_similar_char_img =(ImageView) findViewById(R.id.hindi_find_similar_char_img);
		hindi_find_similar_pic_img =(ImageView) findViewById(R.id.hindi_find_similar_pic_img);
		hindi_find_similar_word_img =(ImageView) findViewById(R.id.hindi_find_similar_word_img);
		drawView = (pad)findViewById(R.id.hindi_find_similar_drawing);
		count=1;
		op=1; // op=1 cap op=2 small op=3 combination
		bg=0;// bg=0 show bg=1 dont show
		InputStream ims;
		try {
			ims = this.getResources().getAssets().open("hindi_data/marathi_cahr/char/1.png");
			Drawable d = Drawable.createFromStream(ims, null);
			hindi_find_similar_char_img.setImageDrawable(d);
		
			ims = this.getResources().getAssets().open("hindi_data/marathi_cahr/pic/1.png");
			d = Drawable.createFromStream(ims, null);
			hindi_find_similar_pic_img.setImageDrawable(d);
		
			ims = this.getResources().getAssets().open("hindi_data/marathi_cahr/words/1.png");
			d = Drawable.createFromStream(ims, null);
			hindi_find_similar_word_img.setImageDrawable(d);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
		hindi_find_similar_next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				count++;
				if(count>48)
					count=1;
				try{
					
					InputStream ims;
				 String file_name="";
				 file_name="hindi_data/marathi_cahr/char/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				//ims= getAssets().open(fileName)
				Drawable d = Drawable.createFromStream(ims, null);
				hindi_find_similar_char_img.setImageDrawable(d);
				
				file_name="hindi_data/marathi_cahr/pic/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				hindi_find_similar_pic_img.setImageDrawable(d);
			
				file_name="hindi_data/marathi_cahr/words/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				hindi_find_similar_word_img.setImageDrawable(d);
				
				file_name="hindi_data/hindi_find_similar/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				Drawable img_bg1 = Drawable.createFromStream(ims, null);
				drawView.startNew();
				drawView.setbackground(img_bg1);
				
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
		});
		hindi_find_similar_prv.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				count--;
				if(count<1)
					count=48;
				try{
					
				
				InputStream ims;
				 String file_name="";
				 file_name="hindi_data/marathi_cahr/char/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				//ims= getAssets().open(fileName)
				Drawable d = Drawable.createFromStream(ims, null);
				hindi_find_similar_char_img.setImageDrawable(d);
				
				file_name="hindi_data/marathi_cahr/pic/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				hindi_find_similar_pic_img.setImageDrawable(d);
			
				file_name="hindi_data/marathi_cahr/words/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				d = Drawable.createFromStream(ims, null);
				hindi_find_similar_word_img.setImageDrawable(d);
				
				file_name="hindi_data/hindi_find_similar/"+ String.valueOf(count) +".png" ;
				ims = getAssets().open(file_name);
				Drawable img_bg = Drawable.createFromStream(ims, null);
				
				drawView.startNew();
				drawView.setbackground(img_bg);
				
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		drawView = (pad)findViewById(R.id.hindi_find_similar_drawing);
		//get the palette and first color button
				LinearLayout paintLayout = (LinearLayout)findViewById(R.id.hindi_find_similar_paint_colors);
				currPaint = (ImageButton)paintLayout.getChildAt(0);
				currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

				//sizes from dimensions
				smallBrush = getResources().getInteger(R.integer.small_size);
				mediumBrush = getResources().getInteger(R.integer.medium_size);
				largeBrush = getResources().getInteger(R.integer.large_size);

				//draw button
				drawBtn = (ImageButton)findViewById(R.id.hindi_find_similar_draw_btn);
				drawBtn.setOnClickListener(this);

				//set initial size
				drawView.setBrushSize(mediumBrush);

				//erase button
				eraseBtn = (ImageButton)findViewById(R.id.hindi_find_similar_erase_btn);
				eraseBtn.setOnClickListener(this);



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
		getMenuInflater().inflate(R.menu.hindi_find_similar, menu);
		drawView = (pad)findViewById(R.id.hindi_find_similar_drawing);

		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId()==R.id.hindi_find_similar_draw_btn){
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
		else if(view.getId()==R.id.hindi_find_similar_erase_btn){
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
