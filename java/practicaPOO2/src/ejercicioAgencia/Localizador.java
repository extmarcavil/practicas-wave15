package ejercicioAgencia;

import java.util.ArrayList;

public class Localizador {
    private Paquete paquete;
    private double total;

    public Localizador(Paquete paquete) {
        this.paquete = paquete;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "paquete=" + paquete +
                ", total=" + total +
                '}';
    }
}
