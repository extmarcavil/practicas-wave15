package ejerciciosObjetos;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Gonzalo",27,"2317216");
        Persona p3 = new Persona("Gonzalo",27,"2317216",72,182);
        System.out.println(p3.cacularIMC());
        System.out.println(p3.esMayorDeEdad());
        System.out.println(p3.toString());
    }

}
