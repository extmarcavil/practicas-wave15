package ejercicios;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 20, "42132458");
        Persona persona3 = new Persona("Camila", 25, "40009876", 68, 1.72);

        Persona persona4 = new Persona("Luciana", 30);

        int imc = persona3.calcularIMC();
        if (imc == -1)
            System.out.println("Índice de masa corporal (IMC): Por debajo de 20 - Nivel de peso: Bajo peso");
        else if (imc == 0)
            System.out.println("Índice de masa corporal (IMC): Entre 20 y 25 inclusive - Nivel de peso: Peso saludable");
        else
            System.out.println("Índice de masa corporal (IMC): Mayor de 25 - Nivel de peso: Sobrepeso");

        if(persona3.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

        persona3.toString();
    }
}
