package com.pixels.Gestion;

public class usa {
    private String Id,Usuario,Contraseña,Nombre,Tipo;

    public usa(){

    }
    public usa(String id,String usuario,String contraseña,String nombre,String tipo){
        this.Id=id;
        this.Usuario=usuario;
        this.Contraseña=contraseña;
        this.Nombre=nombre;
        this.Tipo=tipo;
    }
    public String getId(){
        return Id;
    }
    public void setId(String id){
        Id=id;
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
