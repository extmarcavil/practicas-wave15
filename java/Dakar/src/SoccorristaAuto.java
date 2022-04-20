public class SoccorristaAuto implements Socorrista <Autos>{

    @Override
    public void socorrer(Autos auto) {
        System.out.println("Socorriendo Auto" + auto.getPatente());
    }
}
