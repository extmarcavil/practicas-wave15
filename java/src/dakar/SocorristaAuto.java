package dakar;

public class SocorristaAuto implements Socorrista<Auto>{

    @Override
    public void socorrer(Auto v) {
        System.out.println("Socorriendo auto " + v.getPatente());
    }
}
