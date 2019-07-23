package com.pixels.Gestion;



public class usurmm
{
	private String Usuario,Contraseña,Nombre,Tipo;

	public usurmm(){

	}
	public usurmm(String usuario,String contraseña,String nombre,String tipo){

		this.Usuario=usuario;
		this.Contraseña=contraseña;
		this.Nombre=nombre;
		this.Tipo=tipo;
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
	public String getTipo(){
		return Tipo;
	}
	public void setTipo(String tipo){
		Nombre=tipo;
	}
	
}
