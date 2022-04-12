package Ejercicio2;

public class Impresora implements Imprimible<Documento> {
    @Override
    public void imprimir(Documento documento) {
        System.out.println("Imprimiendo " + documento.mostrarTipoDocumento());
        System.out.println(documento.imprimirContenido());
    }
}
