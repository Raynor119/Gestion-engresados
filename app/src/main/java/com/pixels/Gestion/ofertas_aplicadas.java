package com.pixels.Gestion;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
import java.util.HashMap;
import java.util.List;

public class ofertas_aplicadas extends AppCompatActivity {
    private ExpandableListView expandableListView;

    private ExpandableListAdapter expandableListAdapter;

    private List<String> expandableListNombres;

    private HashMap<String, tbofertas> listaContactos;

    private int lastExpandedPosition = -1;
    private Activity activity;

    private List<tbofertas> ofert=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas_aplicadas);
        ip ccc=new ip();
        activity=this;
        this.expandableListView = findViewById(R.id.expandableListView);
        final String ipt=ccc.ip();
        String Url="http://"+ipt+":80/AppAndroid/ofertalist.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                        jo = response.getJSONObject(i);
                        ofert.add(new tbofertas(jo.getString("titulo"), jo.getString("descrip"), jo.getString("link")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                    }
                }
                HashMap<String, tbofertas> listaC = new HashMap<>();



                for(int i=0;i<ofert.size();i++){
                    listaC.put(ofert.get(i).getTitulo(), new tbofertas(ofert.get(i).getTitulo(),ofert.get(i).getDescrip(),ofert.get(i).getLink()));
                }
                listaContactos = listaC;
                expandableListNombres = new ArrayList<>(listaContactos.keySet());

                expandableListAdapter = new CustomExpandableListAdapter(getApplicationContext(), expandableListNombres, listaContactos);


              ((CustomExpandableListAdapter) expandableListAdapter).setInflater(activity);

                expandableListView.setAdapter(expandableListAdapter);



                expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    @Override

                    public void onGroupExpand(int groupPosition) {

                        if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){

                            expandableListView.collapseGroup(lastExpandedPosition);

                        }

                        lastExpandedPosition = groupPosition;

                    }

                });




            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "errorConexion",Toast.LENGTH_LONG).show();

                }
            });
            RequestQueue requestQueue;


            requestQueue= Volley.newRequestQueue(getApplicationContext());
					requestQueue.add(jsonArrayRequest);

    }
}
