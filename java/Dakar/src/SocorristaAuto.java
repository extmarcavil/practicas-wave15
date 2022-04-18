public class SocorristaAuto extends VehiculoSocorrista<Autos>{

    public void socorrer(Autos unAuto){

        System.out.println("Socorriendo auto con patente: " + unAuto.getPatente());
    }
}
