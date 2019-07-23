package com.pixels.Gestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class eliminaofaplica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminaofaplica);
        Bundle extra = getIntent().getExtras();
     final   String oferta=extra.getString("oferta");
     String usuario=extra.getString("usuario");
        ip ccc=new ip();
        final String ipt=ccc.ip();
        String RL = "http://"+ ipt +":80/AppAndroid/eliminarofap.php";
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



                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        requestQueue.add(stindd);
        Toast.makeText(getApplicationContext(), "Se Elimino Correctamente la Oferta", Toast.LENGTH_SHORT).show();
        Intent is=new Intent(eliminaofaplica.this,usuofeapli.class);
        is.putExtra("Usuario",usuario);
        startActivity(is);
        finish();
    }
}
