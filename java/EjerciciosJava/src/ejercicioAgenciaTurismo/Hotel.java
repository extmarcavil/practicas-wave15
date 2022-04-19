package ejercicioAgenciaTurismo;

public class Hotel {
    private String nombreHotel;
    private double precio;

    public Hotel(String nombreHotel, double precio) {
        this.nombreHotel = nombreHotel;
        this.precio = precio;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{Nombre='" + nombreHotel + '\'' +
                ", Precio=" + precio +
                '}';
    }
}
