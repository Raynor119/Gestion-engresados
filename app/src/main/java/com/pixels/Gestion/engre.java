package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class engre extends AppCompatActivity
{
	String user,cont;
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_engre);
		Bundle extra = getIntent().getExtras();
		user=extra.getString("Usuario");
		//Intent intent=new Intent(engre.this,menuha.class);

		//intent.putExtra("deci","1");
		//startActivity(intent);

	
	}
	
	public void perfi(View v){
		Intent intent=new Intent(engre.this,perfil.class);
		//bs.mot(uss,"2");
		intent.putExtra("Usuario",user);
		startActivity(intent);
		
	}
	
}
