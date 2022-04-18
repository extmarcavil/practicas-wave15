package ejercicio3;

public class Vaca extends Animal implements ComerHierba{

    @Override
    void sonido() {
        System.out.println("Muuu");
    }

    @Override
    void serComido() {
        System.out.println("Comiendo una vaca...");
    }

    @Override
    public void comerHierba(String hierba) {
        System.out.println("Comiendo " + hierba);
    }
}
