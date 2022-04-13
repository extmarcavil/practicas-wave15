package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Basico b = new Basico(true, 1000);
        Basico a = new Basico(false, 5000);


        b.consultaSaldo();
        b.depositos();
        a.consultaSaldo();
        b.transferencias();

    }
}
