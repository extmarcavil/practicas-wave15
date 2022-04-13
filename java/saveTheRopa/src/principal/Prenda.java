package principal;

public class Prenda {

    //Las pertenencias se representan en el sistema mediante algo abstracto llamado prenda,
    //que tiene marca y modelo, de modo que si la persona pierde el número también podría en
    //algún momento poder llegar a reclamarlo con dicha información. Sin embargo, el reclamo
    //será modelado en otro momento.
    //
    //1. Crear la clase Prenda que contenga las variables marca y modelo, ambos de tipo
    //String.

    protected String marca;
    protected String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return  "Marca :" + marca + " | " + "Modelo : " + modelo;
    }
}
