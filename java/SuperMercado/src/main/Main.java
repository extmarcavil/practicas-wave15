package main;

import entidades.Cliente;
import entidades.RepoClient;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        RepoClient repoClient = new RepoClient();
        Cliente alan = new Cliente("Alan",12312312,"Brito");
        Cliente susana = new Cliente("Susana",12332132,"Horia");
        Cliente armando = new Cliente("Armando",98798787,"Paredes");

        repoClient.addClient(alan);
        repoClient.addClient(susana);
        repoClient.addClient(armando);

        repoClient.mostrarClientes();

        repoClient.removeClient(susana);

        System.out.println("_______");
        System.out.println("Repo despues de borrar a susanahoria");
        repoClient.mostrarClientes();

        System.out.println("_______");
        System.out.println("Ingrese un dni para buscar en la lista: ");
        int dniToFind = Integer.parseInt(teclado.nextLine());

        Cliente clientResp = repoClient.findByDNI(dniToFind);

        if(clientResp == null){
            System.out.println("Error, cliente no encontrado");
            return;
        }

        System.out.println("Cliente encontrado");
        System.out.println(clientResp);

    }
}
