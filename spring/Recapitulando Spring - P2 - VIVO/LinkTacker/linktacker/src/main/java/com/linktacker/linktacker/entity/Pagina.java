package com.linktacker.linktacker.entity;

import java.net.URL;

public class Pagina {
    private int id;
    private URL url;
    private int cantidadVisitas;
    private boolean validada;
    private String password;

    public Pagina(){

    }

    public Pagina(URL url, int cantidadVisitas, boolean validada, String password) {
        this.url = url;
        this.cantidadVisitas = cantidadVisitas;
        this.validada = validada;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
