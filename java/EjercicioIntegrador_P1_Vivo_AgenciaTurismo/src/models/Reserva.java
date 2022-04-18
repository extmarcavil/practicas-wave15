package models;

public class Reserva {

    private  String hotel;
    private  String comida;
    private  String boletosDeViaje;
    private  String transporte;

    public Reserva() {
    }

    public Reserva(String hotel, String comida, String boletosDeViaje, String transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletosDeViaje = boletosDeViaje;
        this.transporte = transporte;
    }

    public boolean reservaCompleta(){
        return hotel != null && comida != null && boletosDeViaje != null && transporte != null;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public void setBoletosDeViaje(String boletosDeViaje) {
        this.boletosDeViaje = boletosDeViaje;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel='" + hotel + '\'' +
                ", comida='" + comida + '\'' +
                ", boletosDeViaje='" + boletosDeViaje + '\'' +
                ", transporte='" + transporte + '\'' +
                '}';
    }
}
