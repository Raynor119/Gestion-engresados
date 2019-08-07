package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ofertas extends AppCompatActivity {
String titulo,descrip,link,rango;
    EditText Titulo,Descripcion;
   EditText Link,Rango;
    private List<tbofertasApli> ofert=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);
        Bundle extra = getIntent().getExtras();
        titulo=extra.getString("Titulo");
        descrip=extra.getString("descrip");
        link=extra.getString("link");
        rango=extra.getString("rango");
        Link=(EditText) findViewById(R.id.editText);
        Titulo=(EditText)findViewById(R.id.editText2);
        Descripcion=(EditText)findViewById(R.id.editText3);
        Rango=(EditText)findViewById(R.id.editText4);
        Titulo.setText(titulo);
        Descripcion.setText(descrip);
        Link.setText(link);
        Rango.setText(rango);

    }
    public void edit(View v){
        ip c= new ip();
       final String ipt=c.ip();
        final String titu = String.valueOf(Titulo.getText().toString());
        final String des = String.valueOf(Descripcion.getText().toString());
        final String rang= String.valueOf(Rango.getText().toString());
        if (titu.equals("")||des.equals("")) {
            Toast.makeText(getApplicationContext(), "Llene Todos los Campos",Toast.LENGTH_LONG).show();
        }else{

            String Url="http://"+ipt+":80/AppAndroid/ofertaaplicalist.php";

            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jo = null;
                    //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                            jo = response.getJSONObject(i);
                            ofert.add(new tbofertasApli(jo.getString("oferta"), jo.getString("titulo"), jo.getString("link"), jo.getString("usuario")));

                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                        }
                    }

                    for (int i = 0; i < ofert.size(); i++) {
                        String link2 = ofert.get(i).getLink();
                        if (link2.equalsIgnoreCase(link)) {
                            final String oferta = ofert.get(i).getOferta();
                            String URL = "http://"+ ipt +":80/AppAndroid/ofertasaplicamod.php";
                            StringRequest strindd = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {


                                public void onResponse(String response) {


                                }


                            }, new Response.ErrorListener() {


                                public void onErrorResponse(VolleyError error) {

                                    Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                                }


                            }) {

                                protected Map<String, String> getParams() throws AuthFailureError {

                                    Map<String, String> parametros = new HashMap<String, String>();

                                    parametros.put("titulo", titu);
                                    parametros.put("oferta", oferta);


                                    return parametros;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                            requestQueue.add(strindd);


                        }
                    }

                    String UR = "http://"+ ipt +":80/AppAndroid/ofertasmod.php";
                    StringRequest strind = new StringRequest(Request.Method.POST, UR, new Response.Listener<String>() {


                        public void onResponse(String response) {


                        }


                    }, new Response.ErrorListener() {


                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                        }


                    }) {

                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> parametros = new HashMap<String, String>();

                            parametros.put("titulo", titu);
                            parametros.put("descrip", des);
                            parametros.put("link", link);
                            parametros.put("rango", rang);


                            return parametros;
                        }
                    };
                    RequestQueue  requestQueue = Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(strind);
                    Toast.makeText(getApplicationContext(), "oferta editada", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(ofertas.this,ofertas_aplicadas.class);
                    startActivity(i);
                    finish();












                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String UR = "http://"+ ipt +":80/AppAndroid/ofertasmod.php";
                    StringRequest strind = new StringRequest(Request.Method.POST, UR, new Response.Listener<String>() {


                        public void onResponse(String response) {


                        }


                    }, new Response.ErrorListener() {


                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                        }


                    }) {

                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> parametros = new HashMap<String, String>();

                            parametros.put("titulo", titu);
                            parametros.put("descrip", des);
                            parametros.put("link", link);
                            parametros.put("rango", rang);

                            return parametros;
                        }
                    };
                    RequestQueue  requestQueue = Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(strind);
                    Toast.makeText(getApplicationContext(), "oferta editada", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(ofertas.this,ofertas_aplicadas.class);
                    startActivity(i);
                    finish();
                }
            });
            RequestQueue requestQueue;


            requestQueue= Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(jsonArrayRequest);

        }

    }
}
