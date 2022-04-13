public class SocorrerMoto extends VehiculoSocorrista<Moto>{
    @Override
    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
