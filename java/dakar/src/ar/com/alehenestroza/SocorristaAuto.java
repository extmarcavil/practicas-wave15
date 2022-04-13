package ar.com.alehenestroza;

public class SocorristaAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto.");
    }
}
