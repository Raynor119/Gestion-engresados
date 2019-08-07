package com.pixels.Gestion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class hojavhe extends Fragment
{
	
	static String nom;
	static String apelos;
	static String feccn;
	static String ema;
	static String lugarn;
	static String ed;
	static String c;
	static String lex;
	static String ocup;
	static String dicc;
	static String est;
	static String clu;
	
static	EditText nombre,apellidos,fechan,email,luagrdn,edad,cc,lugarex,ocupacion,direcc,estadoc,celular;
	View vie;
	public hojavhe() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		vie=inflater.inflate(R.layout.activity_hojavhe, container, false);
		nombre=(EditText)vie.findViewById(R.id.nombreh);

		apellidos=(EditText)vie.findViewById(R.id.apellidoh);
		fechan=(EditText)vie.findViewById(R.id.fNmh);
		email=(EditText)vie.findViewById(R.id.emailh);
		luagrdn=(EditText)vie.findViewById(R.id.lNmh);
		edad=(EditText)vie.findViewById(R.id.edadh);
		cc=(EditText)vie.findViewById(R.id.CCh);
		lugarex=(EditText)vie.findViewById(R.id.LEXh);
		ocupacion=(EditText)vie.findViewById(R.id.ocupacioh);
		direcc=(EditText)vie.findViewById(R.id.dic);
		estadoc=(EditText)vie.findViewById(R.id.estadoh);
		celular=(EditText)vie.findViewById(R.id.celuj);
		
        return vie;
    }
	
	public static String onclic(){
	    nom=String.valueOf(nombre.getText().toString());
		 apelos=String.valueOf(apellidos.getText().toString());
		feccn=String.valueOf(fechan.getText().toString());
     	 ema=String.valueOf(email.getText().toString());
		 lugarn=String.valueOf(luagrdn.getText().toString());
	     ed=String.valueOf(edad.getText().toString());
		 c=String.valueOf(cc.getText().toString());
		 lex=String.valueOf(lugarex.getText().toString());
		 ocup=String.valueOf(ocupacion.getText().toString());
		 dicc=String.valueOf(direcc.getText().toString());
	     est=String.valueOf(estadoc.getText().toString());
		 clu=String.valueOf(celular.getText().toString());
		String dc="";
		if(nom.equals("")||apelos.equals("")||feccn.equals("")||ema.equals("")||lugarn.equals("")||ed.equals("")||c.equals("")||lex.equals("")||ocup.equals("")||dicc.equals("")|est.equals("")||clu.equals("")){
			dc="1";
		}
		else{
			dc="0";
		}
		
		return dc;
	}
}
