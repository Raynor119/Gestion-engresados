package com.pixels.Gestion;



public class datt
{
	String Usuario,Dato;
	
	public datt(){
		
	}
	
	public datt(String usuario,String dato){
		this.Usuario=usuario;
		this.Dato=dato;
	}
	
	public void SetUsuario(String usuario){
		Usuario=usuario;
	}
	public String GetUsuario(){
		return Usuario;
	}

	public void SetDato(String dato){
		Dato=dato;
	}
	public String GetDato(){
		return Dato;
	}
	
}
