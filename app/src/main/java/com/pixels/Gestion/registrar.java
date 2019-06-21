package com.pixels.Gestion;

import android.app.*;
import android.os.*;
import android.widget.TextView.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import com.android.volley.toolbox.*;
import java.lang.reflect.*;
import com.android.volley.*;
import java.util.*;

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
				Toast.makeText(getApplicationContext(), "usuario Agregado",Toast.LENGTH_LONG).show();
				Intent intent=new Intent(registrar.this,MainActivity.class);
				startActivity(intent);
				finish();
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
				Toast.makeText(getApplicationContext(),"Conexion Exitosa",Toast.LENGTH_SHORT).show();
				
				
			}
			
		}){
	protected Map<String, String> getParams() throw AuthFailureError {

		Map<String, String> parametros=new HashMap<String, String>();
		parametros.put("usuario",usuario.getText().toString());


		return super.getParams();
      }
	}
	}
}
