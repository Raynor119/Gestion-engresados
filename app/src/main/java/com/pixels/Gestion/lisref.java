package com.pixels.Gestion;

public class lisref {
    String Usuario,Celularrb,Nombrerb,Celularrf,Nombrerf;

   public lisref(){

    }
    public lisref(String usuario,String celularrb,String nombrerb,String celularrf,String nombrerf){
        this.Usuario=usuario;
        this.Celularrb=celularrb;
        this.Nombrerb=nombrerb;
        this.Celularrf=celularrf;
        this.Nombrerf=nombrerf;

    }
    public String getUsuario(){
        return Usuario;
    }
    public void setUsuario(String usuario){
        Usuario=usuario;
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
