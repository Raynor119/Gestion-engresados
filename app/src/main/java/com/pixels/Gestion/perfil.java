package com.pixels.Gestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class perfil extends AppCompatActivity
{
	static String nom;
	static String apelos;
	static String feccn;
	static String ema;
	static String lugarn;
	static String ed;
	static String c;
	static String lex;
	static String ocup;
	static String dicc;
	static String est;
	static String clu;

	static TextView nombre,apellidos,fechan,email,luagrdn,edad,cc,lugarex,ocupacion,direcc,estadoc,celular;
	
	public List<listhoja> promedioLista =new ArrayList<>();;
	String user,cont;
	
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.perfil);
		nombre=(TextView)findViewById(R.id.nombreh);
		apellidos=(TextView)findViewById(R.id.apellidoh);
		fechan=(TextView)findViewById(R.id.fNmh);
		email=(TextView)findViewById(R.id.emailh);
		luagrdn=(TextView)findViewById(R.id.lNmh);
		edad=(TextView)findViewById(R.id.edadh);
		cc=(TextView)findViewById(R.id.CCh);
		lugarex=(TextView)findViewById(R.id.LEXh);
		ocupacion=(TextView)findViewById(R.id.ocupacioh);
		direcc=(TextView)findViewById(R.id.dic);
		estadoc=(TextView)findViewById(R.id.estadoh);
		celular=(TextView)findViewById(R.id.celuj);
		
		ip c= new ip();
		String ipt=c.ip();
		String Url="http://"+ipt+":80/AppAndroid/hdatoslist.php";
		Bundle extra = getIntent().getExtras();
		user=extra.getString("Usuario");
		
		
		JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

				@Override
				public void onResponse(JSONArray response) {
					JSONObject jo = null;
					//Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
					for (int i = 0; i < response.length(); i++) {
						try {
							//Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
							jo = response.getJSONObject(i);
							promedioLista.add(new listhoja(jo.getString("USUARIO"), jo.getString("NOMBRE"), jo.getString("APELLIDOS"), jo.getString("FECHADEN"), jo.getString("EMAIL"), jo.getString("LUGARDN"), jo.getString("EDAD"), jo.getString("CEDULAC"), jo.getString("LUGAREX"), jo.getString("OCUPACION"), jo.getString("DIRECC"), jo.getString("ESTADOC"), jo.getString("CELULAR")));
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

					nombre.setText(" "+promedioLista.get(p).getNombre());
					apellidos.setText(" "+promedioLista.get(p).getApellido());
					fechan.setText(" "+promedioLista.get(p).getFechaden());
					email.setText(" "+promedioLista.get(p).getEmail());
					luagrdn.setText(" "+promedioLista.get(p).getLugarden());
					edad.setText(" "+promedioLista.get(p).getEdad());
					cc.setText(" "+promedioLista.get(p).getCec());
					lugarex.setText(" "+promedioLista.get(p).getLugardeex());
					ocupacion.setText(" "+promedioLista.get(p).getOcupacion());
					direcc.setText(" "+promedioLista.get(p).getDirecc());
					estadoc.setText(" "+promedioLista.get(p).getEstadic());
					celular.setText(" "+promedioLista.get(p).getCelular());
					
					
					
					
					
				}
			}	, new Response.ErrorListener() {
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
