package principal;

import java.util.*;

public class Supermercado {
    private String nombre;
    private Map<Integer,Cliente> clientes; //K=dni v=Cliente
    private Map<Integer,Factura> facturas; //K=dni del cliente v= Factura correspondiente;

    public Supermercado(String nombre){
        this.nombre= nombre;
        this.clientes= new HashMap<>();
        this.facturas= new HashMap<>();
    }

    public void agregarCliente(String nombre,String apellido,int dni){
        if(!clientes.containsKey(dni)){
            Cliente nuevoCli= new Cliente(nombre,apellido,dni);
            clientes.put(dni,nuevoCli);
            System.out.println("El cliente ha sido agregado a la lista corrrectamente");
        }else{
            System.out.println("ups! el usuario ya existe");
        }

    }

    public void eliminarCliente(int dni){
        if(clientes.containsKey(dni)){
            clientes.remove(dni);
            System.out.println("El cliente ha sido eliminado");
        }else {
            System.out.println("ups! el usuario no existe");
        }

    }
    public List<Cliente> listaClientes(){
        List<Cliente> listaCli= new ArrayList<>();
        for (Cliente cliente :  clientes.values()) {
            listaCli.add(cliente);
        }
        return listaCli;
    }

    public void datosCliente(int dni){
        if(clientes.containsKey(dni)){
            System.out.println(clientes.get(dni));
        }else
            System.out.println("Error, el cliente no existe");
    }

    public void agregarFactura(int dni, List<Producto> productos){
        if(!clientes.containsKey(dni)){
            System.out.println("Error,no se pudo crear la factura, el cliente no existe");
        }else{
            Cliente cliente= clientes.get(dni);
            Factura factura =new Factura(cliente,productos);
            facturas.put(cliente.getDni(),factura);
            System.out.println(factura);
        }


    }




}
