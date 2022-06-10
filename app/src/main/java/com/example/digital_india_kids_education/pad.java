package com.example.digital_india_kids_education;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
public class pad extends View{

	//drawing path
		private Path drawPath;
		//drawing and canvas paint
		private Paint drawPaint, canvasPaint;
		//initial color
		private int paintColor = 0xFF660000;
		//canvas
		private Canvas drawCanvas;
		//canvas bitmap
		private Bitmap canvasBitmap;
		//brush sizes
		private float brushSize, lastBrushSize;
		//erase flag
		private boolean erase=false;

		
	public pad(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupDrawing();
		// TODO Auto-generated constructor stub
	}
	private void setupDrawing(){

		//prepare for drawing and setup paint stroke properties
		brushSize = getResources().getInteger(R.integer.medium_size);
		lastBrushSize = brushSize;
		drawPath = new Path();
		drawPaint = new Paint();
		drawPaint.setColor(paintColor);
		drawPaint.setAntiAlias(true);
		drawPaint.setStrokeWidth(brushSize);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
		canvasPaint = new Paint(Paint.DITHER_FLAG);
	}
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		
		//Drawable md = getResources().getDrawable(R.drawable.a);
		//Bitmap myLogo = ((BitmapDrawable) md).getBitmap();
		
		//canvasBitmap = Bitmap.createBitmap(myLogo);
		drawCanvas = new Canvas(canvasBitmap);
	}

	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
		canvas.drawPath(drawPath, drawPaint);
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		float touchX = event.getX();
		float touchY = event.getY();
		//respond to down, move and up events
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			drawPath.moveTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_MOVE:
			drawPath.lineTo(touchX, touchY);
			break;
		case MotionEvent.ACTION_UP:
			drawPath.lineTo(touchX, touchY);
			drawCanvas.drawPath(drawPath, drawPaint);
			drawPath.reset();
			break;
		default:
			return false;
		}
		//redraw
		invalidate();
		return true;

	}
	//update color
		public void setColor(String newColor){
			invalidate();
			paintColor = Color.parseColor(newColor);
			drawPaint.setColor(paintColor);
		}

		//set brush size
		public void setBrushSize(float newSize){
			float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 
					newSize, getResources().getDisplayMetrics());
			brushSize=pixelAmount;
			drawPaint.setStrokeWidth(brushSize);
		}

		//get and set last brush size
		public void setLastBrushSize(float lastSize){
			lastBrushSize=lastSize;
		}
		public float getLastBrushSize(){
			return lastBrushSize;
		}

		//set erase true or false
		public void setErase(boolean isErase){
			erase=isErase;
			if(erase) drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
			else drawPaint.setXfermode(null);
		}

		//start new drawing
		public void startNew(){
			drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
			
			//Drawable md = getResources().getDrawable(R.drawable.a);
		    //	Bitmap myLogo = ((BitmapDrawable) md).getBitmap();
			//drawCanvas.drawBitmap(myLogo, 0, 0, canvasPaint);
			
			invalidate();
			
		}
		public void setbackground(Drawable bg){
			Bitmap myLogo = ((BitmapDrawable) bg).getBitmap();
			int w=300,h=300;
			float ww=600,hh=600;
			w=drawCanvas.getWidth();
			h=drawCanvas.getHeight();
			if(w>600)
			{
				w=w-600;
				ww=w/2;
			}
			if(h>600)
			{
				h=h-600;
				hh=h/2;
			}
			
			drawCanvas.drawBitmap(myLogo,ww, hh, canvasPaint);
			
			invalidate();
		}
		
		
		public void setbackground_400(Drawable bg){
			Bitmap myLogo = ((BitmapDrawable) bg).getBitmap();
			int w=400,h=100;
			float ww=300,hh=300;
			w=drawCanvas.getWidth();
			h=drawCanvas.getHeight();
			if(w>400)
			{
				w=w-400;
				ww=w/2;
			}
			if(h>100)
			{
				h=h-100;
				hh=h/2;
			}
			
			drawCanvas.drawBitmap(myLogo,ww, hh, canvasPaint);
			
			invalidate();
		}
}
