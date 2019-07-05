package com.pixels.Gestion;
public class listexperience
{
	String Usuario,Primarios,Secundarios,Superiores,Cursos;
	
	public listexperience(){
		
	}
	public listexperience(String usuario,String primarios,String secundarios,String superiores,String cursos){
        this.Usuario=usuario;
this.Primarios=primarios;
this.Secundarios=secundarios;
this.Superiores=superiores;
this.Cursos=cursos;

	}
	
	public String getUsuario(){
		return Usuario;
	}
	public void setUsuario(String usuario){
		Usuario=usuario;
	}
	public String getPrimarios(){
		return Primarios;
	}
	public void setPrimario(String primarios){
		Primarios=primarios;
	}
	public String getSecundarios(){
		return Secundarios;
	}
	public void setSecundarios(String secundarios){
		Secundarios=secundarios;
	}
	public String getSuperiores(){
		return Superiores;
	} 
	public void setSuperiores(String superiores){
		
		Superiores=superiores;
	}
	public String getCursos(){
		return Cursos;
	}
	public void setCursos(String cursos){
		Cursos=cursos;
	}

}
