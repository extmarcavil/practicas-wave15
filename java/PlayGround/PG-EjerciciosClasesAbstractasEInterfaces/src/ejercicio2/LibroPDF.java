package ejercicio2;

public class LibroPDF extends Documento {
    int cantidadDePáginas;
    String nombreDelAutor;
    String título;
    String género;


    public LibroPDF(int cantidadDePáginas, String nombreDelAutor, String título, String género) {
        this.cantidadDePáginas = cantidadDePáginas;
        this.nombreDelAutor = nombreDelAutor;
        this.título = título;
        this.género = género;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF{" +
                "cantidadDePáginas=" + cantidadDePáginas +
                ", nombreDelAutor='" + nombreDelAutor + '\'' +
                ", título='" + título + '\'' +
                ", género='" + género + '\'' +
                '}');
    }
}
