public class Main {

    public static void main(String[] args) {

        Serie1<Double>  ob1 = new Serie1<>(2.1, 2,4);
        Serie1<Double>  ob2 = new Serie1<>(1, 2 , 4);
        Serie1<Double>  ob3 = new Serie1<>(3, 3 , 4 );



           ob1.devolverSiguiente(ob1.valorInicial, ob1.numSerie, ob1.cantidad);
           ob2.devolverSiguiente(ob2.valorInicial, ob2.numSerie, ob2.cantidad);
           ob3.devolverSiguiente(ob3.valorInicial, ob3.numSerie, ob3.cantidad);




           ob1.reiniciar();
           ob1.devolverSiguiente(ob1.valorInicial, ob1.numSerie, ob1.cantidad);







    }
}
