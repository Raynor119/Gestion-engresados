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

public class CustomExpandableListAdapter4 extends BaseExpandableListAdapter {

    private Context context;

    private List<String> listTitulo;
    private Activity contet;

    private HashMap<String, tbofertasApli> expandableListDetalles;



    public CustomExpandableListAdapter4(Context context, List<String> listTitulo, HashMap<String,  tbofertasApli> expandableListDetalles) {

        this.context = context;

        this.listTitulo = listTitulo;

        this.expandableListDetalles = expandableListDetalles;

    }

    public void setInflater(Activity activity){
        this.contet=activity;
    }
    @Override

    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {



        final tbofertasApli contacto = (tbofertasApli) getChild(groupPosition, childPosition);



        if (convertView == null) {



            LayoutInflater layoutInflater = (LayoutInflater) this.context

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);



            convertView = layoutInflater.inflate(R.layout.item_elimu, null);



        }













        Button layoutVideollamada = convertView.findViewById(R.id.button8);









        layoutVideollamada.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {


                AlertDialog.Builder alert = new AlertDialog.Builder(contet);
                alert.setMessage("¿Quieres Eliminar Esta Oferta Laboral?")

                        .setCancelable(false)

                        .setPositiveButton("si", new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog, int which) {

                                Intent i=new Intent(contet,eliminaofaplica.class);
                                i.putExtra("oferta",contacto.getOferta());
                                i.putExtra("usuario",contacto.getUsuario());
                                contet.startActivity(i);
                                usuofeapli.activity.finish();


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

        tbofertasApli contacto = (tbofertasApli) getChild(groupPosition,0);



        if (convertView == null) {



            LayoutInflater layoutInflater = (LayoutInflater) this.context

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);



            convertView = layoutInflater.inflate(R.layout.item_oferapli, null);



        }



        TextView txttitulo = convertView.findViewById(R.id.textView8);

        TextView txtusuario = convertView.findViewById(R.id.text);
        TextView txtlink = convertView.findViewById(R.id.textlink);


        txttitulo.setText(contacto.getTitulo());

        txtusuario.setText(contacto.getUsuario());

        txtlink.setText(contacto.getLink());



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
