package Abstractas;

import java.util.List;

public abstract class Prototipo {

    private List<Integer> serie;
    private int deCuanto;

    public Prototipo(List<Integer> serie, int deCuanto){
        this.serie = serie;
        this.deCuanto = deCuanto;
    }

    public void setSerie(List<Integer> lista){
        this.serie = lista;
    }

    public void setDeCuanto(int deCuanto){
        this.deCuanto = deCuanto;
    }

    public List<Integer> getSerie(){
        return this.serie;
    }

    public int getDeCuanto(){
        return this.deCuanto;
    }

    public int valorSiguiente(){
        int ultIndice = this.serie.size() - 1;
        int ultValor = this.serie.get(ultIndice);
        this.serie.add(ultValor + this.deCuanto);
        return this.serie.get(ultIndice);
    }

    public void reiniciarSerie(){
        this.serie.clear();
        this.deCuanto = 0;
    }

    public void establecerInicio(int inicio){
        this.serie.add(inicio);
    }

}
