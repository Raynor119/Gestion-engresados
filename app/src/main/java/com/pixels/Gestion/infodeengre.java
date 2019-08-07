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

public class infodeengre extends AppCompatActivity {
    public List<usurmm> promedioLista =new ArrayList<>();
    public List<usurmm> usuarios =new ArrayList<>();
    private ExpandableListView expandableListView;

    private ExpandableListAdapter expandableListAdapter;

    private List<String> expandableListNombres;

    private HashMap<String, usurmm> listaContactos;

    private int lastExpandedPosition = -1;


    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infodeengre);
        ip c= new ip();
        final String ipt=c.ip();

        activity=this;
        this.expandableListView = findViewById(R.id.expandableListView);


        String Url="http://"+ipt+":80/AppAndroid/usulist.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                        jo = response.getJSONObject(i);
                        promedioLista.add(new usurmm(jo.getString("USUARIO"), jo.getString("CONTRASENA"), jo.getString("NOMBRE"), jo.getString("TIPO")));
                        promedioLista.get(i).getUsuario();
                        //Toast.makeText(getApplicationContext(), promedioLista.get(i).getUsuario()+" :t",Toast.LENGTH_LONG).show();
                        //String v=jo.getString("USUARIO");
                        //Toast.makeText(getApplicationContext(), v,Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                    }
                }

                for(int i=0;i<promedioLista.size();i++){
                    if(promedioLista.get(i).getTipo().equals("0")){
                        usuarios.add(new usurmm(promedioLista.get(i).getUsuario(),promedioLista.get(i).getContraseña(),promedioLista.get(i).getNombre(),promedioLista.get(i).getTipo()));

                    }

                }

                HashMap<String, usurmm> listaC = new HashMap<>();



                for(int i=0;i<usuarios.size();i++){
                    listaC.put(usuarios.get(i).getUsuario(), new usurmm(usuarios.get(i).getUsuario(),usuarios.get(i).getContraseña(),usuarios.get(i).getNombre(),usuarios.get(i).getTipo()));
                }
                listaContactos = listaC;
                expandableListNombres = new ArrayList<>(listaContactos.keySet());

                expandableListAdapter = new CustomExpandableListAdapter2(getApplicationContext(), expandableListNombres, listaContactos);
                ((CustomExpandableListAdapter2) expandableListAdapter).setInflater(activity);

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
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
