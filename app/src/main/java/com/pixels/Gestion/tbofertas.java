package com.pixels.Gestion;

public class tbofertas {
    private String Titulo,Descrip,link;

    public tbofertas() {
        
    }

    public tbofertas(String Titulo, String Descrip, String link) {
        this.Titulo = Titulo;
        this.Descrip = Descrip;
        this.link = link;
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
