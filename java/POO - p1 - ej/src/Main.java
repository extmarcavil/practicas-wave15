public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("luis",30,"35634587");
        Persona p3 = new Persona("juan",17,"30557665",50,1.7);

        System.out.println(p3);
        System.out.println(p3.calcularIMC());
        System.out.println(p3.esMayorDeEdad());
    }
}
