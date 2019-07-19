package com.vj.game;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameFinish extends Activity {
	ImageView iv;
	TextView tv,tv1,tv2;
	Images im;
   int n,check;
    static int score=0;
	Button high,low,change;
	SQLiteDatabase db;
	EditText name;
	String pname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setTitle("GAME FINISHED ");
		setContentView(R.layout.start);
		n=Start.n;
		score=Game.score;
		tv=(TextView)findViewById(R.id.TextView01);
		tv1=(TextView)findViewById(R.id.score2);
		tv2=(TextView)findViewById(R.id.TextView03);
		iv=(ImageView)findViewById(R.id.ImageView01);
		high=(Button)findViewById(R.id.high);
		low=(Button)findViewById(R.id.low);
		change=(Button)findViewById(R.id.changenum);
		name=(EditText)findViewById(R.id.pname);
		tv.append(Integer.toString(n));
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
	     
		tv1.append(Integer.toString(score));
		tv2.setText("Name");
		System.out.println("***********in Game finish************");
		name.setVisibility(View.VISIBLE);
		System.out.println("***********in Game finish************");
		high.setText("Save");
		change.setText("Go to Main");
		low.setText("Play Again");
		high.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("*******in click****************");
				 pname=name.getText().toString(); 
				 //String hs=new String(pname + ","+ score);
				System.out.println("***********************"+pname);
				db=openOrCreateDatabase("gamecard", MODE_PRIVATE, null);
				db.execSQL("CREATE TABLE IF NOT EXISTS highscore (name varchar , score integer)");
				db.execSQL("INSERT INTO highscore  VALUES ('"+pname+"','"+score+"')");
				Toast.makeText(getApplicationContext(), "scores addede",100).show();
				
				db.close();
				name.setVisibility(View.INVISIBLE);
				tv.setVisibility(View.INVISIBLE);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				iv.setVisibility(View.INVISIBLE);  
				Game.score=0;
				
			}
			
		});
		
		low.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it123=new Intent(GameFinish.this,Start. class);
				
				startActivity(it123);
				
			}
			
		});
		change.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(GameFinish.this,Game.class);
				startActivity(it);
			}
			
		});
		
	}

}
