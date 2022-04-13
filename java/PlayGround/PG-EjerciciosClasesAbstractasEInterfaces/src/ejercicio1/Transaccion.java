package ejercicio1;

public abstract class Transaccion implements TransaccionCompletable<Cliente>{
    protected Cliente cliente;

    public abstract void transaccionNOK(Cliente cliente);
    public abstract void transaccionOK(Cliente cliente);

    public Transaccion(Cliente clienteQueTransaccionara){
        this.cliente = clienteQueTransaccionara;
    }

    public void imprimirResultado() {
        if(cliente.tieneDatosEnRegla())
            this.transaccionOK(cliente);
        else
            this.transaccionNOK(cliente);
    }
}
