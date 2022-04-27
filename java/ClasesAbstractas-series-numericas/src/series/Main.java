package series;

public class Main {

    public static void main(String[] args){
        SerieDos serieDos = new SerieDos(13);
        SerieTres serieTres = new SerieTres(-6.0);

        System.out.println("----IMPRIMIENDO DE A DOS----");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.devolverSiguiente());
        }
        System.out.println("----------------------------");
        System.out.println("\n----IMPRIMIENDO DE A TRES----");

        for (int i = 0; i < 5; i++) {
            System.out.println(serieTres.devolverSiguiente());
        }

        System.out.println("----------------------------");
    }
}
