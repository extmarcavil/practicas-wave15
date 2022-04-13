public class SocorristaMoto  implements SocorrerVehiculo <Moto>{


    @Override
    public void socorrer(Moto  moto) {
        System.out.println("Socorriendo moto: " + moto.getPatente());

    }
}
