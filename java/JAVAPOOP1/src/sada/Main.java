package sada;

public class Main {
    public static void main(String[] args) {
        Persona julieta;
        Persona nicolas;
        Persona boris;

        boris = new Persona();
        nicolas = new Persona("nicolas", 24, "238472");
        julieta = new Persona("julieta", 27, "3234342", 55, 1.65);

        System.out.println(julieta.getNombre());
        System.out.println(julieta.getDni());
        System.out.println(julieta.getEdad());
        System.out.println(julieta.getAltura());
        System.out.println(julieta.getPeso());

        System.out.println(nicolas.getAltura());

        System.out.println(julieta.calcularIMC(julieta.getPeso(), julieta.getAltura()));
        System.out.println(julieta.esMayorDeEdad(julieta.getEdad()));
        System.out.println(julieta.toString());
    }
}
