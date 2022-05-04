public class App {
    public static void main(String[] args) {
        Persona personaSinDatos = new Persona();
        Persona personaAlgunosDatos = new Persona("Tomas", 23, "40905305" );
        Persona personaTodosLosDatos = new Persona("Tomas", 23, "40905305", 90, 1.83f);

        //Persona personaError = new Persona("Tomas", 23 );

        float imc = personaTodosLosDatos.cacularIMC();
        boolean esMayorDeEdad = personaTodosLosDatos.esMayorDeEdad();

        String imcString;

        if(imc == -1){
            imcString = personaTodosLosDatos.getNombre() + " presenta un Indice de Masa Corporal igual a -1, por lo tanto, se encuentra BAJO DE PESO.";
        }
        else {
            if( imc == 0){
                imcString = personaTodosLosDatos.getNombre() + " presenta un Indice de Masa Corporal igual a 0, por lo tanto, se encuentra con un PESO SALUDABLE.";
            }
            else {
                imcString = personaTodosLosDatos.getNombre() + " presenta un Indice de Masa Corporal igual a 1, por lo tanto se encuentra en SOBREPRESO.";
            }
        }

        String esMayorString;
        if(esMayorDeEdad){
            esMayorString = "Por otra parte, " + personaTodosLosDatos.getNombre() + " es una persona mayor de edad";
        } else {
            esMayorString = "Por otra parte, " + personaTodosLosDatos.getNombre() + " es una persona menor de edad";
        }

        String personaToString = "Datos personales de la persona:\n" + personaTodosLosDatos.toString();

        System.out.println(personaToString);
        System.out.println(imcString);
        System.out.println(esMayorString);
    }
}
