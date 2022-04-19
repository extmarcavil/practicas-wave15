package EjercicioIntegrador.SeriesNumericas;

public abstract class Prototipo {
    protected int serie;
    protected int iniciador;

    protected Prototipo() {
    }

    public Prototipo(int serie) {
        this.serie = serie;
    }

    public abstract void siguienteSerie();
    public abstract void iniciarSerie(int iniciador);

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getIniciador() {
        return iniciador;
    }

    public void setIniciador(int iniciador) {
        this.iniciador = iniciador;
    }
}
