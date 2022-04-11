package abstractasInterfaces.ejercicio2.document.impl;

import abstractasInterfaces.ejercicio2.document.Document;

public class Paper implements Document {

    private String text;
    private int numPages;
    private String autor;
    private String revisor;

    public Paper(String text, int numPages, String autor, String revisor) {
        this.text = text;
        this.numPages = numPages;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String print() {
        return "--- INFORME --- \n" +
                "Texto: " + this.text + "\n" +
                "Número de páginas: " + this.numPages + "\n" +
                "Autor: " + this.autor + "\n" +
                "Gender: " + this.revisor + "\n";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
