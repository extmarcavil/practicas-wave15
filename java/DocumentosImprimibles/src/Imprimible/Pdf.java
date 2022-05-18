package Imprimible;

public class Pdf extends Documento{
    private String NombrePDF;
    private String NombreAutor;
    private String Genero;
    private int CantPaginas;

    public String getNombrePDF() {
        return NombrePDF;
    }

    public void setNombrePDF(String nombrePDF) {
        NombrePDF = nombrePDF;
    }

    public String getNombreAutor() {
        return NombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        NombreAutor = nombreAutor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getCantPaginas() {
        return CantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        CantPaginas = cantPaginas;
    }

    public Pdf(String nombrePDF, String nombreAutor, String genero, int cantPaginas) {
        NombrePDF = nombrePDF;
        NombreAutor = nombreAutor;
        Genero = genero;
        CantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "Pdf{" +
                "NombrePDF='" + NombrePDF + '\'' +
                ", NombreAutor='" + NombreAutor + '\'' +
                ", Genero='" + Genero + '\'' +
                ", CantPaginas=" + CantPaginas +
                '}';
    }
}
