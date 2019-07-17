package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

}
