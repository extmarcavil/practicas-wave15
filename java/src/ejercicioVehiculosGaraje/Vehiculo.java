package ejercicioVehiculosGaraje;

public class Vehiculo{
    private String marca;
    private String modelo;
    private int costo;

    public Vehiculo(String marca, String modelo, int costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo {" +
                "Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Costo=" + costo +
                '}';
    }
}
