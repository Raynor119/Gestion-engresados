package com.pixels.Gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BasedeDatosU extends SQLiteOpenHelper
{
	private static final String NOMBRE_BD="basededatosU";
    private static final int VERSION_BD=1;
    private static final String TABLA_ENGRESADOS="CREATE TABLE ENGRESADOS(USUARIO TEXT PRIMARY KEY, CONTRASEÑA TEXT, NOMBRE TEXT,TIPO TEXT)";

    public BasedeDatosU(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);


    }
	@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLA_ENGRESADOS);
    }
	
	@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_ENGRESADOS);
        sqLiteDatabase.execSQL(TABLA_ENGRESADOS);
    }
	
	public void agregarE(String usuario,String contraseña,String nombre,String tipo){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("INSERT INTO ENGRESADOS VALUES('"+usuario+"','"+contraseña+"','"+nombre+"','"+tipo+"')");
            bd.close();
        }
    }
	
	
	public List<usurmm> obtusur(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM ENGRESADOS",null);
        List<usurmm> usurr=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                usurr.add(new usurmm(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));


            }while(cursor.moveToNext());
        }
        return usurr;

    }
	
	
	public void buscu(usurmm datos,String usuario){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM ENGRESADOS WHERE USUARIO='"+usuario+"'",null);

        if(cursor.moveToFirst()){
            do{
                datos.setContraseña(cursor.getString(1));
                datos.setNombre(cursor.getString(2));
                datos.setNombre(cursor.getString(3));
                



            }while(cursor.moveToNext());
        }


    }
	
}
