package EjercicioIntegrador.SeriesNumericas;

public class PrototipoIniciadorReset extends Prototipo{

    public PrototipoIniciadorReset() {
        int iniciador = 0;
    }

    public void reset(){
        iniciador = 0;
    }

    @Override
    public void siguienteSerie() {
        for (int i = 0; i <serie ; i++) {
            iniciador += 1;
        }
        System.out.println(iniciador);
    }

    @Override
    public void iniciarSerie(int iniciador) {
        this.iniciador = iniciador;
    }
}
