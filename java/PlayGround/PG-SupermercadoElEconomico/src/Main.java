import model.Cliente;
import model.Item;
import model.SistemaDeFacturacion;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Cliente unCliente = new Cliente("39393939", "Dave","Mustaine");
        Cliente otroCliente = new Cliente("48484848","James", "Hetfield");
        Cliente otroClienteMas = new Cliente("56565656","Zakk","Wylde");

        Item leche = new Item("0001","Leche",149.90);
        Item galletitas = new Item("0002","Galletitas",100.00);
        Item carne = new Item("0010","Carne",500.00);
        Item pollo = new Item("0011","Pollo",250.70);
        Item fideos = new Item("0100","Fideos",95.80);

        ArrayList<Cliente> listaDeClientesInicial = new ArrayList<>();
        listaDeClientesInicial.add(unCliente);
        listaDeClientesInicial.add(otroCliente);
        listaDeClientesInicial.add(otroClienteMas);

        SistemaDeFacturacion sistemaDeFacturacionDelSupermercado = new SistemaDeFacturacion(listaDeClientesInicial);

        sistemaDeFacturacionDelSupermercado.registrarCompra(unCliente,leche,2);
        sistemaDeFacturacionDelSupermercado.registrarCompra(unCliente,galletitas,5);
        sistemaDeFacturacionDelSupermercado.registrarCompra(unCliente,carne,1);
        sistemaDeFacturacionDelSupermercado.imprimirFactura(unCliente);

        sistemaDeFacturacionDelSupermercado.registrarCompra(otroCliente,pollo,1);
        sistemaDeFacturacionDelSupermercado.registrarCompra(otroCliente,fideos,2);
        sistemaDeFacturacionDelSupermercado.registrarCompra(otroCliente,leche,6);
        sistemaDeFacturacionDelSupermercado.imprimirFactura(otroCliente);


        sistemaDeFacturacionDelSupermercado.imprimirDatosDeCliente();
        sistemaDeFacturacionDelSupermercado.removerCliente(otroClienteMas);
        sistemaDeFacturacionDelSupermercado.imprimirDatosDeCliente();


        sistemaDeFacturacionDelSupermercado.buscarClientePorDNI();







    }
}
