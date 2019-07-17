package com.pixels.Gestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class admi extends AppCompatActivity {
    String user,cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admi);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
    }
}
