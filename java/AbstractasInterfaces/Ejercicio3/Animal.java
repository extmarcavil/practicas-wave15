package AbstractasInterfaces.Ejercicio3;

public abstract class Animal {

    private String sonido;


    public Animal(String sonido) {
        this.sonido = sonido;
    }

    public void hablar() {
        System.out.println(sonido);
    }

}
