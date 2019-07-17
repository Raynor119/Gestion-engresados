/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pixels.Gestion;

/**
 *
 * @author Flia Celis
 */
public class tbofertasApli {
    private String oferta,titulo,link,usuario;

    public tbofertasApli() {
    }

    public tbofertasApli(String oferta, String titulo, String link, String usuario) {
        this.oferta=oferta;
        this.titulo = titulo;
        this.link = link;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }
    
}
