package com.pixels.Gestion;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cargar extends Activity
{
	public List<usurmm> promedioLista =new ArrayList<>();;
	public List<usurmm> usurr=new ArrayList<>();
int p;
	String user,cont;
	String dat="0";
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
		final String ipt=c.ip();

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
				 p=0;

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

						//final baseI bs=new baseI(getApplicationContext());
						datt cc=new datt();
						final String uss=promedioLista.get(p).getUsuario();
						//bs.buscu(cc,uss);
						//String dat=cc.GetDato();
						String Ur="http://"+ipt+":80/AppAndroid/inicio_bdbuc.php?usuario="+uss;
						JsonArrayRequest jsonArray=new JsonArrayRequest(Ur, new Response.Listener<JSONArray>() {
							@Override
							public void onResponse(JSONArray response) {
								JSONObject j = null;

								for (int i = 0; i < response.length(); i++) {
									try {

										j = response.getJSONObject(i);
										//j.getString("DATO");
										dat=j.getString("DATO");

									} catch (JSONException e) {
										Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

									}

								}
									if(promedioLista.get(p).getTipo().equals("0")){




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
													String ur="http://"+ipt+":80/AppAndroid/inicio_bdmod.php";
													StringRequest st=new StringRequest(Request.Method.POST,ur,new Response.Listener<String>(){





														public void onResponse(String response){



														}



													},new Response.ErrorListener(){





														public void onErrorResponse(VolleyError error){

															Toast.makeText(getApplicationContext(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





														}




													}){

														protected Map<String, String> getParams() throws AuthFailureError {

															Map<String, String> parametros=new HashMap<String, String>();
															String usur=uss;

															parametros.put("usuario",usur);
															parametros.put("opcion","Usuario1");
															parametros.put("dato","2");

															return parametros;
														}
													};
													RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

													requestQueue.add(st);
													intent.putExtra("Usuario",uss);
													//intent.putExtra("deci","0");

													startActivity(intent);
													finish();



												}

											})
											.setNegativeButton("no", new DialogInterface.OnClickListener(){
												@Override
												public void onClick(DialogInterface dialog,int which){
													Intent intent=new Intent(cargar.this,engre.class);
													String ur="http://"+ipt+":80/AppAndroid/inicio_bdmod.php";
													StringRequest strindd=new StringRequest(Request.Method.POST,ur,new Response.Listener<String>(){





														public void onResponse(String response){



														}



													},new Response.ErrorListener(){





														public void onErrorResponse(VolleyError error){

															Toast.makeText(getApplicationContext(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





														}




													}){

														protected Map<String, String> getParams() throws AuthFailureError {

															Map<String, String> parametros=new HashMap<String, String>();
															String usur=uss;

															parametros.put("usuario",usur);
															parametros.put("opcion","Usuario1");
															parametros.put("dato","2");

															return parametros;
														}
													};
													RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

													requestQueue.add(strindd);
													//bs.mot(uss,"2");
													intent.putExtra("Usuario",uss);
													startActivity(intent);
													finish();



													dialog.cancel();
												}

											});
									AlertDialog titulo=alert.create();
									titulo.setTitle("Alerta");
									titulo.show();
								}}else{

								    if(promedioLista.get(p).getTipo().equals("1")){


								        Intent intent=new Intent(cargar.this,admi.class);
                                        intent.putExtra("Usuario",uss);
                                        startActivity(intent);
                                        finish();

                                    }
                                    if(promedioLista.get(p).getTipo().equals("2")){

                                        Intent intent=new Intent(cargar.this,empresa.class);
                                        intent.putExtra("Usuario",uss);
                                        startActivity(intent);
                                        finish();

                                    }
                                }




							}
						}, new Response.ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {

							}
						});
						RequestQueue requestQueue;
						requestQueue= Volley.newRequestQueue(getApplicationContext());
						requestQueue.add(jsonArray);




					}
					else{
						Toast.makeText(getApplicationContext(), "Contraseña incorrecta",Toast.LENGTH_LONG).show();

						finish();
					}



				}else{
					Toast.makeText(getApplicationContext(), "usurio no encontrdo",Toast.LENGTH_LONG).show();

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
	public  void mete(String d){
		dat=d;
	}






}
