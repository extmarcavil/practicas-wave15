package com.company;

import java.util.ArrayList;

public class Registros implements CRUD<Registro, ArrayList<Registro>> {
    @Override
    public void agregar(Registro obj, ArrayList<Registro> lst) {
        System.out.println();
    }

    @Override
    public void eliminar(Registro obj, ArrayList<Registro> lst) {

    }

    @Override
    public void actualizar(Registro obj, ArrayList<Registro> lst) {

    }

    @Override
    public Object obtener(String id, ArrayList<Registro> lst) {
        return lst.stream().filter(x -> x.id == id).findFirst();
    }
}
