package POO;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 24, "12345678");
        Persona persona3 = new Persona("Pedro", 30, "87654321", 100, 1.7);

        System.out.println(persona3);

        switch(persona3.calcularIMC()) {
            case -1:
                System.out.println("BAJO PESO");
                break;
            case 0:
                System.out.println("PESO SALUDABLE");
                break;
            case 1:
                System.out.println("SOBREPESO");
                break;
        }

        if(persona3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }
    }
}
