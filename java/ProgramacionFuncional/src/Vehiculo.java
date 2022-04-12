public class Vehiculo {

    //region Atributos
    private String Modelo;

    private String  Marca;

    private int Costo;
    //endregion

    //region Constructor
    public Vehiculo(String modelo, String marca, int costo) {
        Modelo = modelo;
        Marca = marca;
        Costo = costo;
    }

    //endregion

    //region Getters Setters

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int costo) {
        Costo = costo;
    }
    //endregion
}
