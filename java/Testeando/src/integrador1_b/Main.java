package integrador1_b;

public class Main {
    public static void main(String[] args) {
        PrototipoInt pInt = new PrototipoInt(0,3);

        for (int i = 0; i < 5; i++){
            System.out.println(pInt.increment());
        }

        System.out.println("_______________");
        PrototipoDouble pDouble = new PrototipoDouble(15.5,1.5);
        for (int i = 0; i < 5; i++){
            System.out.println(pDouble.increment());
        }

        /*DeATres tres = new DeATres(0);
        System.out.println("_____________");

        System.out.println(tres.increment());
        System.out.println(tres.increment());
        System.out.println(tres.increment());
        System.out.println(tres.increment());
        tres.reiniciar();
        System.out.println(tres.increment());
        tres.setInicial(50);
        System.out.println(tres.increment());*/
    }
}
