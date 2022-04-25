package ClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> clase2 = new Implementacion2<>();
        Prototipo<Integer> clase3 = new Implementacion3<>();

        System.out.println(clase2.valorSiguiente());
        System.out.println(clase2.valorSiguiente());
        System.out.println(clase2.valorSiguiente());
        System.out.println(clase2.valorSiguiente());

        clase3.setValorInicial(1);
        System.out.println(clase3.valorSiguiente());
        System.out.println(clase3.valorSiguiente());
        System.out.println(clase3.valorSiguiente());
        System.out.println(clase3.valorSiguiente());
    }
}
