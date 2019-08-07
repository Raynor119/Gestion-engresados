package com.pixels.Gestion;

import android.app.Activity;
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

public class aplicar extends Activity {
    static String user,titu,linl;
    private List<tbofertasApli> ofert=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicar);
        Bundle extra = getIntent().getExtras();
        titu=extra.getString("titulo");
        linl=extra.getString("link");
        user=extra.getString("Usuario");
        ip ccc= new ip();
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
                int cont = 0;
                for (int i = 0; i < ofert.size(); i++) {
                    String tituloc = ofert.get(i).getTitulo();
                    String linkc = ofert.get(i).getLink();
                    String usuario = ofert.get(i).getUsuario();
                    if (linkc.equalsIgnoreCase(linl) && usuario.equalsIgnoreCase(user)) {
                        cont = 1;
                    }
                }
                if (cont == 0) {
                    ip c= new ip();
                    String ipt=c.ip();
                    String UR="http://"+ipt+":80/AppAndroid/ofertasaplica.php";
                    StringRequest strindd=new StringRequest(Request.Method.POST,UR,new Response.Listener<String>(){





                        public void onResponse(String response){

                            Toast.makeText(getApplicationContext(),"Oferta Aplicada Exitosamente",Toast.LENGTH_SHORT).show();

                        }



                    },new Response.ErrorListener(){





                        public void onErrorResponse(VolleyError error){

                            Toast.makeText(getApplicationContext(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





                        }




                    }){

                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> parametros=new HashMap<String, String>();

                            parametros.put("titulo",titu);
                            parametros.put("link",linl);
                            parametros.put("usuario",user);

                            return parametros;
                        }
                    };
                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(strindd);
                } else {

                    Toast.makeText(getApplicationContext(), "No se puede aplicar otra vez",Toast.LENGTH_LONG).show();
                }


            }
        } , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    ip c= new ip();
                    String ipt=c.ip();
                    String UR="http://"+ipt+":80/AppAndroid/ofertasaplica.php";
                    StringRequest strindd=new StringRequest(Request.Method.POST,UR,new Response.Listener<String>(){





                        public void onResponse(String response){

                            Toast.makeText(getApplicationContext(),"Oferta Aplicada Exitosamente",Toast.LENGTH_SHORT).show();

                        }



                    },new Response.ErrorListener(){





                        public void onErrorResponse(VolleyError error){

                            Toast.makeText(getApplicationContext(),"Conexion Fallida",Toast.LENGTH_SHORT).show();





                        }




                    }){

                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> parametros=new HashMap<String, String>();

                            parametros.put("titulo",titu);
                            parametros.put("link",linl);
                            parametros.put("usuario",user);

                            return parametros;
                        }
                    };
                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                    requestQueue.add(strindd);
                }
            });
            RequestQueue requestQueue;


            requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);


finish();
    }

}
