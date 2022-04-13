package Clases;

public class Serie extends Prototipo{

    private Number iniciador;
    private Number siguiente;

    public Serie(Number iniciador) {
        this.iniciador = iniciador;
        this.siguiente = iniciador;
    }

    @Override
    Number siguiente_valor() {
        Number contenedor = siguiente;
        siguiente = contenedor.intValue() + iniciador.intValue();
        return contenedor;
    }

    @Override
    void reinciar_serie() {
        this.siguiente = iniciador;
    }

    @Override
    void inicializar(Integer numero) {
        this.siguiente = numero;
    }
}
