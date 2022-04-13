package model;

public class SocorristaAuto extends Socorrista<Auto> {

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto "+vehiculo.getPatente());
    }
}
