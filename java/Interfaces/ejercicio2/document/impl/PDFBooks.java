package abstractasInterfaces.ejercicio2.document.impl;

import abstractasInterfaces.ejercicio2.document.Document;

public class PDFBooks implements Document {

    private int numPages;
    private String autorName;
    private String tittle;
    private String gender;

    public PDFBooks(int numPages, String autorName, String tittle, String gender) {
        this.numPages = numPages;
        this.autorName = autorName;
        this.tittle = tittle;
        this.gender = gender;
    }

    public String print() {
        return "--- Libro PDF ---  \n" +
                "Número de páginas: " + this.numPages + "\n" +
                "Nombre del Autor: " + this.autorName + "\n" +
                "Título: " + this.tittle + "\n" +
                "Género: " + this.gender + "\n";
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
