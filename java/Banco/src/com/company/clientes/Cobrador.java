package com.company.clientes;

import com.company.Banco;
import com.company.EstadoTransferencia;

public class Cobrador implements Banco, EstadoTransferencia {
    @Override
    public void deposito() {
        System.out.println("Accion No disponible para Usuario");
    }

    @Override
    public void transferencia(String estado) {
        System.out.println("Accion No disponible para Usuario");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Realizando retiro de efectivo");
        transferecnciaOk();
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Tu saldo es...");
        transferecnciaOk();
    }

    @Override
    public void pagodeServicios() {
        System.out.println("Accion No disponible para Usuario");
    }

    @Override
    public void transferecnciaOk() {
        System.out.println("Tranferencia realizada con exito!");
    }

    @Override
    public void transferenciaNoOk() {
        System.out.println("Error en la tranferencia intente de nuevo");
    }
}
