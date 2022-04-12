package Imprimible;

public class Informe extends Documento {
    private int longitud;
    private int cantidadPaginas;
    private String nombre;
    private String revisor;

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informe(int longitud, int cantidadPaginas, String nombre, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.nombre = nombre;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "longitud=" + longitud +
                ", cantidadPaginas=" + cantidadPaginas +
                ", nombre='" + nombre + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
