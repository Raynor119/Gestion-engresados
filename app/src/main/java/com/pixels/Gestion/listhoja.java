package com.pixels.Gestion;

public class listhoja
{
	String Usuari,Nombre,Apellido,Fechaden,Email,Lugarden,Edad,Cec,Lugardeex,Ocupacion,Direcc,Estadic,Celular;
	
	public listhoja(){
		
	}
	public listhoja(String usuario,String nombre,String apellido,String fechaden,String email,String lugarden,String edad,String cec,String lugardeex,String ocupacion,String direcc,String estadic,String celular){
		this.Usuari=usuario;
		this.Nombre=nombre;
		this.Apellido=apellido;
		this.Fechaden=fechaden;
		this.Email=email;
		this.Lugarden=lugarden;
		this.Edad=edad;
		this.Cec=cec;
		this.Lugardeex=lugardeex;
		this.Ocupacion=ocupacion;
		this.Direcc=direcc;
		this.Estadic=estadic;
		this.Celular=celular;
		
	}
	
	public String getUsuario(){
		return Usuari;
	}
	public void setUsuario(String usuario){
		Usuari=usuario;
	}
	public String getNombre(){
		return Nombre;
	}
	public void setNombre(String nombre){
		Nombre=nombre;
	}
	public String getApellido(){
		return Apellido;
	}
	public void setApellido(String apellido){
		Apellido=apellido;
	}
	public String getFechaden(){
		return Fechaden;
	}
	public void setFechaden(String fechaden){
		Fechaden=fechaden;
	}
	public String getEmail(){
		return Email;
	}
	public void setEmail(String email){
		Email=email;
	}
	public String getLugarden(){
		return Lugarden;
	}
	public void setLugarden(String lugarden){
		Lugarden=lugarden;
	}
	public String getEdad(){
		return Edad;
	}
	public void setEdad(String edad){
		Edad=edad;
	}
	public String getCec(){
		return Cec;
	}
	public void setCec(String cec){
		Cec=cec;
	}
	public String getLugardeex(){
		return Lugardeex;
	}
	public void setLugardeex(String lugardeex){
		Lugardeex=lugardeex;
	}
	public String getOcupacion(){
		return Ocupacion;
	}
	public void setOcupacion(String ocupacion){
		Ocupacion=ocupacion;
	}
	public String getDirecc(){
		return Direcc;
	}
	public void setDirecc(String direcc){
		Direcc=direcc;
	}
	public String getEstadic(){
		return Estadic;
	}
	public void setEstadic(String estadic){
		Estadic=estadic;
	}
	public String getCelular(){
		return Celular;
	}
	public void setCelular(String celular){
		Celular=celular;
	}
}
