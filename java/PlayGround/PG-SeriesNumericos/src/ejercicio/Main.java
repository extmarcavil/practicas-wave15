package ejercicio;

public class Main {

    public static void main(String[] args) {

        SerieEnteros unaSerieEntero = new SerieEnteros(1,2);
        System.out.println("Serie desde 1 de pasos en 2 en 2");
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        unaSerieEntero.reiniciarSerie();
        System.out.println("Serie desde 1 de pasos en 2 en 2");
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        unaSerieEntero.reiniciarSerie();
        unaSerieEntero.definirValorInicial(5);
        System.out.println("Serie desde 5 de pasos en 2 en 2");
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());
        System.out.println(unaSerieEntero.obtenerProximoNumero());

        SerieDouble unaSerieDouble = new SerieDouble(1.5,1.5);
        System.out.println("Serie desde 1,5 de pasos en 1.5");
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        unaSerieDouble.reiniciarSerie();
        System.out.println("Serie desde 1.5 de pasos en 1.5");
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        unaSerieDouble.reiniciarSerie();
        unaSerieDouble.definirValorInicial(5D);
        System.out.println("Serie desde 5 de pasos en 1.5");
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());
        System.out.println(unaSerieDouble.obtenerProximoNumero());


    }
}
