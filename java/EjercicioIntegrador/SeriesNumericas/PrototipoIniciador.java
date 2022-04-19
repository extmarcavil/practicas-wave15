package EjercicioIntegrador.SeriesNumericas;

public class PrototipoIniciador extends Prototipo {

    public PrototipoIniciador() {
        int iniciador = 0;
    }

    @Override
    public void iniciarSerie(int iniciador){
        this.iniciador = iniciador;
    }

    @Override
    public void siguienteSerie() {
        for (int i = 0; i <serie ; i++) {
            iniciador += 1;
        }
        System.out.println(iniciador);
    }
}
