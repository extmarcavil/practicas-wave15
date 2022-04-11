package ejercicio2;

public class Informe implements Imprimible {
    String texto;
    String autor;
    String revisor;

    @Override
    public void imprimir() {
        System.out.println(texto);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
