package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClienteImp implements CRUDRepository<Cliente>{

    ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente object) {
        listaClientes.add(object);
    }

    @Override
    public void consultar() {
        listaClientes.forEach(System.out::println);
    }

    public void consultar(int dni){
        listaClientes.stream().filter(x -> x.getDni() == dni).forEach(System.out::println);
        List<Cliente> listaTemp = listaClientes.stream()
                .filter(x -> x.getDni() == dni).collect(Collectors.toList());
        if(listaTemp.size() == 0)
            System.out.println("DNI no encontrado.");

    }

    @Override
    public Cliente buscar(int id) {
        //listaClientes.stream().filter(x -> x.getDni() == id).forEach(System.out::println);
        Cliente c;
        List<Cliente> listaTemp = listaClientes.stream()
                .filter(x -> x.getDni() == id).collect(Collectors.toList());
        if(listaTemp.size() == 0) {
            return null;
        }else {
            c = listaTemp.get(0);
            return c;
        }

    }

    @Override
    public void eliminar() {
        Scanner sn = new Scanner(System.in);

        System.out.print("\nIngrese DNI: ");
        int dni = sn.nextInt();

        List<Cliente> listaTemp = listaClientes.stream()
                .filter(x -> x.getDni() == dni).collect(Collectors.toList());
        if(listaTemp.size() == 0) {
            System.out.println("DNI no encontrado.");
        }else{
            listaClientes.removeIf(p -> p.getDni() == dni);
        }
    }
}
