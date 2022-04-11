package main;

import cliente.Basic;
import cliente.Cobrador;

public class Main {
    public static void main(String[] args) {
        Basic basico = new Basic("Klaus");
        basico.pagoServicio();
        basico.consulta();
        basico.retiroEfectivo();
        Cobrador cobrador = new Cobrador("Klaus Cobrador");
        cobrador.consulta();
        cobrador.retiroEfectivo();
    }
}
