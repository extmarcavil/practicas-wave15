package EjercicioIntegrador.EjercicioDakar;

public class Autos extends Vehiculo{
    private int ruedas = 4;
    private int peso = 2;
    public Autos(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }
}
