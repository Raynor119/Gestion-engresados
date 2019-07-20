package com.pixels.Gestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admi extends AppCompatActivity {
    String user,cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admi);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
    }
    public void registrar(View v){

        Intent intent =new Intent(admi.this,registrarofeta.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);

    }
    public void usuari(View v){
        Intent intent=new Intent(admi.this,infodeengre.class);
        startActivity(intent);
    }
}
