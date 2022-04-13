package Ejercicio2;

public class Impresora implements TipoDocumento {
    public static void imprimir(TipoDocumento documento){
        System.out.println(documento.toString());
    }
}
