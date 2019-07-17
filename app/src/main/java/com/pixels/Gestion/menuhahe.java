package com.pixels.Gestion;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import java.util.List;

public class menuhahe extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
	
	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
    String dat="0";
    public List<listhoja> promedioLista =new ArrayList<>();;
    public List<listexperience> pres =new ArrayList<>();;
    public List<lisref> expe =new ArrayList<>();;
static 	public String user;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuhhe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		Bundle extra = getIntent().getExtras();
	   user=extra.getString("Usuario");
	  
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        ip ccc=new ip();
        String ipt=ccc.ip();


        String Ur="http://"+ipt+":80/AppAndroid/inicio_bdbuc.php?usuario="+user;
        JsonArrayRequest jsonArray=new JsonArrayRequest(Ur, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject j = null;

                for (int i = 0; i < response.length(); i++) {
                    try {

                        j = response.getJSONObject(i);
                        //j.getString("DATO");
                        dat=j.getString("DATO");

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                    }

                }

                    ip c= new ip();
                    String ipt=c.ip();
                    String Url="http://"+ipt+":80/AppAndroid/hdatoslist.php";
                    JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo = null;
                            //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                                    jo = response.getJSONObject(i);
                                    promedioLista.add(new listhoja(jo.getString("USUARIO"), jo.getString("NOMBRE"), jo.getString("APELLIDOS"), jo.getString("FECHADEN"), jo.getString("EMAIL"), jo.getString("LUGARDN"), jo.getString("EDAD"), jo.getString("CEDULAC"), jo.getString("LUGAREX"), jo.getString("OCUPACION"), jo.getString("DIRECC"), jo.getString("ESTADOC"), jo.getString("CELULAR")));
                                    promedioLista.get(i).getUsuario();
                                    //Toast.makeText(getApplicationContext(), promedioLista.get(i).getUsuario()+" :t",Toast.LENGTH_LONG).show();
                                    //String v=jo.getString("USUARIO");
                                    //Toast.makeText(getApplicationContext(), v,Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                                }
                            }

                            int i;
                            int confu=0;
                            int confc=0;
                            int p=0;

                            for(i=0;i<promedioLista.size();i++){


                                String usurrr=promedioLista.get(i).getUsuario();
                                if(usurrr.equals(user)){
                                    confu=1;
                                    p=i;
                                }

                            }

                            hojavhe.nombre.setText(promedioLista.get(p).getNombre());
                            hojavhe.apellidos.setText(promedioLista.get(p).getApellido());
                            hojavhe.fechan.setText(promedioLista.get(p).getFechaden());
                            hojavhe.email.setText(promedioLista.get(p).getEmail());
                            hojavhe.luagrdn.setText(promedioLista.get(p).getLugarden());
                            hojavhe.edad.setText(promedioLista.get(p).getEdad());
                            hojavhe.cc.setText(promedioLista.get(p).getCec());
                            hojavhe.lugarex.setText(promedioLista.get(p).getLugardeex());
                            hojavhe.ocupacion.setText(promedioLista.get(p).getOcupacion());
                            hojavhe.direcc.setText(promedioLista.get(p).getDirecc());
                            hojavhe.estadoc.setText(promedioLista.get(p).getEstadic());
                            hojavhe.celular.setText(promedioLista.get(p).getCelular());





                        }
                    }	, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "errorConexion",Toast.LENGTH_LONG).show();

                        }
                    });

                    RequestQueue requestQueue;
                    requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonArrayRequest);


                    String Ul="http://"+ipt+":80/AppAndroid/hestudi.php";
                     jsonArrayRequest=new JsonArrayRequest(Ul, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo = null;
                            //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                                    jo = response.getJSONObject(i);
                                    pres.add(new listexperience(jo.getString("USUARIO"), jo.getString("PRIMARIOS"), jo.getString("SECUNDARIOS"), jo.getString("SUPERIORES"), jo.getString("OTROS")));
                                    // promedioLista.get(i).getUsuario();
                                    //Toast.makeText(getApplicationContext(), promedioLista.get(i).getUsuario()+" :t",Toast.LENGTH_LONG).show();
                                    //String v=jo.getString("USUARIO");
                                    //Toast.makeText(getApplicationContext(), v,Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                                }
                            }

                            int i;
                            int confu=0;
                            int confc=0;
                            int p=0;

                            for(i=0;i<pres.size();i++){


                                String usurrr=pres.get(i).getUsuario();
                                if(usurrr.equals(user)){
                                    confu=1;
                                    p=i;
                                }

                            }

                            experiencehe.primarios.setText(pres.get(p).getPrimarios());
                            experiencehe.secundarios.setText(pres.get(p).getSecundarios());
                            experiencehe.superiores.setText(pres.get(p).getSuperiores());
                            String otr=pres.get(p).getCursos();
                            int r=0;
                            String palabra="";
                            for(int v=0;v<otr.length();v++){
                                char letra=otr.charAt(v);
                                String nos=""+letra;
                                if(nos.equals("/")){
                                    if (r == 0) {
                                        experiencehe.cursos.setText(palabra);
                                    }
                                    if(r==1){
                                        experiencehe.cur2.setText(palabra);
                                    }
                                    r++;
                                    palabra="";
                                }else {
                                    palabra=palabra+letra;

                                }
                                if(r==2){
                                    experiencehe.cur3.setText(palabra);
                                }
                            }





                        }
                    }	, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "errorConexion",Toast.LENGTH_LONG).show();

                        }
                    });

                    requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonArrayRequest);
                    String Ull="http://"+ipt+":80/AppAndroid/hexpere.php";
                    jsonArrayRequest=new JsonArrayRequest(Ull, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo = null;
                            //Toast.makeText(getApplicationContext(), "entro2",Toast.LENGTH_LONG).show();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    //Toast.makeText(getApplicationContext(), "entro3",Toast.LENGTH_LONG).show();
                                    jo = response.getJSONObject(i);
                                    expe.add(new lisref(jo.getString("USUARIO"), jo.getString("CELULARRL"), jo.getString("NOMBRERL"), jo.getString("CELULARRF"), jo.getString("NOMBRERF")));
                                    // promedioLista.get(i).getUsuario();
                                    //Toast.makeText(getApplicationContext(), promedioLista.get(i).getUsuario()+" :t",Toast.LENGTH_LONG).show();
                                    //String v=jo.getString("USUARIO");
                                    //Toast.makeText(getApplicationContext(), v,Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                                }
                            }

                            int i;
                            int confu=0;
                            int confc=0;
                            int p=0;

                            for(i=0;i<expe.size();i++){


                                String usurrr=expe.get(i).getUsuario();
                                if(usurrr.equals(user)){
                                    confu=1;
                                    p=i;
                                }

                            }


                            String otr=expe.get(p).getCelularrb();
                            int r=0;
                            String palabra="";
                            for(int v=0;v<otr.length();v++){
                                char letra=otr.charAt(v);
                                String nos=""+letra;
                                if(nos.equals("/")){
                                    if (r == 0) {
                                        experiencehe.celurb.setText(palabra);
                                    }
                                    if(r==1){
                                        experiencehe.cellrb2.setText(palabra);
                                    }
                                    r++;
                                    palabra="";
                                }else {
                                    palabra=palabra+letra;

                                }
                                if(r==2){
                                    experiencehe.cellrb3.setText(palabra);
                                }
                            }
                             otr=expe.get(p).getNombrerb();
                             r=0;
                             palabra="";
                            for(int v=0;v<otr.length();v++){
                                char letra=otr.charAt(v);
                                String nos=""+letra;
                                if(nos.equals("/")){
                                    if (r == 0) {
                                        experiencehe.nombrerb.setText(palabra);
                                    }
                                    if(r==1){
                                        experiencehe.nomrb2.setText(palabra);
                                    }
                                    r++;
                                    palabra="";
                                }else {
                                    palabra=palabra+letra;

                                }
                                if(r==2){
                                    experiencehe.nomrb3.setText(palabra);
                                }
                            }
                            otr=expe.get(p).getCelularrf();
                            r=0;
                            palabra="";
                            for(int v=0;v<otr.length();v++){
                                char letra=otr.charAt(v);
                                String nos=""+letra;
                                if(nos.equals("/")){
                                    if (r == 0) {
                                        experiencehe.celurf.setText(palabra);
                                    }
                                    if(r==1){
                                        experiencehe.celrf2.setText(palabra);
                                    }
                                    r++;
                                    palabra="";
                                }else {
                                    palabra=palabra+letra;

                                }
                                if(r==2){
                                    experiencehe.celrf3.setText(palabra);
                                }
                            }
                            otr=expe.get(p).getNombrerf();
                            r=0;
                            palabra="";
                            for(int v=0;v<otr.length();v++){
                                char letra=otr.charAt(v);
                                String nos=""+letra;
                                if(nos.equals("/")){
                                    if (r == 0) {
                                        experiencehe.nombrerf.setText(palabra);
                                    }
                                    if(r==1){
                                        experiencehe.nomrf2.setText(palabra);
                                    }
                                    r++;
                                    palabra="";
                                }else {
                                    palabra=palabra+letra;

                                }
                                if(r==2){
                                    experiencehe.nomrf3.setText(palabra);
                                }
                            }







                        }
                    }	, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "errorConexion",Toast.LENGTH_LONG).show();

                        }
                    });

                    requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonArrayRequest);













            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArray);



    }

    // Métodos de la interfaz ActionBar.TabListener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // Métodos de la interfaz ViewPager.OnPageChangeListener
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * A placeholder fragment containing a simple view.

	 public static class PlaceholderFragment extends Fragment {
	 /**
	 * The fragment argument representing the section number for this
	 * fragment.

	 private static final String ARG_SECTION_NUMBER = "section_number";

	 public PlaceholderFragment() {
	 }

	 /**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	/**
	 public static PlaceholderFragment newInstance(int sectionNumber) {
	 PlaceholderFragment fragment = new PlaceholderFragment();
	 Bundle args = new Bundle();
	 args.putInt(ARG_SECTION_NUMBER, sectionNumber);
	 fragment.setArguments(args);
	 return fragment;
	 }

	 }
	 */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment tabFragment = null;

            switch (position){
                case 0:
                    tabFragment = new hojavhe();
                    break;
                case 1:
                    tabFragment = new experiencehe();
                    break;
            }
            return tabFragment;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String section = null;

            switch (position) {
                case 0:
                    section = "Datos";
                    break;
                case 1:
                    section = "Experiencia";
                    break;
            }
            return section;
        }
    }


	
	
}
