package com.pixels.Gestion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class baseI extends SQLiteOpenHelper
{
	private static final String NOMBRE_BD="baseU";
    private static final int VERSION_BD=1;
    private static final String TABLA_ENGRESADO="CREATE TABLE ENGRESADO(USUARIO TEXT PRIMARY KEY, DATO TEXT)";

    public baseI(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);


    }
	@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLA_ENGRESADO);
    }

	@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_ENGRESADO);
        sqLiteDatabase.execSQL(TABLA_ENGRESADO);
    }
	
	public void agrE(String usuario,String dato){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("INSERT INTO ENGRESADO VALUES('"+usuario+"','"+dato+"')");
            bd.close();
        }
    }
	
	
	
	public List<datt> obtusur(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM ENGRESADO",null);
        List<datt> usurr=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                usurr.add(new datt(cursor.getString(0),cursor.getString(1)));


            }while(cursor.moveToNext());
        }
        return usurr;

    }


	public void buscu(datt datos,String usuario){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM ENGRESADO WHERE USUARIO='"+usuario+"'",null);

        if(cursor.moveToFirst()){
            do{
                
				datos.SetDato(cursor.getString(1));




            }while(cursor.moveToNext());
        }


    }
	public void mot(String usuario,String dato){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null)
        {
            bd.execSQL("UPDATE ENGRESADO SET DATO='"+dato+"' WHERE USUARIO='"+usuario+"'");
            bd.close();
        } 
    }
	
}
