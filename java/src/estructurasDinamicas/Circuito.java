package estructurasDinamicas;

import java.util.ArrayList;

public class Circuito {

    public Character getCategoria() {
        return categoria;
    }

    public int getKm() {
        return km;
    }

    public int getPrecio_menores() {
        return precio_menores;
    }

    public int getPrecio_mayores() {
        return precio_mayores;
    }

    public int getSize(){
        return listaParticipantes.size();
    }

    private Character categoria;
    private int km;
    private int precio_menores;
    private int precio_mayores;

    public ArrayList<Persona> getListaParticipantes() {
        return listaParticipantes;
    }

    public void addParticipante(Persona p) {
        this.listaParticipantes.add(p);
    }

    private ArrayList<Persona> listaParticipantes;

    public Circuito(Character categoria, int km, int precio_menores, int precio_mayores) {
        this.categoria = categoria;
        this.km = km;
        this.precio_menores = precio_menores;
        this.precio_mayores = precio_mayores;
        this.listaParticipantes = new ArrayList<>();
    }
}
