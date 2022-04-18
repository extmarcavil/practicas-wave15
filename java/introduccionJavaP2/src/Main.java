import java.util.*;

public class Main {

    private static Integer contador = 0;

    private static Integer darID(){
        contador++;
        return contador;
    }

    private static Categoria seleccionCategoria(Scanner scanner){

        System.out.println("Seleccione la categoria:");
        System.out.println("(1) Circuito Chico");
        System.out.println("(2) Circuito Medio");
        System.out.println("(3) Circuito Avanzado");
        System.out.print("Su Opcion: ");
        int opCircuito = Integer.parseInt(scanner.nextLine());
        Categoria categoria;
        switch (opCircuito){
            case 1:
                categoria=Categoria.CHICO;
                break;
            case 2:
                categoria=Categoria.MEDIO;
                break;
            case 3:
                categoria=Categoria.AVANZADO;
                break;
            default:
                categoria=Categoria.CHICO;
                break;
        }
        return categoria;

    }

    private static void buscarParticipante(Scanner scanner, Map<Long,PersonaInscripta> participantes){
        System.out.println("===========================================================================");
        System.out.print("Ingrese DNI:");
        Long dni = Long.parseLong(scanner.nextLine());
        PersonaInscripta personaInscripta=participantes.get(dni);
        if (personaInscripta == null) {
            System.out.println("No se ha encontrado un participante con el DNI indicado.");
        }
        else {
            System.out.println("Persona localizada exitosamente:");
            System.out.println(personaInscripta);
        }
        System.out.println("===========================================================================");
    }


    public static void main(String[] args) {
        //Estructura para una busqueda general de los participantes
        //Key=Persona, Value=Categoria
        Map<Long,PersonaInscripta> participantes= new HashMap<>();
        Integer op = 0;
        Scanner scanner= new Scanner(System.in);

        List<PersonaInscripta> chico = new ArrayList<>();
        List<PersonaInscripta> medio = new ArrayList<>();
        List<PersonaInscripta> avanzado = new ArrayList<>();

        Map<Categoria, List<PersonaInscripta>> competencia = new HashMap<>();

        competencia.put(Categoria.CHICO,chico);
        competencia.put(Categoria.MEDIO,medio);
        competencia.put(Categoria.AVANZADO,avanzado);

        System.out.println("===========================================================================");
        System.out.println("Bienvenido al Sistema de Gestion de Participantes de la Carrera de la Selva");
        System.out.println("===========================================================================");
        do {
            System.out.println("Ingrese una Opcion:");
            System.out.println("(1) Dar de alta a participante.");
            System.out.println("(2) Ver Partipantes Inscriptos por categoria.");
            System.out.println("(3) Ver Participantes en general.");
            System.out.println("(4) Buscar participante por DNI.");
            System.out.println("(5) Desinscribir Participante.");
            System.out.println("(6) Salir.");

            System.out.println("===========================================================================");

            System.out.print("Su opcion: ");
            op= Integer.valueOf(scanner.nextLine());


            switch (op){
                case 1:
                    Persona persona=new Persona();
                    System.out.println("===========================================================================");
                    System.out.print("Ingrese DNI:");
                    persona.setDni(scanner.nextLong());
                    scanner.nextLine();
                    if (participantes.get(persona.getDni()) == null) {
                        Integer opCircuito=-1;
                        System.out.print("Ingrese Nombre:");
                        persona.setNombre(scanner.nextLine());
                        System.out.print("Ingrese Apellido:");
                        persona.setApellido(scanner.nextLine());
                        System.out.print("Ingrese Edad:");
                        persona.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Ingrese Nro Celular:");
                        persona.setCelular(scanner.nextLine());
                        System.out.print("Ingrese Nro Celular Emergencia:");
                        persona.setNroEmergencia(scanner.nextLine());
                        System.out.print("Ingrese Grupo Sanguineo:");
                        persona.setGrupoSanguineo(scanner.nextLine());

                        Categoria categoria = seleccionCategoria(scanner);

                        if( categoria==Categoria.AVANZADO && persona.getEdad()<18){
                            System.out.println("Ud. no puede participar en esta categoria.");
                            break;
                        }

                        Integer monto=-1;
                        switch (categoria){
                            case CHICO:
                                if (persona.getEdad() > 18) monto=1500;
                                else monto=1300;
                                break;
                            case MEDIO:
                                if (persona.getEdad() > 18) monto=2300;
                                else monto=2000;
                                break;
                            case AVANZADO:
                                monto=2800;
                                break;
                        }

                        System.out.println("Monto a pagar: "+monto);

                        PersonaInscripta personaInscripta =new PersonaInscripta(darID(),categoria,persona,monto);
                        //Insert
                        participantes.put(persona.getDni(),personaInscripta);
                        competencia.get(categoria).add(personaInscripta);

                        System.out.println("Persona Dada de alta Exitosamente.Su informacion:");
                        System.out.println(personaInscripta);

                    }else {
                        System.out.println("La persona ya fue inscripta.");
                    }

                    System.out.println("===========================================================================");

                    break;
                case 2:
                    System.out.println("===========================================================================");
                    Categoria categoria = seleccionCategoria(scanner);
                    System.out.println(competencia.get(categoria));
                    System.out.println("===========================================================================");
                    break;
                case 3:
                    System.out.println("===========================================================================");
                    System.out.println(participantes);
                    System.out.println("===========================================================================");
                    break;
                case 4:
                    buscarParticipante(scanner,participantes);
                    break;
                case 5:
                    System.out.println("===========================================================================");
                    System.out.print("Ingrese DNI:");
                    Long dni = Long.parseLong(scanner.nextLine());
                    PersonaInscripta personaInscripta=participantes.remove(dni);
                    if (personaInscripta == null) {
                        System.out.println("No se ha encontrado un participante con el DNI indicado.");
                    }
                    else {
                        competencia.get(personaInscripta.getCategoria()).remove(personaInscripta);
                        System.out.println("Persona eliminada exitosamente:");
                        System.out.println(personaInscripta);
                    }
                    System.out.println("===========================================================================");
                    break;
                case 6:
                    System.out.println("Hasta Luego. :) ");
                    break;
                default:
                    System.out.println("Mala Eleccion :(");
                    break;
            }

        } while (op!=6);

        scanner.close();

    }
}