public class SocorristaMoto extends VehiculoSocorrista<Motos>{

    public void socorrer(Motos unaMoto){

        System.out.println("Socorriendo moto con patente: " + unaMoto.getPatente());
    }
}
