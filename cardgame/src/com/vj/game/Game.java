package com.vj.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Game extends Activity {
	Button start,exit,hscore;
	static int score=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("WELCOME TO HIGHER LOWER GAME");
        setContentView(R.layout.main);
        start=(Button)findViewById(R.id.Button01);
        hscore=(Button)findViewById(R.id.Button02);
        exit=(Button)findViewById(R.id.Button03);
        start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Game.this,Start.class);
				startActivity(it);
			}
        	
        });
        hscore.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Game.this,HighScore.class);
				startActivity(it);
			}
        	
        });
        exit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				moveTaskToBack(true);
			}
        	
        });
        
        
    }
}