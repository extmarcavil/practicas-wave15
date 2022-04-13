package uy.com.vparula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Cliente cli1 = new Cliente("1223","Pedro","El escamoso");
        Cliente cli2 = new Cliente("3456","Juan","Gomez");
        Cliente cli3 = new Cliente("12345","Pepe","Grillo");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        for(Cliente c : clientes){
            System.out.println(c);
        }
        System.out.println("Ingrese un documento a borrar: ");
        Scanner teclado = new Scanner(System.in);
        String dniBorrar = teclado.nextLine();
        boolean encontre = false;
        for (Cliente c: clientes){
            if(c.getDni().equals(dniBorrar)){
                clientes.remove(c);
                encontre = true;
                break;
            }
        }
        if (encontre) {
            System.out.println("borre usuario");
        }else{
            System.out.println("No lo borre");
        }
        encontre = false;
        String dniBuscar = teclado.nextLine();
        for (Cliente c: clientes){
            if(c.getDni().equals(dniBuscar)){
                System.out.println("Cliente encontrado: " + c);
                encontre = true;
                break;
            }
        }
        if (!encontre){
            System.out.println("Cliente no encontrado");
        }
        teclado.close();
    }
}
