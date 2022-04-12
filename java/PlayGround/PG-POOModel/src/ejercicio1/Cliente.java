package ejercicio1;


public abstract class Cliente {

    protected boolean tieneDatosEnRegla;

    protected Cliente(boolean tieneDatosEnRegla) {
        this.tieneDatosEnRegla = tieneDatosEnRegla;
    }

    public boolean tieneDatosEnRegla(){
        return tieneDatosEnRegla;
    }

    public abstract String nombre();
}
