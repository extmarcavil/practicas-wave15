package models;

import java.util.ArrayList;
import java.util.List;

public class Flota extends Jugador {
    private List<NaveSimple> naves;

    public Flota() {
        this.naves = new ArrayList<>();
    }

    @Override
    public Float atacarCoordenadas(Float x, Float y) {
        return this.naves
                .stream()
                .map(n -> n.atacarCoordenadas(x,y))
                .reduce(0F, Float::sum)
                / this.naves.size();
    }

    @Override
    public String toString() {
        return "Flota{" +
                "naves=" + naves +
                '}';
    }

    @Override
    public void imprimirCoordenadasGanadas() {
        System.out.println(this + " " + this.getCoordenadasGanadas());
    }

    public void addNave(NaveSimple nave) {
        this.naves.add(nave);
    }
}
