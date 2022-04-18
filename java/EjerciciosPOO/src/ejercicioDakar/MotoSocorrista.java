package ejercicioDakar;

public class MotoSocorrista extends VehiculoSocorrista<Moto>{
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo auto - Patente: " + moto.getPatente());
    }
}
