package com.company;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void calcular (int cantProd, int diasPorCaducar){
       double valor;

       switch (diasPorCaducar) {
           case 1:
               System.out.print((this.getPrecio() * cantProd)/4);
               break;
           case 2:
               System.out.print((this.getPrecio() * cantProd)/3);
               break;
           case 3:
               System.out.print((this.getPrecio() * cantProd)/2);
               break;

               default:
                   System.out.print("Valor no valido");
                   break;
       }
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
