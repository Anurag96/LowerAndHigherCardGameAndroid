package com.vj.game;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HighScore  extends Activity{
 TextView name,score;
 SQLiteDatabase db;
 String s="",s1="";
 String[] scores;
 Button back;
 int score0,score1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscores);
		name=(TextView)findViewById(R.id.name);
		score=(TextView)findViewById(R.id.score);
		back=(Button)findViewById(R.id.back);
		 try {
			retrivehighscores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(HighScore.this,Game.class);
				startActivity(it);
			}
			
		});
		
	}

	String[] retrivehighscores() throws Exception {
		// TODO Auto-generated method stub
		db=openOrCreateDatabase("gamecard", MODE_PRIVATE, null);
		Cursor c=db.rawQuery("SELECT * FROM  highscore  where score>=5 order by score desc LIMIT 5",null);
	 
		System.out.println("&&&&&&&&&&&&&&&");
		c.moveToFirst();
		
		if(c!=null){
			do{
				int c1=c.getColumnIndex("name");
				s+=c.getString(c1)+"\n";
				int c2=c.getColumnIndex("score");
				s1+=c.getString(c2)+"\n";
				//Toast.makeText(getApplicationContext(), s1, 200).show();
				for(int i=0;i<s.length();i++){
					if(i==0){
				name.setText(s);
					}
					if(i!=0){
						name.setText(s);
							}
				}
				for(int i=0;i<s1.length();i++){
					if(i==0){
						score.setText(s1);
							}
							if(i!=0){
								score.setText(s1);
									}
					
					
					}
				
				
			}while(c.moveToNext());
			
			c.close();
			db.close();
			 System.out.println("after retrieving"+scores);
			
		}
		return scores;
		
	}

	

}
