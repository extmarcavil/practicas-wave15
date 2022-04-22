package com.apiblog.repository;

import com.apiblog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntradaBlogRepository {
    List<EntradaBlog> getAll();

    Integer add(EntradaBlog entrada);

    EntradaBlog findById(int Id);

}
