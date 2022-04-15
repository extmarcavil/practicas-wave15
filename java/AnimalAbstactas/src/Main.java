public class Main {

    public static void main(String[] args){

        Perro coco = new Perro();
        coco.emitirSonido();
        coco.comerCarne();

        Gato michi = new Gato();
        michi.emitirSonido();
        michi.comerCarne();

        Vaca lola = new Vaca();
        lola.emitirSonido();
        lola.comerHierba();
    }
}
