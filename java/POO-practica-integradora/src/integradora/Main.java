package integradora;

public class Main {

        public static void main(String[] args) {
            Persona persona1 = new Persona();
            Persona persona2 = new Persona("Pepito", 13, "123");
            Persona persona3 = new Persona("Juan", 18, "987", 69, 1.78);

//            Persona persona2 = new Persona("Pepito", 13); Error!

            System.out.println("***Datos del paciente***\n");
            System.out.println(persona3.toString());

            System.out.print("IMC: ");

            double imc = persona3.calcularIMC();
            if(imc == -1) System.out.println("Bajo peso");
            else if(imc == 0) System.out.println("Peso saludable");
            else System.out.println("Sobrepeso");

            System.out.print("Edad: ");

            boolean mayorEdad = persona3.esMayorDeEdad();
            if(mayorEdad) System.out.println("Mayor de edad");
            else System.out.println("Menor de edad");
        }
}
