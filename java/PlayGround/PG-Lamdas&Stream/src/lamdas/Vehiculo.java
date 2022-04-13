package lamdas;

public class Vehiculo {
    // Inicia creando una clase Vehículo con los atributos modelo,
    // marca y costo.
    // Crea además los constructores de las clases y los métodos Setter y Getter.

    protected String modelo;
    protected String marca;
    protected Double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Modelo = " + modelo + "\t\t|" +
                " Marca = " + marca + "\t\t|" +
                " Costo = " + costo;
    }
}
