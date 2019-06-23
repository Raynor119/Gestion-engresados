package com.pixels.Gestion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registrar extends AppCompatActivity
{
	EditText usuario,nombre,contraseña;
	Button bm;
	@Override
	protected void onCreate(Bundle SavedInstacestate){
		super.onCreate(SavedInstacestate);
		setContentView(R.layout.activity_registrar);
		usuario=(EditText)findViewById(R.id.usurt);
		nombre=(EditText)findViewById(R.id.nombt);
		contraseña=(EditText)findViewById(R.id.contrnt);
		bm=(Button)findViewById(R.id.btnm);
		
		bm.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
			
				BasedeDatosU bas =new BasedeDatosU(getApplicationContext());
			String usur=String.valueOf(usuario.getText().toString());
			String contr=String.valueOf(contraseña.getText().toString());
			String nonb=String.valueOf(nombre.getText().toString());
			if(usur.equals("")||contr.equals("")||nonb.equals("")){
				Toast.makeText(getApplicationContext(), "digite todos los campos", Toast.LENGTH_LONG).show();
			}else
			{
				baseI bs= new baseI(getApplicationContext());
				B_hoja bs1=new B_hoja(getApplicationContext());
				B_experice bs2= new B_experice(getApplicationContext());
				
				//bs1.agreH(usur,"","","","","","","","","","","","");
				//bs2.agreE(usur,"","","","","","","","");
				//bas.agregarE(usur,contr,nonb);
				//bs.agrE(usur,"0");
				servicio("http://192.168.0.7:80/AppAndroid/insertar_datos.php");
				//Toast.makeText(getApplicationContext(), "usuario Agregado",Toast.LENGTH_LONG).show();
				//Intent intent=new Intent(registrar.this,MainActivity.class);
				//startActivity(intent);
				//finish();
			}
		   }
		});
		}

	private void servicio(String URL){

		StringRequest strindd=new StringRequest(Request.Method.POST,URL,new Response.Listener<String>(){



			@Override

			public void onResponse(String response){

				Toast.makeText(getApplicationContext(),"Conexion Exitosa",Toast.LENGTH_SHORT).show();

			}



		},new Response.ErrorListener(){



			@Override

			public void onErrorResponse(VolleyError error){

				Toast.makeText(getApplicationContext(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





			}



		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {

				Map<String, String> parametros=new HashMap<String, String>();

				parametros.put("usuario",usuario.getText().toString());
				parametros.put("contrasena",contraseña.getText().toString());
				parametros.put("nombre",nombre.getText().toString());
				parametros.put("tipo","0");

				return parametros;
			}
		};
		RequestQueue requestQueue= Volley.newRequestQueue(this);
		Toast.makeText(getApplicationContext(),"Conexion si",Toast.LENGTH_SHORT).show();
		requestQueue.add(strindd);
	}

}
