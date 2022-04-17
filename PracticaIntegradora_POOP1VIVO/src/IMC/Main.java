package IMC;

public class Main {
    public static void main(String[] args) {
        Persona.Persona persona1 = new Persona.Persona();
        Persona.Persona persona2 = new Persona.Persona("carlos", 19, "1234");
        Persona.Persona persona3  = new Persona.Persona("carlos", 19, "1234", 80, 1.90);


        int imcP3 = persona3.calcularIMC();

        switch (imcP3){
            case -1:
                System.out.println("Bajo peso");
            case 0:
                System.out.println("Peso saludable");
            case 1:
                System.out.println("Sobre peso");
        }

        System.out.println(persona3.toString());

    }
}
