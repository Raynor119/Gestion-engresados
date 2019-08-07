package com.pixels.Gestion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

public class experiencehe extends Fragment
{
	static 	EditText cellrb2,cellrb3,nomrb2,nomrb3,celrf2,celrf3,nomrf2,nomrf3,cur2,cur3,profl2,profl3,proff2,proff3;
	View vista;
	Button bt,bt1;
	Intent i;
	static EditText primarios,secundarios,superiores,cursos,celurb,nombrerb,celurf,nombrerf,profesol,profesof;

	public experiencehe() {
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
		vista=inflater.inflate(R.layout.activity_experienhe, container, false);
		bt=(Button) vista.findViewById(R.id.activityexperienButton1);
		bt1=(Button) vista.findViewById(R.id.activitye);
		primarios=(EditText)vista.findViewById(R.id.Eprima);
		secundarios=(EditText)vista.findViewById(R.id.Esecun);
		superiores=(EditText)vista.findViewById(R.id.Esuperi);
		cursos=(EditText)vista.findViewById(R.id.cuF1ros1);
		celurb=(EditText)vista.findViewById(R.id.RefLN1);
		nombrerb=(EditText)vista.findViewById(R.id.NRe1);
		celurf=(EditText)vista.findViewById(R.id.CeRF1);
		nombrerf=(EditText)vista.findViewById(R.id.NRFn1);
		profesol=(EditText)vista.findViewById(R.id.RefN1);
		profesof=(EditText)vista.findViewById(R.id.ReN1);


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
		profl2=(EditText)vista.findViewById(R.id.RefN2);
		profl3=(EditText)vista.findViewById(R.id.RefN3);
		proff2=(EditText)vista.findViewById(R.id.ReN2);
		proff3=(EditText)vista.findViewById(R.id.ReN3);
		bt.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){

				AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
				alert.setMessage("¿Seguro que quieres descartarlo?")

						.setCancelable(false)

						.setPositiveButton("si", new DialogInterface.OnClickListener() {

							@Override

							public void onClick(DialogInterface dialog, int which) {

								ip ccc=new ip();
								final String ipt=ccc.ip();
								final String oferta=menuhahe.Ofeta;
								String RL = "http://"+ ipt +":80/AppAndroid/eliminarofap.php";
								StringRequest stindd = new StringRequest(Request.Method.POST, RL, new Response.Listener<String>() {


									public void onResponse(String response) {


									}


								}, new Response.ErrorListener() {


									public void onErrorResponse(VolleyError error) {

										Toast.makeText(getActivity(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


									}


								}) {

									protected Map<String, String> getParams() throws AuthFailureError {

										Map<String, String> parametros = new HashMap<String, String>();

										parametros.put("oferta", oferta);



										return parametros;
									}
								};
								RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

								requestQueue.add(stindd);
								Intent intent =new Intent(getActivity(),ofeaplica.class);

								getActivity().startActivity(intent);
								getActivity().finish();

							}


						})

						.setNegativeButton("no", new DialogInterface.OnClickListener() {

							@Override

							public void onClick(DialogInterface dialog, int which) {


								dialog.cancel();

							}


						});

				AlertDialog titulol = alert.create();

				titulol.setTitle("Alerta");

				titulol.show();




				}

			
		});
		bt1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Se a enviado el mensaje al correo ", Toast.LENGTH_SHORT).show();
				getActivity().finish();
			}
		});
        return vista;

		
    }


}
