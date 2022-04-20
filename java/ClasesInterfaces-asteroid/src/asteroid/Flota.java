package asteroid;

import java.util.ArrayList;

public class Flota implements Navegable{

    ArrayList<Nave> flota = new ArrayList<>();

    public Flota(ArrayList<Nave> flota) {
        this.flota = flota;
    }

    public ArrayList<Nave> getFlota() {
        return flota;
    }

    public void addNave(Nave nave){
        flota.add(nave);
    }

    @Override
    public double medirDistancia(int x, int y) {
        double distancias = 0;
        for (int i = 0; i < getFlota().size(); i++) {
            distancias += getFlota().get(i).medirDistancia(x, y);
        }

        return distancias / getFlota().size();
    }
}
