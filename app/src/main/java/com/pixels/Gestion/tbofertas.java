package com.pixels.Gestion;

public class tbofertas {
    private String Titulo,Descrip,link,Rango;

    public tbofertas() {

    }

    public tbofertas(String Titulo, String Descrip, String link, String Rango) {
        this.Titulo = Titulo;
        this.Descrip = Descrip;
        this.link = link;
        this.Rango = Rango;
    }

    public String getRango() {
        return Rango;
    }

    public void setRango(String Rango) {
        this.Rango = Rango;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
