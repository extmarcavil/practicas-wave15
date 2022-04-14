package com.company.clientes;

import com.company.Banco;
import com.company.EstadoTransferencia;

public class Basic implements Banco, EstadoTransferencia {
    @Override
    public void deposito() {

    }

    @Override
    public void transferencia(String estado) {
        System.out.println("Accion no permitida para este usuario");
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Retirando efectivo");
        transferecnciaOk();
    }

    @Override
    public void consultaSaldo() {

        System.out.println("Realizando consulta de saldo");
        transferecnciaOk();
    }

    @Override
    public void pagodeServicios() {
        System.out.println("realizando pago de servicios");
        transferecnciaOk();
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
