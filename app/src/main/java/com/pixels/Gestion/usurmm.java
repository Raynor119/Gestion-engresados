package com.pixels.Gestion;



public class usurmm
{
	private String Usuario,Contraseña,Nombre;
	
	public usurmm(){
		
	}
	public usurmm(String usuario,String contraseña,String nombre){
		this.Usuario=usuario;
		this.Contraseña=contraseña;
		this.Nombre=nombre;
	}
	public String getUsuario(){
		return Usuario;
	}
	public void setUsuario(String usuario){
		Usuario=usuario;
	}
	public String getContraseña(){
		return Contraseña;
	}
	public void setContraseña(String contraseña){
		Contraseña=contraseña;
	}
	public String getNombre(){
		return Nombre;
	}
	public void setNombre(String nombre){
		Nombre=nombre;
	}
	
}
