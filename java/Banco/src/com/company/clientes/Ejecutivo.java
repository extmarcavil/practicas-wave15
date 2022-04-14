package com.company.clientes;

import com.company.Banco;
import com.company.EstadoTransferencia;

public class Ejecutivo implements Banco, EstadoTransferencia {

    @Override
    public void deposito() {
        System.out.println("Cliente ejecutivo realizando un deposito");
        transferecnciaOk();
    }

    @Override
    public void transferencia(String estado) {

        if(estado == "exitoso"){

            System.out.println("Cliente ejecutivo realizando una tranferencia");
            transferecnciaOk();
        }else {
            System.out.println("error en la transferencia, intente de nuevo");
            transferenciaNoOk();
        }
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Accion no permitida para este tipo de usuario");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Accion no permitida para este tipo de usuario");
    }

    @Override
    public void pagodeServicios() {
        System.out.println("Accion no permitida para este tipo de usuario");

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
