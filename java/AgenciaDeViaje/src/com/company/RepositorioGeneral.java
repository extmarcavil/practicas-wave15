package com.company;

public class RepositorioGeneral {
    RepositorioCliente repocliente;

    public RepositorioCliente getRepocliente() {
        return repocliente;
    }

    public void setRepocliente(RepositorioCliente repocliente) {
        this.repocliente = repocliente;
    }

    @Override
    public String toString() {
        return "RepositorioGeneral{" +
                "repocliente=" + repocliente +
                '}';
    }

    public RepositorioGeneral(RepositorioCliente repocliente) {
        this.repocliente = repocliente;
    }
}
