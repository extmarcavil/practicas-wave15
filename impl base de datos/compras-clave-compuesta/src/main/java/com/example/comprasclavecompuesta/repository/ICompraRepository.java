package com.example.comprasclavecompuesta.repository;

import com.example.comprasclavecompuesta.model.Compra;
import com.example.comprasclavecompuesta.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {

}
