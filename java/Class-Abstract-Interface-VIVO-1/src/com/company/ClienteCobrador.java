package com.company;

public class ClienteCobrador implements Operaciones {

    @Override
    public String realizarDeposito(Transaccion t) {
        String mensaje = "La transaccion no corresponde a una transaccion Valida";
        if (t instanceof Deposito) {
            mensaje = t.transaccionNoOk();
        }
        return mensaje;
    }

    @Override
    public String realizarTransferencia(Transaccion t) {
        String mensaje = "La transaccion no corresponde a una transaccion Valida";
        if (t instanceof Transferencia) {
            mensaje = t.transaccionNoOk();
        }
        return mensaje;
    }

    @Override
    public String consultarSaldo(Transaccion t) {
        String mensaje = "La transaccion no corresponde a una transaccion Valida";
        if (t instanceof ConsultaDeSaldo) {
            mensaje = t.transaccionOk();
        }
        return mensaje;
    }

    @Override
    public String relizarPagoDeServicio(Transaccion t) {
        String mensaje = "La transaccion no corresponde a una transaccion Valida";
        if (t instanceof PagoDeServicio) {
            mensaje = t.transaccionNoOk();
        }
        return mensaje;
    }

    @Override
    public String retirarEfectivo(Transaccion t) {
        String mensaje = "La transaccion no corresponde a una transaccion Valida";
        if (t instanceof RetiroDeEfectivo) {
            mensaje = t.transaccionOk();
        }
        return mensaje;
    }
}
