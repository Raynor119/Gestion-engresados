package com.pixels.Gestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class eliminar extends Activity {
    String link;
    private List<tbofertasApli> ofert=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        Bundle extra = getIntent().getExtras();
        link=extra.getString("link");
        ip ccc=new ip();
        final String ipt=ccc.ip();
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
int d=0;
                for (int i = 0; i < ofert.size(); i++) {
                    String link2 = ofert.get(i).getLink();
                    if (link2.equalsIgnoreCase(String.valueOf(link))) {
                        d=1;
                        final String oferta = ofert.get(i).getOferta();

                        String RL = "http://"+ ipt +":80/AppAndroid/eliminaroferta.php";
                        StringRequest stindd = new StringRequest(Request.Method.POST, RL, new Response.Listener<String>() {


                            public void onResponse(String response) {


                            }


                        }, new Response.ErrorListener() {


                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                            }


                        }) {

                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String, String> parametros = new HashMap<String, String>();

                                parametros.put("oferta", oferta);
                                parametros.put("link", link);


                                return parametros;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                        requestQueue.add(stindd);
                        Toast.makeText(getApplicationContext(), "Se Elimino Correctamente la Oferta", Toast.LENGTH_SHORT).show();
Intent is=new Intent(getApplicationContext(),ofertas_aplicadas.class);
startActivity(is);
finish();


                    }
                }
                if(d==0){
                    String RL = "http://"+ ipt +":80/AppAndroid/elimiof.php";
                    StringRequest stindd = new StringRequest(Request.Method.POST, RL, new Response.Listener<String>() {


                        public void onResponse(String response) {


                        }


                    }, new Response.ErrorListener() {


                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                        }


                    }) {

                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> parametros = new HashMap<String, String>();


                            parametros.put("link", link);


                            return parametros;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(stindd);
                    Toast.makeText(getApplicationContext(), "Se Elimino Correctamente la Oferta", Toast.LENGTH_SHORT).show();
                    Intent is=new Intent(getApplicationContext(),ofertas_aplicadas.class);
                    startActivity(is);
                    finish();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String RL = "http://"+ ipt +":80/AppAndroid/elimiof.php";
                StringRequest stindd = new StringRequest(Request.Method.POST, RL, new Response.Listener<String>() {


                    public void onResponse(String response) {


                    }


                }, new Response.ErrorListener() {


                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "Conexion Fallida", Toast.LENGTH_SHORT).show();


                    }


                }) {

                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> parametros = new HashMap<String, String>();


                        parametros.put("link", link);


                        return parametros;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                requestQueue.add(stindd);
                Toast.makeText(getApplicationContext(), "Se Elimino Correctamente la Oferta", Toast.LENGTH_SHORT).show();
                Intent is=new Intent(getApplicationContext(),ofertas_aplicadas.class);
                startActivity(is);
                finish();
            }
        });
        RequestQueue requestQueue;


        requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }
}
