package estructurasDinamicas;

import java.util.ArrayList;
import java.util.Scanner;

public class CarrerasSelva {
    public static void main(String[] args) {

        ArrayList<String> cc = new ArrayList<>();
        ArrayList<String> cm = new ArrayList<>();
        ArrayList<String> ca = new ArrayList<>();

        //Circuito cc = new Circuito('C',2,1300,1500);
        //Circuito cm = new Circuito('M',5,2000,2300);
        //Circuito ca = new Circuito('A',10,0,2800);


    }

    public static void listarParticipantes(Circuito cc, Circuito cm, Circuito ca){
        ArrayList<Persona> lista = cc.getListaParticipantes();
        System.out.println("Circuito chico:");
        for(Persona p: lista){
            System.out.print("DNI: " + p.getDni() + " ");
            System.out.print("Nombre: " + p.getNombre() + " ");
            System.out.print("Apellido: " + p.getApellido() + " ");
            System.out.print("Edad: " + p.getEdad() + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Circuito medio:");
        lista = cm.getListaParticipantes();
        for(Persona p: lista){
            System.out.print("DNI: " + p.getDni() + " ");
            System.out.print("Nombre: " + p.getNombre() + " ");
            System.out.print("Apellido: " + p.getApellido() + " ");
            System.out.print("Edad: " + p.getEdad() + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Circuito avanzado:");
        lista = ca.getListaParticipantes();
        for(Persona p: lista){
            System.out.print("DNI: " + p.getDni() + " ");
            System.out.print("Nombre: " + p.getNombre() + " ");
            System.out.print("Apellido: " + p.getApellido() + " ");
            System.out.print("Edad: " + p.getEdad() + " ");
            System.out.println();
        }
    }
}
