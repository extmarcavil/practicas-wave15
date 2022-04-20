package Ejercicio3;

public abstract class Animal {

    private String sonido;

    public Animal(String sonido){
        this.sonido = sonido;
    }

    public void emitirSonido(){
        System.out.println(sonido);
    }

    public void comerAnimal(){

    }
}
