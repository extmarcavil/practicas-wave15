package ejercicioAgenciaTurismo;

public class Boleto {
    private String origen;
    private String destino;
    private double precio;

    public Boleto(String origen, String destino, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" +
                "Origen='" + origen + '\'' +
                ", Destino='" + destino + '\'' +
                ", Precio=" + precio +
                '}';
    }
}
