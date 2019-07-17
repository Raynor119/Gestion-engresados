package com.pixels.Gestion;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registrarofeta extends AppCompatActivity {

    EditText Titulo,Descripcion,Link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarofeta);
        Link=(EditText)findViewById(R.id.editText);
        Titulo=(EditText)findViewById(R.id.editText2);
        Descripcion=(EditText)findViewById(R.id.editText3);

    }
    public void guar(View v){
        ip c= new ip();
        String ipt=c.ip();
       final String titu = String.valueOf(Titulo.getText().toString());
        final String des = String.valueOf(Descripcion.getText().toString());
       final String lin = String.valueOf(Link.getText().toString());
        if(titu.equals("")||des.equals("")||lin.equals("")) {
            Toast.makeText(getApplicationContext(), "Llene Todos los Campos",Toast.LENGTH_LONG).show();
        }else{
            String URL = "http://"+ ipt +":80/AppAndroid/ofertas.php";
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
                    parametros.put("descrip", des);
                    parametros.put("link", lin);


                    return parametros;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            requestQueue.add(strindd);
            Toast.makeText(getApplicationContext(), "oferta Agregado",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
