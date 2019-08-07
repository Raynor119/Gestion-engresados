package com.pixels.Gestion;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter3 extends BaseExpandableListAdapter {

    private Context context;
    private  Activity contet;
    private List<String> listTitulo;

    private HashMap<String, tbofertas> expandableListDetalles;


    public CustomExpandableListAdapter3(Context context, List<String> listTitulo, HashMap<String,  tbofertas> expandableListDetalles) {

        this.context = context;

        this.listTitulo = listTitulo;

        this.expandableListDetalles = expandableListDetalles;

    }
    public void setInflater(Activity activity){
        this.contet=activity;
    }

    @Override

    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {



        final tbofertas contacto = (tbofertas) getChild(groupPosition, childPosition);


        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {







            convertView =  layoutInflater.inflate(R.layout.item_aplicar, null);



        }













        Button layoutVideollamada = convertView.findViewById(R.id.button7);















        layoutVideollamada.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {
               final  String titulo=contacto.getTitulo();
                final   String link=contacto.getLink();
                final  String usuario=buscaoferemple.user;

                AlertDialog.Builder alert = new AlertDialog.Builder(contet);
                alert.setMessage("¿Quieres Aplicar a Esta Oferta Laboral?")

                        .setCancelable(false)

                        .setPositiveButton("si", new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog, int which) {
                                Intent i=new Intent(contet,aplicar.class);
                                i.putExtra("titulo",titulo);
                                i.putExtra("link",link);
                                i.putExtra("Usuario",usuario);
                                contet.startActivity(i);




                            }


                        })

                        .setNegativeButton("no", new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog, int which) {


                                dialog.cancel();

                            }


                        });

                AlertDialog titulol = alert.create();

                titulol.setTitle("Alerta");

                titulol.show();





            }

        });









        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);

        convertView.startAnimation(animation);





        return convertView;

    }







    @Override

    public View getGroupView(int groupPosition, boolean isExpanded,

                             View convertView, ViewGroup parent) {





        String nombre = (String) getGroup(groupPosition);

        tbofertas contacto = ( tbofertas) getChild(groupPosition,0);



        if (convertView == null) {



            LayoutInflater layoutInflater = (LayoutInflater) this.context

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);



            convertView = layoutInflater.inflate(R.layout.item_ofer, null);



        }



        TextView txttitulo = convertView.findViewById(R.id.textView8);

        TextView txtdescribcion = convertView.findViewById(R.id.text);
        TextView txtlink = convertView.findViewById(R.id.textlink);
        TextView txtrango = convertView.findViewById(R.id.textrango);

        txttitulo.setText(nombre);

        txtdescribcion .setText(contacto.getDescrip());

        txtlink.setText(contacto.getLink());
        txtrango.setText(contacto.getRango());


        return convertView;

    }

    @Override

    public int getGroupCount() {

        return this.listTitulo.size();

    }



    @Override

    public int getChildrenCount(int groupPosition) {

        return 1;

    }



    @Override

    public Object getGroup(int groupPosition) {

        return this.listTitulo.get(groupPosition);

    }



    @Override

    public Object getChild(int groupPosition, int childPosition) {

        return this.expandableListDetalles.get(this.listTitulo.get(groupPosition));

    }



    @Override

    public long getGroupId(int groupPosition) {

        return groupPosition;

    }



    @Override

    public long getChildId(int groupPosition, int childPosition) {

        return childPosition;

    }



    @Override

    public boolean hasStableIds() {

        return false;

    }



    @Override

    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;

    }
}
