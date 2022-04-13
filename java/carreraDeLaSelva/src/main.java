import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;
        String[] datosParticipante = new String[7];
        int opcionCarrera;
        int valorInscripcion = 0;
        boolean inscripcionExitosa;
        HashMap<Integer, String> participantesCircuitoChico = new HashMap<>();
        HashMap<Integer, String> participantesCircuitoMedio = new HashMap<>();
        HashMap<Integer, String> participantesCircuitoAvanzado = new HashMap<>();

        System.out.println("Nuevo participante: ");
        System.out.println("Dni: ");
        Scanner teclado = new Scanner(System.in);
        datosParticipante[0] = teclado.next();
        System.out.println("Nombre: ");
        datosParticipante[1] = teclado.next();
        System.out.println("Apellido: ");
        datosParticipante[2] = teclado.next();
        System.out.println("Edad: ");
        datosParticipante[3] = teclado.next();
        System.out.println("Celular: ");
        datosParticipante[4] = teclado.next();
        System.out.println("Teléfono de emergencia: ");
        datosParticipante[5] = teclado.next();
        System.out.println("Grupo Sanguíneo: ");
        datosParticipante[6] = teclado.next();
        System.out.println("A qué carrera desea inscribirse?: (1- Circuito chico, 2- Circuito Medio, 3- Circuito Avanzado)");
        opcionCarrera = teclado.nextInt();

        switch (opcionCarrera){
            case 1: if(Integer.parseInt(datosParticipante[3]) < 18) {
                        valorInscripcion = 1300;
                        inscripcionExitosa = true;
                        participantesCircuitoChico.put(contador1+1,datosParticipante[0] + " " + datosParticipante[1] + " " + datosParticipante[2]);
                    }
                    else {
                        valorInscripcion = 1500;
                        inscripcionExitosa = true;
                        participantesCircuitoChico.put(contador1+1,datosParticipante[0] + " " + datosParticipante[1] + " " + datosParticipante[2]);
                    }
            break;
            case 2: if(Integer.parseInt(datosParticipante[3]) < 18) {
                        valorInscripcion = 2000;
                        inscripcionExitosa = true;
                        participantesCircuitoMedio.put(contador2+1,datosParticipante[0] + " " + datosParticipante[1] + " " + datosParticipante[2]);
                    }
                    else {
                        valorInscripcion = 2300;
                        inscripcionExitosa = true;
                        participantesCircuitoMedio.put(contador2+1,datosParticipante[0] + " " + datosParticipante[1] + " " + datosParticipante[2]);
                    }
            break;
            case 3: if(Integer.parseInt(datosParticipante[3]) < 18) {
                        System.out.println("No se pueden inscribir menores de 18 años en este circuito");
                        inscripcionExitosa = false;
                    break;
                    }
                    else{
                        valorInscripcion = 2800;
                        inscripcionExitosa = true;
                        participantesCircuitoAvanzado.put(contador3+1,datosParticipante[0] + " " + datosParticipante[1] + " " + datosParticipante[2]);
                    }
            break;
            default:
                System.out.println("Opción Incorrecta");
            break;

        }
        if (inscripcionExitosa = true)
            System.out.println("Se inscribió correctamente al participante, el monto a abonar es $" + valorInscripcion);


        System.out.println("\nParticipantes Circuíto Chico");
        System.out.println("Código\tParticipante\n-----\t------");
        for(Map.Entry pareja : participantesCircuitoChico.entrySet()) {
            System.out.print(pareja.getKey() + "\t    ");
            System.out.println(pareja.getValue());
        }
        System.out.println("\nParticipantes Circuíto Medio");
        System.out.println("Código\tParticipante\n-----\t------");
        for(Map.Entry pareja : participantesCircuitoMedio.entrySet()) {
            System.out.print(pareja.getKey() + "\t    ");
            System.out.println(pareja.getValue());
        }
        System.out.println("\nParticipantes Circuíto Avanzado");
        System.out.println("Código\tParticipante\n-----\t------");
        for(Map.Entry pareja : participantesCircuitoAvanzado.entrySet()) {
            System.out.print(pareja.getKey() + "\t    ");
            System.out.println(pareja.getValue());
        }

    }
}
