package model;

public class Item {

    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(String codigo, String nombre, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = 0;
        this.costoUnitario = costoUnitario;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostototal(){
        return this.costoUnitario * this.cantidadComprada;
    }

    public void imprimirDatosItem(){
        //System.out.printf("\t %-15.10s $%-9.02f %-3d $%-10.02f \n",this.nombre, this.costoUnitario, this.cantidadComprada,this.getCostototal());
        System.out.printf("\t %-15.10s $%-15.02f %-14d $%-15.02f \n",this.nombre, this.costoUnitario, this.cantidadComprada,this.getCostototal());

    }

}
