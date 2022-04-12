package ejercicio2;

public class Curriculum extends Documento {


    String nombrePersona ;
    String apellidoPersona ;
    String dni;
    String experienciaLaboral;

    public Curriculum() {
        nombrePersona = "Aristobulo";
        apellidoPersona = "Del Valle";
        dni = "38389393";
        experienciaLaboral = "Sin Experiencia";
    }

    @Override
    public void imprimir() {
        System.out.println("|---------CV-----------------|");
        System.out.println("| Nombre :" + nombrePersona + "\t\t |");
        System.out.println("| Apellido :" + apellidoPersona+ "\t\t |");
        System.out.println("| Dni :" + dni + "\t\t\t\t |" );
        System.out.println("| \t\t\t\t\t\t\t |");
        System.out.println("| ------Exp. Laboral --------|");
        System.out.println("| " + experienciaLaboral + "\t\t\t |");
        System.out.println("|----------------------------|");

    }
}
