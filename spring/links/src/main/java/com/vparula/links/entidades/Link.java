package com.vparula.links.entidades;

public class Link {
    private int id;
    private String link;
    private String pwd;
    private boolean valido;
    private int visitas;

    public Link(int id, String link, String pwd, boolean valido, int visitas) {
        this.id = id;
        this.link = link;
        this.pwd = pwd;
        this.valido = valido;
        this.visitas = visitas;
    }

    public Link(String link, String pwd) {

        this.link = link;
        this.pwd = pwd;
        this.valido = true;
        this.visitas = 0;
    }


    public void visitar(){
        this.visitas++;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }
}
