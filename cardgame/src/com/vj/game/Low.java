package com.vj.game;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Low extends Activity {
	ImageView iv;
	TextView tv,tv1;
	Images im;
   int n,check;
 static int score;
	Button high,low,change;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setTitle("HIGHER CARD");
		setContentView(R.layout.start);
		n=Start.n;
		score=Game.score;
		//n=showRandomNum(1,13);
		tv=(TextView)findViewById(R.id.TextView01);
		tv1=(TextView)findViewById(R.id.score2);
		iv=(ImageView)findViewById(R.id.ImageView01);
		high=(Button)findViewById(R.id.high);
		low=(Button)findViewById(R.id.low);
		change=(Button)findViewById(R.id.changenum);
		change.setVisibility(View.INVISIBLE);
		tv.append(Integer.toString(n));
		tv1.append(Integer.toString(score));
		if(n==1){
			Drawable r=getResources().getDrawable(R.drawable.one);
			
			iv.setImageDrawable(r);
			}
			else if(n==2){
				Drawable r=getResources().getDrawable(R.drawable.two);
				
				iv.setImageDrawable(r);
			}
	        else if(n==3){
	        	Drawable r=getResources().getDrawable(R.drawable.three);
	    		
	    		iv.setImageDrawable(r);
			}
	        else if(n==4){
	        	Drawable r=getResources().getDrawable(R.drawable.four);
	    		
	    		iv.setImageDrawable(r);
			}
	       else if(n==5){
	    	   Drawable r=getResources().getDrawable(R.drawable.five);
	   		
	   		iv.setImageDrawable(r);
	       }
	     else if(n==6){
	    	 Drawable r=getResources().getDrawable(R.drawable.six);
	 		
	 		iv.setImageDrawable(r);
	     }
	     else if(n==7){
	    Drawable r=getResources().getDrawable(R.drawable.seven);
			
			iv.setImageDrawable(r);
	     }
			
	     else if(n==8){
	    	    Drawable r=getResources().getDrawable(R.drawable.eight);
	    			
	    			iv.setImageDrawable(r);
	    	     }
	     else if(n==9){
	    	    Drawable r=getResources().getDrawable(R.drawable.nine);
	    			
	    			iv.setImageDrawable(r);
	    	     }
	     else if(n==10){
	    	    Drawable r=getResources().getDrawable(R.drawable.ten);
	    			
	    			iv.setImageDrawable(r);
	    	     }
	     else if(n==11){
	    	    Drawable r=getResources().getDrawable(R.drawable.jacky);
	    			
	    			iv.setImageDrawable(r);
	    	     }
	     else if(n==12){
	    	    Drawable r=getResources().getDrawable(R.drawable.queen);
	    			
	    			iv.setImageDrawable(r);
	    	     }
	     else if(n==13){
	    	    Drawable r=getResources().getDrawable(R.drawable.king);
	    			
	    			iv.setImageDrawable(r);
	    	     }
		
		high.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				check=showRandomNum(1, 13);
				if(check>Start.n){
					Game.score=Game.score+5;
					MediaPlayer mp=MediaPlayer.create(Low.this, R.raw.aps);
					mp.start();
					Start.n=check;
					Intent it1=new Intent(Low.this,High.class);
					startActivity(it1);
					
				}
				else{
					n=check;
					Intent it=new Intent(Low.this,GameFinish.class);
					startActivity(it);
					Toast.makeText(getApplicationContext(), "wrong num", 100).show();
				}
			}
			
		});
		low.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				check=showRandomNum(1, 13);
				if(check<Start.n){
					Game.score=Game.score+5;
					MediaPlayer mp=MediaPlayer.create(Low.this, R.raw.aps);
					mp.start();
					Start.n=check;
					Intent it=new Intent(Low.this,Low.class);
					startActivity(it);
					
				}
				else{
					n=check;
					Intent it=new Intent(Low.this,GameFinish.class);
					startActivity(it);
					Toast.makeText(getApplicationContext(), "wrong num", 100).show();
				}
			}
			
		});
	}
	private int showRandomNum(int i, int j) {
		// TODO Auto-generated method stub
		Random rnum=new Random();
		rnum.setSeed(System.currentTimeMillis());
		if(i>j){
          throw new IllegalArgumentException("StartNo cannot exceed EndNo.");
        }
        long ran=(long)j-(long)i+1;
        long fraction=(long)(ran*rnum.nextDouble());
        int ranum=(int)(fraction+i);
		return ranum;
	}
}
      
