package com.pixels.Gestion;



public class datt
{
	String Usuario,Opcion,Dato;
	
	public datt(){
		
	}
	
	public datt(String usuario,String opcion,String dato){
		this.Usuario=usuario;
		this.Opcion=opcion;
		this.Dato=dato;
	}
	
	public void SetUsuario(String usuario){
		Usuario=usuario;
	}
	public String GetUsuario(){
		return Usuario;
	}
	public void SetOpcion(String opcion){
		Opcion=opcion;
	}
	public String Opcion(){
		return Opcion;
	}
	public void SetDato(String dato){
		Dato=dato;
	}
	public String GetDato(){
		return Dato;
	}
	
}
