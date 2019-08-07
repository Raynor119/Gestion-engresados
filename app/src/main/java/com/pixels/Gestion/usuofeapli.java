package com.pixels.Gestion;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class usuofeapli extends AppCompatActivity {
    private ExpandableListView expandableListView;

    private ExpandableListAdapter expandableListAdapter;

    private List<String> expandableListNombres;

    private HashMap<String, tbofertasApli> listaContactos;

    private int lastExpandedPosition = -1;
    static String user;
    private List<tbofertasApli> ofert=new ArrayList<>();
    private List<tbofertasApli> ofert1=new ArrayList<>();
    static public Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuofeapli);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
        ip ccc=new ip();
        activity=this;
        this.expandableListView = findViewById(R.id.expandableListView);
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
                        ofert1.add(new tbofertasApli(jo.getString("oferta"), jo.getString("titulo"), jo.getString("link"), jo.getString("usuario")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                    }
                }


                for(int i=0;i<ofert1.size();i++){
                    if(ofert1.get(i).getUsuario().equals(user)) {
                        ofert.add(new tbofertasApli(ofert1.get(i).getOferta(),ofert1.get(i).getTitulo(),ofert1.get(i).getLink(),ofert1.get(i).getUsuario()));
                    }
                }



                HashMap<String, tbofertasApli> listaC = new HashMap<>();

                for(int i=0;i<ofert.size();i++){
                    listaC.put(ofert.get(i).getOferta(), new tbofertasApli(ofert.get(i).getOferta(),ofert.get(i).getTitulo(),ofert.get(i).getLink(),ofert.get(i).getUsuario()));
                }
                listaContactos = listaC;
                expandableListNombres = new ArrayList<>(listaContactos.keySet());

                expandableListAdapter = new CustomExpandableListAdapter4(getApplicationContext(), expandableListNombres, listaContactos);
                ((CustomExpandableListAdapter4) expandableListAdapter).setInflater(activity);

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
