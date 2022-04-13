package models;

public class Reserva {
    private String hotel;
    private String comida;
    private String boletosDeViaje;
    private String transporte;

    public boolean isCompleta() {
        return hotel != null && comida != null && boletosDeViaje != null && transporte != null;
    }

    public void imprimir() {
        System.out.println(this.toString());
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

    public boolean hasBoletoDeViaje() {
        return this.boletosDeViaje != null;
    }

    public boolean hasReservaDeHotel() {
        return this.hotel != null;
    }
}
