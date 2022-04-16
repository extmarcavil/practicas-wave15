package SaveTheRopa;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda() {
    }

    @Override
    public String toString() {
        return "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'';
    }

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
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
}
