package com.pixels.Gestion;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class B_hoja extends SQLiteOpenHelper
{
	private static final String NOMBRE_BD="baseH";
    private static final int VERSION_BD=1;
    private static final String TABLA_HOJA="CREATE TABLE HOJA(USUARIO TEXT PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT, FECHADN TEXT, EMAIL TEXT, LUGARDN TEXT, EDAD TEXT, CC TEXT, LUGAREX TEXT, OCUPACION TEXT, DIRECC TEXT, ESTADOC TEXT, CELULAR TEXT)";

    public B_hoja (Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);


    }
	
	@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLA_HOJA);
    }

	@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_HOJA);
        sqLiteDatabase.execSQL(TABLA_HOJA);
    }

	public void agreH(String usuario,String nombre,String apellido,String fechaden,String email,String lugarn,String edad,String cc,String lugex,String ocupacion,String direcc,String estadoc,String celular){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("INSERT INTO HOJA VALUES('"+usuario+"','"+nombre+"','"+apellido+"','"+fechaden+"','"+email+"','"+lugarn+"','"+edad+"','"+cc+"','"+lugex+"','"+ocupacion+"','"+direcc+"','"+estadoc+"','"+celular+"')");
            bd.close();
        }
    }

	public List<listhoja> obtusur(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM HOJA",null);
        List<listhoja> usurr=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                usurr.add(new listhoja(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12)));


            }while(cursor.moveToNext());
        }
        return usurr;

    }


	public void buscu(listhoja datos,String usuario){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM HOJA WHERE USUARIO='"+usuario+"'",null);

        if(cursor.moveToFirst()){
            do{
               
                datos.setNombre(cursor.getString(1));
				datos.setApellido(cursor.getString(2));
				datos.setFechaden(cursor.getString(3));
				datos.setEmail(cursor.getString(4));
				datos.setLugarden(cursor.getString(5));
				datos.setEdad(cursor.getString(6));
				datos.setCec(cursor.getString(7));
				datos.setLugardeex(cursor.getString(8));
				datos.setOcupacion(cursor.getString(9));
				datos.setDirecc(cursor.getString(10));
				datos.setEstadic(cursor.getString(11));
				datos.setCelular(cursor.getString(12));
            }while(cursor.moveToNext());
        }


    }
}
