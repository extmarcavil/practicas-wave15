package modelo;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
    }

    public void socorre(Auto unAuto){
        System.out.println("Socorriendo auto con patente: " + unAuto.getPatente());
    }
}
