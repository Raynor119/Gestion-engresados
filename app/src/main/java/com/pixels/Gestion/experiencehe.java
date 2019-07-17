package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class experiencehe extends Fragment
{
	static 	EditText cellrb2,cellrb3,nomrb2,nomrb3,celrf2,celrf3,nomrf2,nomrf3,cur2,cur3;
	View vista;
	Button bt;
	Intent i;
	static EditText primarios,secundarios,superiores,cursos,celurb,nombrerb,celurf,nombrerf;
	public experiencehe() {
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
		vista=inflater.inflate(R.layout.activity_experienhe, container, false);
		bt=(Button) vista.findViewById(R.id.activityexperienButton1);
		primarios=(EditText)vista.findViewById(R.id.Eprima);
		secundarios=(EditText)vista.findViewById(R.id.Esecun);
		superiores=(EditText)vista.findViewById(R.id.Esuperi);
		cursos=(EditText)vista.findViewById(R.id.cuF1ros1);
		celurb=(EditText)vista.findViewById(R.id.RefLN1);
		nombrerb=(EditText)vista.findViewById(R.id.NRe1);
		celurf=(EditText)vista.findViewById(R.id.CeRF1);
		nombrerf=(EditText)vista.findViewById(R.id.NRFn1);

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
		bt.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){








//					i=new  Intent(getActivity(),engre.class);
//					i.putExtra("Usuario",useer);
//startActivity(i);


					getActivity().finish();
					//Toast.makeText(getActivity(),"se guardor la Hoja de vida ",Toast.LENGTH_SHORT).show();








				}

			
		});
		
        return vista;

		
    }


}
