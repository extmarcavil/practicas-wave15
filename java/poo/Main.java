package poo;

public class Main {
    public static void main(String[] args) {
            Persona juan = new Persona();
            Persona pepe = new Persona("Pepe",23,"14.222.111-3");
            Persona roberto = new Persona("Roberto",25,"11.222.344-3",58.4f,164.3f);
            //Persona lucius = new Persona ("lucius",23);
            //envia error al crear intentar crear un objeto con un constructor no definido
        System.out.println(roberto.calcularIMC());
        System.out.println(roberto.toStringComplete());

    }
}
