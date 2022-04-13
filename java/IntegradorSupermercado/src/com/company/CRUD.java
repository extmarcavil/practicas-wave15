package com.company;

public interface CRUD<T,V> {
    public void agregar(T obj, V lst);
    public void eliminar(T obj, V lst);
    public void actualizar(T obj, V lst);
    public Object obtener(String id, V lst);
}
