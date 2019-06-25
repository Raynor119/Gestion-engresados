package com.pixels.Gestion;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.support.v7.app.AlertDialog;
import android.view.*;

public class engre extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_engre);
	
	}
	
	public void perfi(View v){
		Intent intent=new Intent(engre.this,perfil.class);
		//bs.mot(uss,"2");
		startActivity(intent);
		
	}
	
}
