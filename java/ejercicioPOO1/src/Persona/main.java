package Persona;

public class main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Gonzalo", 28, "37786097");
        Persona persona3 = new Persona("Maria", 27, "2333333", 1.75, 75.5);
        //Persona persona4 = new Persona("Jose", 23); --> da error al faltar parámetros y no encontrar un constructor acorde.

        int imc;
        imc = persona3.calcularImc();
        if (imc == -1)
            System.out.println("La persona tiene bajo peso.");
        else
            if (imc == 0)
                System.out.println("La persona tiene peso saludable.");
            else
                System.out.println("La persona tiene sobrepeso.");

        boolean mayoriaDeEdad = persona3.esMayorDeEdad();
        if (mayoriaDeEdad == true)
            System.out.println("La persona es mayor de edad.");
        else
            System.out.println("La persona es menor de edad.");

        System.out.println("\n" + persona3.toString());



    }
}
