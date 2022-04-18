public class Main {

    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();
        Persona personaConDatosBasicos = new Persona("Sofia Cot", 23, "41588710");
        Persona personaConDatosDetallados = new Persona("Juan Perez", 25, "38566565", 80.0, 1.85);

        int imc = personaConDatosDetallados.calcularIMC();
        boolean esMayorDeEdad = personaConDatosDetallados.esMayorDeEdad();

        System.out.println("Nombre: " + personaConDatosDetallados.nombre);
        System.out.println("Edad: " + personaConDatosDetallados.edad);
        System.out.println("Dni: " + personaConDatosDetallados.dni);
        System.out.println("Peso: " + personaConDatosDetallados.peso);
        System.out.println("Altura: " + personaConDatosDetallados.altura);

        String resultadoIMC;

        if(imc == 0)
            resultadoIMC = "Peso Saludable";
        else if(imc == 1)
            resultadoIMC = "Sobrepeso";
        else
            resultadoIMC = "Bajo peso";

        System.out.println("Índice de masa corporal (IMC): " + resultadoIMC);

        if(esMayorDeEdad)
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona es menor de edad");
    }
}
