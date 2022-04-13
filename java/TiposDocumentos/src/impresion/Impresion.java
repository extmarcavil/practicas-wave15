package impresion;

public interface Impresion {
    public void mostrar();
    public static void imprimir(Impresion doc) {
        doc.mostrar();
    }
}
