package modelo;

public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
    }

    public void socorre(Moto unaMoto){
        System.out.println("Socorriendo moto con patente: " + unaMoto.getPatente());
    }
}
