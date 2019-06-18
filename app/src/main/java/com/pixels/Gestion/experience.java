package com.pixels.Gestion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
public class experience extends Fragment
{
	
	View vista;
	Button bt;
	EditText primarios,secundarios,superiores,cursos,celurb,nombrerb,celurf,nombrerf;
	public experience() {
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
		vista=inflater.inflate(R.layout.activity_experien, container, false);
		bt=(Button) vista.findViewById(R.id.activityexperienButton1);
		primarios=(EditText)vista.findViewById(R.id.Eprima);
		secundarios=(EditText)vista.findViewById(R.id.Esecun);
		superiores=(EditText)vista.findViewById(R.id.Esuperi);
		cursos=(EditText)vista.findViewById(R.id.cuF1ros1);
		celurb=(EditText)vista.findViewById(R.id.RefLN1);
		nombrerb=(EditText)vista.findViewById(R.id.NRe1);
		celurf=(EditText)vista.findViewById(R.id.CeRF1);
		nombrerf=(EditText)vista.findViewById(R.id.NRFn1);
		bt.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
			String cd=hojav.onclic();
			String pri=String.valueOf(primarios.getText().toString());
			String se=String.valueOf(secundarios.getText().toString());
			String sup=String.valueOf(superiores.getText().toString());
			String cur=String.valueOf(cursos.getText().toString());
			String cerb=String.valueOf(celurb.getText().toString());
			String nomrb=String.valueOf(nombrerb.getText().toString());
			String cerf=String.valueOf(celurf.getText().toString());
			String norf=String.valueOf(nombrerf.getText().toString());
			
			String dc="1";
			if(pri.equals("")||se.equals("")||sup.equals("")||cur.equals("")||cerb.equals("")||nomrb.equals("")||cerf.equals("")||norf.equals("")){
				dc="1";
			}else{
				dc="";
			}
			
			if(cd.equals("1")||dc.equals("1")){
				Toast.makeText(getActivity(), "Llene todos los Campos",Toast.LENGTH_LONG).show();
				}else
				{
				String no=hojav.nom;
				String ap=hojav.apelos;
				String fec=hojav.feccn;
				String ema=hojav.ema;
				String lugn=hojav.lugarn;
				String ed=hojav.ed;
				String ccc=hojav.c;
				String lux=hojav.lex;
				String ocup=hojav.ocup;
				String dcc=hojav.dicc;
				String sta=hojav.est;
				String cell=hojav.clu;
				
				B_hoja bs=new B_hoja(getActivity());
				
				String useer=menuha.user;
					
				//bs.agreH(useer,no,ap,fec,ema,lugn,ed,ccc,lux,ocup,dcc,sta,cell);
				B_experice bd=new B_experice(getActivity());
				EditText cellrb2,cellrb3,nomrb2,nomrb3,celrf2,celrf3,nomrf2,nomrf3,cur2,cur3;
				
				cur2=(EditText)vista.findViewById(R.id.cuF1ros2);
				cur3=(EditText)vista.findViewById(R.id.cuF1ros3);
				cellrb2=(EditText)vista.findViewById(R.id.RefLN2);
				cellrb3=(EditText)vista.findViewById(R.id.RefLN3);
				nomrb2=(EditText)vista.findViewById(R.id.NRe2);
				nomrb3=(EditText)vista.findViewById(R.id.NRe3);
				celrf2=(EditText)vista.findViewById(R.id.CeRF2);
				celrf3=(EditText)vista.findViewById(R.id.CeRF3);
				nomrf2=(EditText)vista.findViewById(R.id.NRFn2);
				nomrf3=(EditText)vista.findViewById(R.id.NRFn3);
				String curf=cur+"/"+cur2.getText().toString()+"/"+cur3.getText().toString();
				String cerbF=cerb+"/"+cellrb2.getText().toString()+"/"+cellrb3.getText().toString();
				String nomrbF=nomrb+"/"+nomrb2.getText().toString()+"/"+nomrb3.getText().toString();
				String cerFF=cerf+"/"+celrf2.getText().toString()+"/"+celrf3.getText().toString();
				String nomrFF=norf+"/"+nomrf2.getText().toString()+"/"+nomrf3.getText().toString();
				
				//bd.agreE(useer,pri,se,sup,curf,cerbF,nomrbF,cerFF,nomrFF);
					baseI c=new baseI(getActivity());

					//c.mot(useer,"1");
				}
			}
			
		});
		
        return vista;
		
    }
	
	
}
