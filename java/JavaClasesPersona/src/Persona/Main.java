package Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaTresAtribs = new Persona("Persona2", 20, "123");
        Persona personaCompleto = new Persona("Persona3", 20, "123", 80.0f, 1.70f);

        System.out.println(personaCompleto);

        int imc = personaCompleto.calcularIMC();
        if (imc == -1){
            System.out.println(personaCompleto.getNombre() + " tiene peso bajo.");
        } else if (imc == 0){
            System.out.println(personaCompleto.getNombre() + " tiene peso adecuado.");
        } else {
            System.out.println(personaCompleto.getNombre() + " tiene sobrepeso.");
        }

        if (personaCompleto.esMayorDeEdad()){
            System.out.println(personaCompleto.getNombre() + " es mayor de edad.");
        } else {
            System.out.println(personaCompleto.getNombre() + " es menor de edad.");
        }
    }
}
