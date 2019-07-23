package com.pixels.Gestion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

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
	public void aplicaof(View v){
		Intent intent=new Intent(engre.this,buscaoferemple.class);
		intent.putExtra("Usuario",user);
		startActivity(intent);
	}
	public void aplicaofya(View v){
		Intent intent=new Intent(engre.this,usuofeapli.class);
		intent.putExtra("Usuario",user);
		startActivity(intent);
	}



	public void cerrarcesion(View v){

		basedeinicio ne=new basedeinicio(getApplicationContext());
		usa c=new usa();
		List<usa> usurr=new ArrayList<>();
		usurr=ne.obtusur();
		String usu=usurr.get(0).getUsuario();
		if(usu.equals("nada")){
			finish();
		}else {

			AlertDialog.Builder alert = new AlertDialog.Builder(engre.this);
			alert.setMessage("¿Quieres Cerrar Sesión?")

					.setCancelable(false)

					.setPositiveButton("si", new DialogInterface.OnClickListener() {

						@Override

						public void onClick(DialogInterface dialog, int which) {


							basedeinicio n = new basedeinicio(getApplicationContext());
							n.inic("1", "nada", "", "", "");


							Intent intent = new Intent(engre.this, MainActivity.class);


							startActivity(intent);


							finish();

						}


					})

					.setNegativeButton("no", new DialogInterface.OnClickListener() {

						@Override

						public void onClick(DialogInterface dialog, int which) {


							dialog.cancel();
							finish();
						}


					});

			AlertDialog titulo = alert.create();

			titulo.setTitle("Alerta");

			titulo.show();
		}
	}

	
}
