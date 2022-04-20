public class SocorristaMoto implements Socorrista<Motos>{

    @Override
    public void socorrer(Motos unaMoto){
        System.out.println("Socorriendo Moto" + unaMoto.getPatente());
    }
}
