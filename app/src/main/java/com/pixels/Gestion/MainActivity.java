package com.pixels.Gestion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
	EditText usuario,contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		usuario=(EditText)findViewById(R.id.mainEditText1);
		contraseña=(EditText)findViewById(R.id.mainEd1);
    }
	public void onclic(View view){
		Intent intent =new Intent(MainActivity.this,registrar.class);
		startActivity(intent);

	}
	public void onclick(View v){
		
		String usr=String.valueOf(usuario.getText().toString());
		String cont=String.valueOf(contraseña.getText().toString());
		
		
		if(usr.equals("")||cont.equals("")){
			Toast.makeText(getApplicationContext(), "Digite el Usuario o Contraseña",Toast.LENGTH_LONG).show();
		}
		else{
		
		Intent intent =new Intent(MainActivity.this,cargar.class);
		
		intent.putExtra("Usuario",usr);
		intent.putExtra("Contraseña",cont);

		startActivity(intent);

		
		}
	}
}
