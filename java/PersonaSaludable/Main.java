package PersonaSaludable;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Wendy", 27, "38135561");
        Persona persona3 = new Persona("Wendy", 27, "38135561", 60, 1.57);

        int IMC = persona3.cacularIMC();
        boolean mayor = persona3.esMayorDeEdad();
        String persona = persona3.toString();

        System.out.println(persona);

        if (IMC == -1) {
            System.out.println("Índice de masa corporal (IMC) por debajo de 20. Bajo peso.");
        } else if ( IMC == 0){
            System.out.println("Índice de masa corporal (IMC) entre 20 y 25. Peso Saludable.");
        } else {
            System.out.println("Índice de masa corporal (IMC) mayor a 25. Sobrepeso.");
        }

        if (mayor) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }
    }
}
