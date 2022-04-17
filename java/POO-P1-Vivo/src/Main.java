
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 20, "123456");
        Persona persona3 = new Persona("Carlos", 25, "654321", 70.5f, 1.80f);

        System.out.println("El IMC es de: " + persona3.calcularIMC());

        if (persona3.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        }else{
            System.out.println("La persona es menor de edad.");
        }

        System.out.println("Los datos de la persona son los siguientes: " + persona3.toString()+".");
    }
}
