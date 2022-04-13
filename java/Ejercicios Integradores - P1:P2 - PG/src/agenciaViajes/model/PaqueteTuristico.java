package agenciaViajes.model;

public class PaqueteTuristico {
    //reservas de hotel, comida, boletos de viajes y transporte
    private int id;
    private Hotel hotel;
    private boolean comida;
    private Boleto boletos;
    private boolean transporte;

    public PaqueteTuristico(int id) {
        this.id = id;
    }

    public PaqueteTuristico(int id, Hotel hotel, boolean comida, Boleto boletos, boolean transporte) {
        this.id = id;
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public Boleto getBoletos() {
        return boletos;
    }

    public void setBoletos(Boleto boletos) {
        this.boletos = boletos;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte=" + transporte +
                '}';
    }
}
