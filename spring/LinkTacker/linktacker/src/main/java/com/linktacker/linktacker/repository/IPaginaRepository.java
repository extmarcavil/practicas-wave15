package com.linktacker.linktacker.repository;

import com.linktacker.linktacker.entity.Pagina;
import java.util.List;

public interface IPaginaRepository {
    Pagina crearPagina(Pagina pagina);
    List<Pagina> listaPaginas();
    Integer visitasPaginas(int linkId);
    Pagina paginaIdPassword(int id,String password);
    boolean agregarVisita(int id);
    Pagina paginaInfo(int id);
    boolean deshabilitarPagina(int id);
}
