package com.muchut.supermercadoUno;

public class Item {
    private String nombreItem;
    private int codigoItem;
    private int cantidadItem;
    private double costoUnitarioItem;

    public Item(String nombreItem, int codigoItem, int cantidadItem, double costoUnitarioItem) {
        this.nombreItem = nombreItem;
        this.codigoItem = codigoItem;
        this.cantidadItem = cantidadItem;
        this.costoUnitarioItem = costoUnitarioItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getCantidadItem() {
        return cantidadItem;
    }

    public void setCantidadItem(int cantidadItem) {
        this.cantidadItem = cantidadItem;
    }

    public double getCostoUnitarioItem() {
        return costoUnitarioItem;
    }

    public void setCostoUnitarioItem(double costoUnitarioItem) {
        this.costoUnitarioItem = costoUnitarioItem;
    }
}
