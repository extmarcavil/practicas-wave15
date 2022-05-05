public class Vehiculo {
    private String marca;
    private String modelo;
    private Integer costo;

    public Vehiculo(String marca, String modelo, Integer costo) {
        this.marca = marca;
        this.modelo = modelo;
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

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " $" + costo;
    }
}
