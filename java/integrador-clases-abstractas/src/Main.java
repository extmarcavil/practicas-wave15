public class Main {
    public static void main(String[] args) {
        Serie2<Integer> serie2Integer = new Serie2<>( 0);
        Serie2<Double> serie2Doble = new Serie2<>(5.5);

        Serie3<Float> serie3Float = new Serie3<Float>(1.5f);
        Serie3<Long> serie3Long = new Serie3<Long>(1500L);

        System.out.println("Serie 2 de enteros, empieza en 0");
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());

        System.out.println("Serie 2 de dobles, empieza en 5.5");
        System.out.println(serie2Doble.proximoNumero());
        System.out.println(serie2Doble.proximoNumero());
        System.out.println(serie2Doble.proximoNumero());
        System.out.println(serie2Doble.proximoNumero());
        System.out.println(serie2Doble.proximoNumero());

        System.out.println("Serie 3 de floats, empieza en 1.5");
        System.out.println(serie3Float.proximoNumero());
        System.out.println(serie3Float.proximoNumero());
        System.out.println(serie3Float.proximoNumero());
        System.out.println(serie3Float.proximoNumero());
        System.out.println(serie3Float.proximoNumero());

        System.out.println("Serie 3 de longs, empieza en 1500");
        System.out.println(serie3Long.proximoNumero());
        System.out.println(serie3Long.proximoNumero());
        System.out.println(serie3Long.proximoNumero());
        System.out.println(serie3Long.proximoNumero());
        System.out.println(serie3Long.proximoNumero());

        System.out.println("Seteo valor inicial de serie 2 de enteros a 15");
        serie2Integer.setValorInicial(15);
        System.out.println("Reinicio serie 2 de enteros y comienzo a recorrer nuevamente");
        serie2Integer.reiniciarSerie();
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());
        System.out.println(serie2Integer.proximoNumero());

    }

}
