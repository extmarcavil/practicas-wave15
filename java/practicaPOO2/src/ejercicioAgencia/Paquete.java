package ejercicioAgencia;

import java.util.ArrayList;

public class Paquete {
    private ArrayList<ReservaHotel> hoteles;
    private ArrayList<ReservaComida> comidas;
    private ArrayList<ReservaBoleto> boletos;
    private ArrayList<ReservaTransporte> transportes;

    public Paquete(ArrayList<ReservaHotel> hoteles, ArrayList<ReservaComida> comidas, ArrayList<ReservaBoleto> boletos, ArrayList<ReservaTransporte> transportes) {
        this.hoteles = hoteles;
        this.comidas = comidas;
        this.boletos = boletos;
        this.transportes = transportes;
    }

    public ArrayList<ReservaHotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<ReservaHotel> hoteles) {
        this.hoteles = hoteles;
    }

    public ArrayList<ReservaComida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<ReservaComida> comidas) {
        this.comidas = comidas;
    }

    public ArrayList<ReservaBoleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<ReservaBoleto> boletos) {
        this.boletos = boletos;
    }

    public ArrayList<ReservaTransporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(ArrayList<ReservaTransporte> transportes) {
        this.transportes = transportes;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "hoteles=" + hoteles +
                ", comidas=" + comidas +
                ", boletos=" + boletos +
                ", transportes=" + transportes +
                '}';
    }
}
