public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Pedro", 54, "234234");
        Persona p3 = new Persona("Alvaro", 54, "234234", 78.8, 1.83);
       // Persona p4 = new Persona("nombre", 32); // se necesita crear un constructor

        if(p3.calcularIMC() == -1){
            System.out.println("Se encuentra con bajo peso.");
        } else {
            if(p3.calcularIMC() == 1){
                System.out.println("Se encuentra con sobrepeso.");
            } else {
                System.out.println("Se encuentra con un peso saludable.");
            }
        }

        if(p3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        System.out.println(p3);
    }
}
