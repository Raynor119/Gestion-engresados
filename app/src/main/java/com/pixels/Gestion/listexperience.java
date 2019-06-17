package com.pixels.Gestion;
import android.view.inputmethod.*;

public class listexperience
{
	String Usuario,Primarios,Secundarios,Superiores,Cursos,Celularrb,Nombrerb,Celularrf,Nombrerf;
	
	public listexperience(){
		
	}
	public listexperience(String usuario,String primarios,String secundarios,String superiores,String cursos,String celularrb,String nombrerb,String celularrf,String nombrerf){
        this.Usuario=usuario;
this.Primarios=primarios;
this.Secundarios=secundarios;
this.Superiores=superiores;
this.Cursos=cursos;
this.Celularrb=celularrb;
this.Nombrerb=nombrerb;
this.Celularrf=celularrf;
this.Nombrerf=celularrf;

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
	public String getCelularrb(){
		return Celularrb;
	}
	public void setCelularrb(String celularrrb){
		Celularrb=celularrrb;
	}
	public String getNombrerb(){
		return Nombrerb;
	}
	public void setNombrerb(String nombrerb){
		Nombrerb=nombrerb;
	}
	public String getCelularrf(){
		return Celularrf;
	}
	public void setCelularrf(String celularrf){
		Celularrf=celularrf;
	}
	public String getNombrerf(){
		return Nombrerf;
	}
	public void setNombrerf(String nombrerf){
		Nombrerf=nombrerf;
	}
	
}
