package com.pixels.Gestion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class cargar extends Activity
{
	public List<usurmm> promedioLista =new ArrayList<>();;
	public List<usurmm> usurr=new ArrayList<>();

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

		ip c= new ip();
		String ipt=c.ip();
		//datoss("http://192.168.0.7:80/AppAndroid/usulist.php");
		//usurr.add(new usurmm(jo.getString("USUARIO"),jo.getString("CONTRASENA"),jo.getString("NOMBRE"),jo.getString("TIPO")));
		///promedioLista=usurr;
		String Url="http://"+ipt+":80/AppAndroid/usulist.php";

		// sacar
		JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

			@Override
			public void onResponse(JSONArray response) {
				JSONObject jo = null;
				//Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
				for (int i = 0; i < response.length(); i++) {
					try {
						//Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
						jo = response.getJSONObject(i);
						promedioLista.add(new usurmm(jo.getString("USUARIO"), jo.getString("CONTRASENA"), jo.getString("NOMBRE"), jo.getString("TIPO")));
						promedioLista.get(i).getUsuario();
						//Toast.makeText(getApplicationContext(), promedioLista.get(i).getUsuario()+" :t",Toast.LENGTH_LONG).show();
						//String v=jo.getString("USUARIO");
						//Toast.makeText(getApplicationContext(), v,Toast.LENGTH_LONG).show();
					} catch (JSONException e) {
						Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

					}
				}



				int i;
				int confu=0;
				int confc=0;
				int p=0;

				for(i=0;i<promedioLista.size();i++){


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
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(getApplicationContext(), "errorConexion",Toast.LENGTH_LONG).show();

			}
		});
		RequestQueue requestQueue;
		requestQueue= Volley.newRequestQueue(this);
		requestQueue.add(jsonArrayRequest);



















	}






}
