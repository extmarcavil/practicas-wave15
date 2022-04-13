public class Prenda {
    //region Atributos
    private String Marca;
    private String Modelo;

    //endregion

    //region Constructor
    public Prenda(String marca, String modelo) {
        Marca = marca;
        Modelo = modelo;
    }
    //endregion

    //region getter setters

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    @Override
    public String toString() {
        return "{" +
                "Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }

    //endregion
}
