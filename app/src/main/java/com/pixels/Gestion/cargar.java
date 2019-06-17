package com.pixels.Gestion;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.support.v7.app.AlertDialog;
public class cargar extends Activity
{
	public List<usurmm> promedioLista;
	String user,cont;
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_carga);
		Bundle extra = getIntent().getExtras();
		user=extra.getString("Usuario");
		cont=extra.getString("Contraseña");
		
		BasedeDatosU bas=new BasedeDatosU(getApplicationContext());
		usurmm busca=new usurmm();

		promedioLista=bas.obtusur();


		int i;
		int confu=0;
		int confc=0;
		int p=0;
		for(i=0;i<=promedioLista.size()-1;i++){
			String usurrr=promedioLista.get(i).getUsuario();
			if(usurrr.equals(user)){
				confu=1;
				p=i;
			}
			
		}
		if(confu==1){
			
			
				String conr=promedioLista.get(p).getContraseña();
				if(conr.equals(cont)){
					
					final baseI bs=new baseI(getApplicationContext());
					datt cc=new datt();
					final String uss=promedioLista.get(p).getUsuario();
					bs.buscu(cc,uss);
					String dat=cc.GetDato();
					
					if(dat.equals("1")){
						Intent intent=new Intent(cargar.this,engre.class);
						
						startActivity(intent);
						finish();
					}else{
					AlertDialog.Builder alert= new AlertDialog.Builder(cargar.this);
					
					alert.setMessage("Desea Registrar la Hoja de Vida")
						.setCancelable(false)
						.setPositiveButton("si", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,int which){
								Intent intent=new Intent(cargar.this,menuha.class);
									bs.mot(uss,"1");
								startActivity(intent);
								finish();


								
							}

						})
						.setNegativeButton("no", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,int which){
								Intent intent=new Intent(cargar.this,engre.class);
									bs.mot(uss,"1");
								startActivity(intent);
								finish();
								


								dialog.cancel();
							}

						});
                    AlertDialog titulo=alert.create();
                    titulo.setTitle("Alerta");
                    titulo.show();
					}
					
				}
				else{
					Toast.makeText(getApplicationContext(), "Contraseña incorrecta",Toast.LENGTH_LONG).show();
					Intent intent=new Intent(cargar.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
				

			
		}else{
			Toast.makeText(getApplicationContext(), "usurio no encontrdo",Toast.LENGTH_LONG).show();
			Intent intent=new Intent(cargar.this,MainActivity.class);
			startActivity(intent);
			finish();
		}
	}
}
