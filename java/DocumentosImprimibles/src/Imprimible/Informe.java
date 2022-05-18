package Imprimible;

public class Informe extends Documento{
    private int Longitud;
    private int CantPaginas;
    private String Autor;
    private String Revisor;

    public int getLongitud() {
        return Longitud;
    }

    public void setLongitud(int longitud) {
        Longitud = longitud;
    }

    public int getCantPaginas() {
        return CantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        CantPaginas = cantPaginas;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getRevisor() {
        return Revisor;
    }

    public void setRevisor(String revisor) {
        Revisor = revisor;
    }

    public Informe(int longitud, int cantPaginas, String autor, String revisor) {
        Longitud = longitud;
        CantPaginas = cantPaginas;
        Autor = autor;
        Revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "Longitud=" + Longitud +
                ", CantPaginas=" + CantPaginas +
                ", Autor='" + Autor + '\'' +
                ", Revisor='" + Revisor + '\'' +
                '}';
    }
}
