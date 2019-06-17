package com.pixels.Gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.*;

public class B_experice extends SQLiteOpenHelper
{
	private static final String NOMBRE_BD="bedE";
    private static final int VERSION_BD=1;
    private static final String TABLA_EXPERIENCIA="CREATE TABLE EXPERIENCIA(USUARIO TEXT PRIMARY KEY, PRIMARIOS TEXT, SECUNDARIOS TEXT, SUPERIORES TEXT, CURSOS TEXT, CELULARRB TEXT, NOMBRERB TEXT, CELULARRF TEXT, NOMBRERF TEXT)";

    public B_experice(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);


    }
	
	@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLA_EXPERIENCIA);
    }

	@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_EXPERIENCIA);
        sqLiteDatabase.execSQL(TABLA_EXPERIENCIA);
    }
	public void agreE(String usuario,String primarios,String secundarios,String superiores,String cursos,String celularrb,String nombrerb,String celularrf,String nombrerf){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("INSERT INTO EXPERIENCIA VALUES('"+usuario+"','"+primarios+"','"+secundarios+"','"+superiores+"','"+cursos+"','"+celularrb+"','"+nombrerb+"','"+celularrf+"','"+nombrerf+"')");
            bd.close();
        }
    }
	
	public List<listexperience> obtusur(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM EXPERIENCIA",null);
        List<listexperience> usurr=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                usurr.add(new listexperience(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));


            }while(cursor.moveToNext());
        }
        return usurr;

    }


	public void buscu(listexperience datos,String usuario){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM EXPERIENCIA WHERE USUARIO='"+usuario+"'",null);

        if(cursor.moveToFirst()){
            do{
                datos.setPrimario(cursor.getString(1));
                datos.setSecundarios(cursor.getString(2));
				datos.setSuperiores(cursor.getString(3));
				datos.setCursos(cursor.getString(4));
				datos.setCelularrb(cursor.getString(5));
				datos.setNombrerb(cursor.getString(6));
				datos.setCelularrf(cursor.getString(7));
				datos.setNombrerf(cursor.getString(8));
				
				
            }while(cursor.moveToNext());
        }


    }
	
	
}
