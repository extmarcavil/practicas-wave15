public class Producto {
    //region Atributos
    private  int Codigo;
    private  String Nombre;
    private  int Cantidad;
    private  double CostoUnitario;
    //endregion

    //region Constructor

    public Producto(int codigo, String nombre, int cantidad, double costoUnitario) {
        Codigo = codigo;
        Nombre = nombre;
        Cantidad = cantidad;
        CostoUnitario = costoUnitario;
    }

    //endregion

    //region Getters setters

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        CostoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Codigo=" + Codigo +
                ", Nombre='" + Nombre + '\'' +
                ", Cantidad=" + Cantidad +
                ", CostoUnitario=" + CostoUnitario +
                '}';
    }

    //endregion
}
