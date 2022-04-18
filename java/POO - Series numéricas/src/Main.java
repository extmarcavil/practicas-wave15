public class Main {
    public static void main(String[] args) {

        SerieParametrizada serie = new SerieParametrizada(1,250); // Se le pasa por parámetro valor inicial y el intervalo que caracterizará a la serie.

        System.out.println(serie.getValorActual());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println("--Reiniciando serie--");
        serie.reiniciarSerie();
        System.out.println(serie.getValorActual());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println("--Estableciendo otro valor inicial--");
        serie.establecerValorInicial(10);
        System.out.println(serie.getValorActual());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());
        System.out.println(serie.calcularValorSiguiente());


    }
}
