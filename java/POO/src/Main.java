public class Main {
    public static void main(String[] args) {

        //Hago 3 instancias, haciendo referencia a los 3 constructores que hice para la clase Persona
        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Thiago",21,"42885742");

        Persona persona3 = new Persona("Thiago",21,"42885742",80,1.80);

        var MC_Persona = persona3.calcularMC(persona3.peso,persona3.altura);
        var MayorEdad = persona3.esMayorDeEdad(persona3.edad);
        var MayorMenor = MayorEdad == true ? "Mayor" : "Menor";

        //System.out.println(persona3.nombre + " tiene " +persona3.edad + " años, por lo que podemos decir que es " + MayorMenor);
        System.out.println(persona3.toString() + "\nPor sus datos, podemos afirmar que es " + MayorMenor);
    }
}