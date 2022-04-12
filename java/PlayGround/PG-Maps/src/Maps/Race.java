package Maps;

import java.util.HashMap;
import java.util.Scanner;

public class Race {
    private static HashMap<Integer, Integer> participantCircuitMap = new HashMap<Integer,Integer>();
    private static HashMap<Integer, String> nameMap = new HashMap<Integer, String>();
    private static HashMap<Integer, String> surnameMap = new HashMap<Integer, String>();
    private static HashMap<Integer, String> dniMap = new HashMap<Integer, String>();
    private static HashMap<Integer, String> ageMap = new HashMap<Integer, String>();
    private static HashMap<Integer, String> phoneMap = new HashMap<Integer, String>();
    private static HashMap<Integer, String> emergencyPhoneMap = new HashMap<Integer, String>() ;
    private static HashMap<Integer, String> bloodGroupMap = new HashMap<Integer, String>();
    private static int participantID;

    public static void main(String[] args) {
        System.out.println("Sistema de Ingrego de Participantes");
        System.out.println("V1.0.0 - Por favor ingrese datos validos pues no existen validaciones");
        boolean processProgram = true;
        int userOption;
        final Scanner userInputScanner = new Scanner(System.in);
        participantID = 0;
        participantCircuitMap = new HashMap<Integer, Integer>();
        nameMap = new HashMap<Integer, String>();
        surnameMap = new HashMap<Integer, String>();
        dniMap = new HashMap<Integer, String>();
        ageMap = new HashMap<Integer, String>();
        phoneMap = new HashMap<Integer, String>();
        emergencyPhoneMap = new HashMap<Integer, String>();
        bloodGroupMap = new HashMap<Integer, String>();

        while(processProgram){
	        System.out.println("Seleccione opcion");
            System.out.println("1 - Ingresar nuevo participante ");
            System.out.println("2 - Mostrar datos de participantes ");
            System.out.println("3 - Eliminiar participante");
            System.out.println("4 - Calcular monto");
            System.out.println("5 - Salir");
            userOption = Integer.parseInt(userInputScanner.nextLine());

            switch(userOption){
                case 1:
                    System.out.println("En que circuito desea participar?: \n1-Chico, \n2-Medio, \n3-Avanzado");
                    int userCircuit = Integer.parseInt(userInputScanner.nextLine());
                    switch(userCircuit){
                        case 1: addUserToLowCircuit(userInputScanner);    break;
                        case 2: addUserToMediumCircuit(userInputScanner); break;
                        case 3: addUserToHighCircuit(userInputScanner);   break;
                        default:
                            System.out.println("Circuito Incorrecto Intentelo nuevamente");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Que Categoria desea mostrar");
                    System.out.println("1 - Circuito Chico");
                    System.out.println("2 - Circuito Medio");
                    System.out.println("3 - Circuito Avanzado");
                    System.out.println("4 - Todos");
                    int circuit = Integer.parseInt(userInputScanner.nextLine());
                    switch(circuit){
                        case 1: printLowCircuitParticipants();      break;
                        case 2: printMediumCircuitParticipants();   break;
                        case 3: printHighCircuitParticipants();     break;
                        case 4: printLowCircuitParticipants();
                                printMediumCircuitParticipants();
                                printHighCircuitParticipants();     break;
                        default:
                            System.out.println("Categoria no cargada intentelo nuevamente");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Por favor, ingrese en numero de participante a eliminar");
                    deleteParticipant(Integer.parseInt(userInputScanner.nextLine()));
                    break;
                case 4:
                    showLastParticipantAmount();
                    break;
                case 5:
                    processProgram = false;
                default:
                    break;
            }
        }
        System.out.println("Cerrando Sistema\nGracias por usarnos ");
    }

    private static void showLastParticipantAmount() {
        int lastParticipant = participantID -1;
        int amount;
        boolean legalAge = false;
        int age = Integer.parseInt( ageMap.get(lastParticipant));
        if (age > 18) legalAge = true;
        switch( participantCircuitMap.get(lastParticipant)){
            case 1:
                amount = (legalAge)?1500:1300;
                break;
            case 2:
                amount = (legalAge)?2300:2000;
                break;
            case 3:
                amount = 2800;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + participantCircuitMap.get(lastParticipant));
        }
        System.out.println("El ultimo participante con Nombre: " + nameMap.get(lastParticipant) +" "+ surnameMap.get(lastParticipant) + " registro un monto de: " + amount);

    }

    private static void deleteParticipant(int participantID){
        if(participantCircuitMap.containsKey(participantID)){
            participantCircuitMap.remove(participantID);
            nameMap.remove(participantID);
            surnameMap.remove(participantID);
            dniMap.remove(participantID);
            ageMap.remove(participantID);
            phoneMap.remove(participantID);
            emergencyPhoneMap.remove(participantID);
            bloodGroupMap.remove(participantID);
        }
    }

    private static void printLowCircuitParticipants() {
        System.out.println("Incriptos para el Circuito Chico");
        printCircuitParticipants(1);
        System.out.println("\n");
    }
    private static void printMediumCircuitParticipants() {
        System.out.println("Incriptos para el Circuito Medio");
        printCircuitParticipants(2);
        System.out.println("\n");
    }
    private static void printHighCircuitParticipants() {
        System.out.println("Incriptos para el Circuito Avanzado");
        printCircuitParticipants(3);
        System.out.println("\n");
    }

    private static void printCircuitParticipants(int circuit) {
        System.out.println("NumeroInscripto\tNombre\tApellido\tEdad\tDni\tTelefono\tTel.Emergencia\tGrupoFactor");
        for( int participant = 0; participant < participantCircuitMap.size(); participant++ ){
            if(participantCircuitMap.containsKey(participant)){
                if(participantCircuitMap.get(participant) == circuit){
                    System.out.print(participant);                          System.out.print("\t\t");
                    System.out.print(nameMap.get(participant));             System.out.print("\t\t");
                    System.out.print(surnameMap.get(participant));          System.out.print("\t\t");
                    System.out.print(ageMap.get(participant));              System.out.print("\t\t");
                    System.out.print(dniMap.get(participant));              System.out.print("\t\t");
                    System.out.print(phoneMap.get(participant));            System.out.print("\t\t");
                    System.out.print(emergencyPhoneMap.get(participant));   System.out.print("\t\t");
                    System.out.print(bloodGroupMap.get(participant));       System.out.println("\t\t");
                    System.out.print("Participante correctamente borrado");
                }
            }

        }
    }

    private static boolean addUserToHighCircuit(Scanner userInputScanner){
       return addUserToCircuit(userInputScanner, 3);
    }

    private static boolean addUserToMediumCircuit(Scanner userInputScanner){
        return addUserToCircuit(userInputScanner, 2);
    }

    private static boolean addUserToLowCircuit(Scanner userInputScanner) {
        return addUserToCircuit(userInputScanner, 1);
    }

    private static boolean addUserToCircuit(Scanner userInputScanner, int circuit) {
        boolean checkAge;
        checkAge = ( circuit == 3)? true:false;

        if( addParticipantAge(participantID, userInputScanner, ageMap, checkAge) != true){
            System.out.println("El participante no puede hacer este circuito");
            System.out.println("Reintente en circuito bajo o medio");
            return false;
        }
        addParticipantCircuit(participantID, circuit, participantCircuitMap);
        addParticipantName(participantID, userInputScanner, nameMap);
        addParticipantSurname(participantID, userInputScanner, surnameMap);
        addParticipantDNI(participantID, userInputScanner, dniMap);
        addParticipantPhone(participantID, userInputScanner, phoneMap);
        addParticipantSOSPhone(participantID, userInputScanner, emergencyPhoneMap);
        addParticipantBloodGroup(participantID, userInputScanner, bloodGroupMap);
        System.out.println("Participante Nº: "+participantID+" correctamente cargado");
        participantID++;
        return true;
    }

    private static void addParticipantCircuit(int participantsQtty,int circuitID, HashMap<Integer, Integer> circuitMap) {
        circuitMap.put(participantsQtty,circuitID);
    }

    private static void addParticipantDNI(int participantsQtty, Scanner userInput, HashMap<Integer, String> dniMap) {
        System.out.println("Ingresar DNI ");
        String dni = userInput.nextLine();
        //System.out.println(dni);
        dniMap.put(participantsQtty,dni);
    }

    private static void addParticipantName(int participantsQtty, Scanner userInput, HashMap<Integer, String> nameMap) {
        System.out.println("Ingrese Nombre ");
        String name = userInput.nextLine();
        //System.out.println(name);
        nameMap.put(participantsQtty,name) ;
    }

    private static void addParticipantSurname(int participantsQtty, Scanner userInput, HashMap<Integer, String> surnameMap) {
        System.out.println("Ingrese Apellido ");
        String surname = userInput.nextLine();
        //System.out.println(surname);
        surnameMap.put(participantsQtty,surname);
    }

    private static boolean addParticipantAge(int participantsQtty, Scanner userInput, HashMap<Integer, String> ageMap,boolean checkAge) {
        System.out.println("Ingrese Edad ");
        String ageString = userInput.nextLine();
        //System.out.println(ageString);
        if( checkAge == false)
            ageMap.put(participantsQtty,ageString);
        else{
            int age = Integer.parseInt(ageString);
            if (age > 18)
                ageMap.put(participantsQtty,ageString);
            else
                return false;
        }
        return true;
    }

    private static void addParticipantPhone(int participantsQtty, Scanner userInput, HashMap<Integer, String> phoneMap) {
        System.out.println("Ingrese Numero de telefono ");
        String phone = userInput.nextLine();
        //System.out.println(phone);
        phoneMap.put(participantsQtty,phone);
    }
    private static void addParticipantSOSPhone(int participantsQtty, Scanner userInput, HashMap<Integer, String> SOSPhoneMap) {
        System.out.println("Ingrese Numero de Telefono de Emergencia ");
        String sosPhone = userInput.nextLine();
        //System.out.println(sosPhone);
        SOSPhoneMap.put(participantsQtty,sosPhone);
    }
    private static void addParticipantBloodGroup(int participantsQtty, Scanner userInput, HashMap<Integer, String> bloodGroupMap) {
        System.out.println("Ingrese Grupo y Factor ");
        String bloodGroup = userInput.nextLine();
        //System.out.println(bloodGroup);
        bloodGroupMap.put(participantsQtty,bloodGroup);
    }


}
