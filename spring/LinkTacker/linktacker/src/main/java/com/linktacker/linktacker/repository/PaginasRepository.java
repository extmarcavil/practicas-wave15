package com.linktacker.linktacker.repository;

import com.linktacker.linktacker.entity.Pagina;
import com.linktacker.linktacker.exception.PaginaException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PaginasRepository implements IPaginaRepository{
    private List<Pagina> listaPaginas;

    public PaginasRepository(){
        listaPaginas = new ArrayList<>();
    }

    @Override
    public Pagina crearPagina(Pagina pagina) {
        if(listaPaginas.isEmpty())
            pagina.setId(1);
        else
            pagina.setId(listaPaginas.size() + 1);
        listaPaginas.add(pagina);
        return pagina;
    }

    @Override
    public List<Pagina> listaPaginas() {
        return listaPaginas;
    }

    @Override
    public Integer visitasPaginas(int linkId) {
        return paginaInfo(linkId).getCantidadVisitas();
    }

    @Override
    public boolean agregarVisita(int id) {
        var info = paginaInfo(id);
        info.setCantidadVisitas(info.getCantidadVisitas() + 1);
        return true;
    }

    @Override
    public Pagina paginaInfo(int id) {
        var Pagina=  listaPaginas.stream().filter(f -> f.getId() == id).findFirst();
        if(Pagina.isPresent())
            return  Pagina.get();
        else
            throw  new PaginaException();
    }

    @Override
    public Pagina paginaIdPassword(int id, String password) {
        var filter = listaPaginas.stream().filter(f ->
                f.getId() == id && f.getPassword().equals(password)).findFirst();
        if(filter.isPresent())
            return  filter.get();
        else
            throw  new PaginaException();
    }

    @Override
    public boolean deshabilitarPagina(int id) {
        paginaInfo(id).setValidada(false);
        return true;
    }
}
