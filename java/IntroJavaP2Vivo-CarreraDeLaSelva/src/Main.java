import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<HashMap<String,String>> circuitoChico = new ArrayList<>();
    static List<HashMap<String,String>> circuitoMedio = new ArrayList<>();
    static List<HashMap<String,String>> circuitoAvanzado = new ArrayList<>();

    // circuito chico = 0, circuito medio = 1, circuito avanzado = 2
    public static void desinscribirParticipante(String dni,List<HashMap<String,String>> carrera){

                if(carrera.removeIf((p) -> p.get("dni").equals(dni)))
                {
                    System.out.println("Participante eliminado correctamente");
                }else
                {
                    System.out.println("El participante no esta inscripto en la carrera.");
                }
    }

    public static void mostrarParticipantes(List<HashMap<String,String>> carrera){

        for (HashMap<String,String> participante : carrera){
            for (Map.Entry<String, String> entry : participante.entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            System.out.println("");
        }
    }

   static int lastParticipante = 0;

    // circuito chico = 0, circuito medio = 1, circuito avanzado = 2
    public static void agregarParticipante(int carrera, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo){

        if(circuitoChico.stream().anyMatch((p) -> p.get("dni").equals(dni)))
        {
            System.out.println("El participante ya esta inscripto en una carrera");
            return;
        }

        if(circuitoMedio.stream().anyMatch((p) -> p.get("dni").equals(dni)))
        {
            System.out.println("El participante ya esta inscripto en una carrera");
            return;
        }

        if(circuitoAvanzado.stream().anyMatch((p) -> p.get("dni").equals(dni)))
        {
            System.out.println("El participante ya esta inscripto en una carrera");
            return;
        }

        if(carrera == 2 && edad<18){
            System.out.println("No podes inscribirte a esta carrera siendo menor de edad.");
        }

        lastParticipante++;
        HashMap<String,String> participante = new HashMap<>();
        participante.put("id",Integer.toString(lastParticipante));
        participante.put("Nombre",nombre);
        participante.put("apellido",apellido);
        participante.put("dni",dni);
        participante.put("edad",Integer.toString(edad));
        participante.put("celular",celular);
        participante.put("numeroEmergencia",numeroEmergencia);
        participante.put("grupoSanguineo",grupoSanguineo);

        switch (carrera){
            case (0):

                if(edad<18)
                {
                    participante.put("Costo",Integer.toString(1300));
                }else{
                    participante.put("Costo",Integer.toString(1500));
                }
                circuitoChico.add(participante);
                break;
            case(1):

                if(edad<18){
                    participante.put("Costo",Integer.toString(2000));
                }else{
                    participante.put("Costo",Integer.toString(2300));
                }
                circuitoMedio.add(participante);
                break;
            case(2):
                participante.put("Costo",Integer.toString(2800));
                circuitoAvanzado.add(participante);
                break;
            default:

        }

    }
    public static void main(String[] args) {

        agregarParticipante(0,"12","belu","tracchia",20,"1234234","13324","AB+");
        agregarParticipante(0,"1223232","belu","tracchia",15,"1234234","13324","AB+");
        agregarParticipante(2,"123","belu","tracchia",12,"1234234","13324","AB+");
        agregarParticipante(1,"122312232","belu","tracchia",12,"1234234","13324","AB+");
        agregarParticipante(1,"12234232","belu","tracchia",20,"1234234","13324","AB+");
        agregarParticipante(2,"123","belu","tracchia",25,"1234234","13324","AB+");
        agregarParticipante(2,"42343224","belu","tracchia",25,"1234234","13324","AB+");
        System.out.println("Inscriptos a circuito chico");
        mostrarParticipantes(circuitoChico);
        System.out.println("-------------------------\n");
        System.out.println("Inscriptos a circuito medio");
        mostrarParticipantes(circuitoMedio);
        System.out.println("-------------------------\n");
        System.out.println("Inscriptos a circuito avanzado");
        mostrarParticipantes(circuitoAvanzado);
        desinscribirParticipante("12",circuitoChico);
        System.out.println("-------------------------\n");
        System.out.println("Inscriptos a circuito chico");
        mostrarParticipantes(circuitoChico);
    }

}
