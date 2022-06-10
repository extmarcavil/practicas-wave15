public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carlos",26,"1239isa");
        Persona persona3 = new Persona("Jhony",30,"2is23a",87.0,1.90);

        System.out.println(persona3.toString());
        System.out.println(persona3.esMayorDeEdad(30));
        System.out.println(persona3.calcularIMC(87,1.90));
    }
}
