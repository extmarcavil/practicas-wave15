package GenericsWrapperLambdaYStreams;

public class Vehiculo {

    private String marca;
    private String modelo;
    private double costo;

    public Vehiculo(String marca, String modelo, double costo) {
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(marca).append("\n");
        sb.append("Modelo: ").append(modelo).append("\n");
        sb.append("Costo: ").append(costo).append("\n");
        return sb.toString();
    }
}
