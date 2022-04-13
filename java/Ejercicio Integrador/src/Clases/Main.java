package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> listado_clientes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String input;

        Cliente jose = new Cliente("39201932", "Jose","Marquez");
        listado_clientes.add(jose);
        Cliente ana = new Cliente("15323052", "Ana Laura","Peña");
        listado_clientes.add(ana);
        Cliente maria = new Cliente("45031324", "Maria","Aluar");
        listado_clientes.add(maria);

        listado_clientes.stream().forEach(cli -> System.out.println(cli));

        listado_clientes.remove(2);
        System.out.println("-------------------------------------");
        listado_clientes.stream().forEach(cli -> System.out.println(cli));
        System.out.println("-------------------------------------");
        System.out.println("Introduzca el DNI del cliente que desea buscar: \n");

        listado_clientes.stream().filter(Cliente -> Cliente.getDni() == "15323052").forEach(System.out::println);

        try{
            input = teclado.nextLine();
            listado_clientes.stream().filter(Cliente -> Cliente.getDni() == input).forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            teclado.close();
        }

        teclado.close();
    }
}
