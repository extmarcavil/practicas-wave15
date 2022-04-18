package ejercicioAgencia;

import java.util.ArrayList;

public class Paquete {
    private ArrayList<Reserva> lstReservas;

    public Paquete(ArrayList<Reserva> lstReservas) {
        this.lstReservas = lstReservas;
    }

    public ArrayList<Reserva> getLstReservas() {
        return lstReservas;
    }

    public void setLstReservas(ArrayList<Reserva> lstReservas) {
        this.lstReservas = lstReservas;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "lstReservas=" + lstReservas +
                '}';
    }
}
