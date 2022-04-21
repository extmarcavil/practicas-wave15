package series;

import java.util.ArrayList;

public abstract class Prototipo <T extends Number> {
    ArrayList<T> serie;

    public void reiniciarSerie(){
        serie = new ArrayList<>();
    }

    public void asignarValorInicial(T valor){
        reiniciarSerie();
        insertarValor(valor);
    }

    protected void insertarValor(T valor){
        serie.add(valor);
    }

    protected T devolverUltimo(){
        return serie.get(serie.size()-1);
    }

    public abstract T devolverSiguiente();
}
