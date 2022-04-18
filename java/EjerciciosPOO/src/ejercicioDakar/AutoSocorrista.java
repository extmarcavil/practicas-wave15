package ejercicioDakar;

public class AutoSocorrista extends VehiculoSocorrista<Auto> {
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto - Patente: " + auto.getPatente());
    }
}
