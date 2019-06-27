package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class experience extends Fragment
{
	
	View vista;
	Button bt;
	Intent i;
	EditText primarios,secundarios,superiores,cursos,celurb,nombrerb,celurf,nombrerf;
	public experience() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		vista=inflater.inflate(R.layout.activity_experien, container, false);
		bt=(Button) vista.findViewById(R.id.activityexperienButton1);
		primarios=(EditText)vista.findViewById(R.id.Eprima);
		secundarios=(EditText)vista.findViewById(R.id.Esecun);
		superiores=(EditText)vista.findViewById(R.id.Esuperi);
		cursos=(EditText)vista.findViewById(R.id.cuF1ros1);
		celurb=(EditText)vista.findViewById(R.id.RefLN1);
		nombrerb=(EditText)vista.findViewById(R.id.NRe1);
		celurf=(EditText)vista.findViewById(R.id.CeRF1);
		nombrerf=(EditText)vista.findViewById(R.id.NRFn1);
		bt.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
			String cd=hojav.onclic();
			final String pri=String.valueOf(primarios.getText().toString());
			final String se=String.valueOf(secundarios.getText().toString());
			final String sup=String.valueOf(superiores.getText().toString());
			final String cur=String.valueOf(cursos.getText().toString());
			final String cerb=String.valueOf(celurb.getText().toString());
			final String nomrb=String.valueOf(nombrerb.getText().toString());
			final String cerf=String.valueOf(celurf.getText().toString());
			final String norf=String.valueOf(nombrerf.getText().toString());
			
			String dc="1";
			if(pri.equals("")||se.equals("")||sup.equals("")||cur.equals("")||cerb.equals("")||nomrb.equals("")||cerf.equals("")||norf.equals("")){
				dc="1";
			}else{
				dc="";
			}
			
			if(cd.equals("1")||dc.equals("1")){
				Toast.makeText(getActivity(), "Llene todos los Campos",Toast.LENGTH_LONG).show();
				}else
				{
				final String no=hojav.nom;
					final String ap=hojav.apelos;
					final String fec=hojav.feccn;
					final String ema=hojav.ema;
					final String lugn=hojav.lugarn;
					final String ed=hojav.ed;
					final String ccc=hojav.c;
					final String lux=hojav.lex;
					final String ocup=hojav.ocup;
					final String dcc=hojav.dicc;
					final String sta=hojav.est;
					final String cell=hojav.clu;
				
				B_hoja bs=new B_hoja(getActivity());
				
				final String useer=menuha.user;
					
				//bs.agreH(useer,no,ap,fec,ema,lugn,ed,ccc,lux,ocup,dcc,sta,cell);
				B_experice bd=new B_experice(getActivity());
				EditText cellrb2,cellrb3,nomrb2,nomrb3,celrf2,celrf3,nomrf2,nomrf3,cur2,cur3;
				
				cur2=(EditText)vista.findViewById(R.id.cuF1ros2);
				cur3=(EditText)vista.findViewById(R.id.cuF1ros3);
				cellrb2=(EditText)vista.findViewById(R.id.RefLN2);
				cellrb3=(EditText)vista.findViewById(R.id.RefLN3);
				nomrb2=(EditText)vista.findViewById(R.id.NRe2);
				nomrb3=(EditText)vista.findViewById(R.id.NRe3);
				celrf2=(EditText)vista.findViewById(R.id.CeRF2);
				celrf3=(EditText)vista.findViewById(R.id.CeRF3);
				nomrf2=(EditText)vista.findViewById(R.id.NRFn2);
				nomrf3=(EditText)vista.findViewById(R.id.NRFn3);
				final String curf=cur+"/"+cur2.getText().toString()+"/"+cur3.getText().toString();
				final String cerbF=cerb+"/"+cellrb2.getText().toString()+"/"+cellrb3.getText().toString();
				final String nomrbF=nomrb+"/"+nomrb2.getText().toString()+"/"+nomrb3.getText().toString();
				final String cerFF=cerf+"/"+celrf2.getText().toString()+"/"+celrf3.getText().toString();
				final String nomrFF=norf+"/"+nomrf2.getText().toString()+"/"+nomrf3.getText().toString();
				
				//bd.agreE(useer,pri,se,sup,curf,cerbF,nomrbF,cerFF,nomrFF);
					//baseI c=new baseI(getActivity());

					//c.mot(useer,"1");
					ip cC= new ip();
					String ipt=cC.ip();
					String URL="http://"+ipt+":80/AppAndroid/h_datosmod.php";



					StringRequest strindd=new StringRequest(Request.Method.POST,URL,new Response.Listener<String>(){





						public void onResponse(String response){



						}



					},new Response.ErrorListener(){





						public void onErrorResponse(VolleyError error){

							Toast.makeText(getActivity(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





						}




					}){

						protected Map<String, String> getParams() throws AuthFailureError {

							Map<String, String> parametros=new HashMap<String, String>();
							String usur=useer;

							parametros.put("usuario",usur);
							parametros.put("nombre",no);
							parametros.put("apellido",ap);
							parametros.put("fechaden",fec);
							parametros.put("email",ema);
							parametros.put("lugarden",lugn);
							parametros.put("edad",ed);
							parametros.put("cedulac",ccc);
							parametros.put("lugarex",lux);
							parametros.put("ocupacion",ocup);
							parametros.put("direcc",dcc);
							parametros.put("estadoc",sta);
							parametros.put("celular",cell);
							return parametros;
						}
					};
					RequestQueue requestQueue= Volley.newRequestQueue(getActivity());

					requestQueue.add(strindd);




					String UR="http://"+ipt+":80/AppAndroid/h_estudiosmod.php";






					StringRequest stri=new StringRequest(Request.Method.POST,UR,new Response.Listener<String>(){





						public void onResponse(String response){



						}



					},new Response.ErrorListener(){





						public void onErrorResponse(VolleyError error){

							Toast.makeText(getActivity(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





						}




					}){

						protected Map<String, String> getParams() throws AuthFailureError {

							Map<String, String> parametros=new HashMap<String, String>();
							String usr=useer;

							parametros.put("usuario",usr);
							parametros.put("primarios",pri);
							parametros.put("secundarios",se);
							parametros.put("superiores",sup);
							parametros.put("otros",curf);
							return parametros;
						}
					};
					requestQueue= Volley.newRequestQueue(getActivity());

					requestQueue.add(stri);

					String U="http://"+ipt+":80/AppAndroid/h_experienciamod.php";
					StringRequest strind=new StringRequest(Request.Method.POST,U,new Response.Listener<String>(){





						public void onResponse(String response){



						}



					},new Response.ErrorListener(){





						public void onErrorResponse(VolleyError error){

							Toast.makeText(getActivity(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





						}




					}){

						protected Map<String, String> getParams() throws AuthFailureError {

							Map<String, String> parametros=new HashMap<String, String>();
							String ur=useer;
							//bd.agreE(useer,pri,se,sup,curf,cerbF,nomrbF,cerFF,nomrFF);
							parametros.put("usuario",ur);
							parametros.put("celularrl",cerbF);
							parametros.put("nombrerl",nomrbF);
							parametros.put("celularrf",cerFF);
							parametros.put("nombrerf",nomrFF);
							return parametros;
						}
					};
					 requestQueue= Volley.newRequestQueue(getActivity());

					requestQueue.add(strind);

					String ur="http://"+ipt+":80/AppAndroid/inicio_bdmod.php";
					StringRequest std=new StringRequest(Request.Method.POST,ur,new Response.Listener<String>(){





						public void onResponse(String response){



						}



					},new Response.ErrorListener(){





						public void onErrorResponse(VolleyError error){

							Toast.makeText(getActivity(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





						}




					}){

						protected Map<String, String> getParams() throws AuthFailureError {

							Map<String, String> parametros=new HashMap<String, String>();
							String usur=useer;

							parametros.put("usuario",usur);
							parametros.put("opcion","Usuario1");
							parametros.put("dato","1");

							return parametros;
						}
					};
					 requestQueue= Volley.newRequestQueue(getActivity());

					requestQueue.add(std);












					i=new  Intent(getActivity(),engre.class);
					i.putExtra("Usuario",useer);
startActivity(i);


					getActivity().finish();
					Toast.makeText(getActivity(),"se guardor la Hoja de vida ",Toast.LENGTH_SHORT).show();








				}
			}
			
		});
		
        return vista;

		
    }


}
