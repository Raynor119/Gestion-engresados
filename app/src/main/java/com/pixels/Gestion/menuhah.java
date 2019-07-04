package com.pixels.Gestion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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

public class menuhah extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
	
	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
    String dat="0";
static 	public String user;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuhh);

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
                if(dat.equals("0")|| dat.equals("2")){
                    AlertDialog.Builder alert= new AlertDialog.Builder(menuhah.this);

                    alert.setMessage("Desea Registrar la Hoja de Vida")
						.setCancelable(false)
						.setPositiveButton("si", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,int which){
                                dialog.cancel();
								



							}

						})
						.setNegativeButton("no", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog,int which){
                                Intent intent=new Intent(menuhah.this,engre.class);

                                intent.putExtra("Usuario",user);
                                startActivity(intent);
                                finish();

								dialog.cancel();
							}

						});
                    AlertDialog titulo=alert.create();
                    titulo.setTitle("Alerta");
                    titulo.show();
					
                }else{
                    Toast.makeText(getApplicationContext(), "ya lo lleno", Toast.LENGTH_LONG).show();

                }




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
                    tabFragment = new hojavh();
                    break;
                case 1:
                    tabFragment = new experienceh();
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
