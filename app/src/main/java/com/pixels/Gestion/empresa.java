package com.pixels.Gestion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class empresa extends AppCompatActivity {
    String user,cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
    }
    public void registrar(View v){

        Intent intent =new Intent(empresa.this,registrarofeta.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);

    }
    public void ofertare(View view){
        Intent intent =new Intent(empresa.this,ofertas_aplicadas.class);

        startActivity(intent);
    }
    public void ofertareap(View view){
        Intent intent =new Intent(empresa.this,ofeaplica.class);

        startActivity(intent);
    }
    public void cerrarcesion(View v){


        basedeinicio ne=new basedeinicio(getApplicationContext());
        usa c=new usa();
        List<usa> usurr=new ArrayList<>();
        usurr=ne.obtusur();
        String usu=usurr.get(0).getUsuario();
        if(usu.equals("nada")){
            finish();
        }else {
            AlertDialog.Builder alert = new AlertDialog.Builder(empresa.this);
            alert.setMessage("¿Quieres Cerrar Sesión?")

                    .setCancelable(false)

                    .setPositiveButton("si", new DialogInterface.OnClickListener() {

                        @Override

                        public void onClick(DialogInterface dialog, int which) {


                            basedeinicio n = new basedeinicio(getApplicationContext());
                            n.inic("1", "nada", "", "", "");


                            Intent intent = new Intent(empresa.this, MainActivity.class);


                            startActivity(intent);
                            finish();

                        }


                    })

                    .setNegativeButton("no", new DialogInterface.OnClickListener() {

                        @Override

                        public void onClick(DialogInterface dialog, int which) {


                            dialog.cancel();
                            finish();
                        }


                    });

            AlertDialog titulo = alert.create();

            titulo.setTitle("Alerta");

            titulo.show();
        }
    }


}
