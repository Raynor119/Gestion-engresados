package com.pixels.Gestion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class cargar extends Activity
{
	public List<usurmm> promedioLista;
	public List<usurmm> usurr;
	String user,cont;
	InputStream is =null;
	String line=null;
	String result=null;
	String[] data;
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_carga);
		Bundle extra = getIntent().getExtras();
		user=extra.getString("Usuario");
		cont=extra.getString("Contraseña");
		
		//BasedeDatosU bas=new BasedeDatosU(getApplicationContext());
		usurmm busca=new usurmm();
		usurr=new ArrayList<>();
		ip c= new ip();
		String ipt=c.ip();
		datoss("http://192.168.0.7:80/AppAndroid/usulist.php");
		promedioLista=usurr;


		int i;
		int confu=0;
		int confc=0;
		int p=0;
		for(i=0;i<=promedioLista.size()-1;i++){
			Toast.makeText(getApplicationContext(), "entrorr",Toast.LENGTH_LONG).show();

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
					//String dat=cc.GetDato();
					String dat="0";
					if(dat.equals("1")|| dat.equals("2")){
						Intent intent=new Intent(cargar.this,engre.class);
						intent.putExtra("Usuario",uss);
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
									bs.mot(uss,"0");

									intent.putExtra("Usuario",uss);
									
								startActivity(intent);
								finish();


								
							}

						})
						.setNegativeButton("no", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,int which){
								Intent intent=new Intent(cargar.this,engre.class);
									bs.mot(uss,"2");
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



	public void datoss(String Url){
		try{
			URL url =new URL(Url);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			is=new BufferedInputStream(con.getInputStream());




		}catch (Exception e){
			Toast.makeText(getApplicationContext(), "error1",Toast.LENGTH_LONG).show();

			e.printStackTrace();
		}

		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(is));
			StringBuilder sb=new StringBuilder();
			while ((br.readLine()) != null){
				sb.append(line+"\n");

			}
			is.close();
			result=sb.toString();


		}catch (Exception e){
			Toast.makeText(getApplicationContext(), "error2",Toast.LENGTH_LONG).show();

			e.printStackTrace();
		}

		try{
			JSONArray js=new JSONArray(result);
			JSONObject jo=null;

			data=new String[js.length()];

			for(int i=0;i<js.length();i++){
				jo=js.getJSONObject(i);
				//data[i]=jo.getString();
				Toast.makeText(getApplicationContext(), "entrto",Toast.LENGTH_LONG).show();

				usurr.add(new usurmm(jo.getString("USUARIO"),jo.getString("CONTRASENA"),jo.getString("NOMBRE"),jo.getString("TIPO")));

			}

		}catch (Exception e){
			Toast.makeText(getApplicationContext(), "error3",Toast.LENGTH_LONG).show();

			e.printStackTrace();
		}




	}



}
