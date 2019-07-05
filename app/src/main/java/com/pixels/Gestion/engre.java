package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class engre extends AppCompatActivity
{


    String user,cont;

	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_engre);
		Bundle extra = getIntent().getExtras();
		user=extra.getString("Usuario");
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.toolbar);

        Button bton=findViewById(R.id.peri);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				Intent intent=new Intent(engre.this,perfil.class);
				intent.putExtra("Usuario",user);
				startActivity(intent);
            }
        });




	
	}

	
	public void hojav(View v){
		Intent intent=new Intent(engre.this,menuhah.class);
		intent.putExtra("Usuario",user);
		startActivity(intent);

	}

	
}
