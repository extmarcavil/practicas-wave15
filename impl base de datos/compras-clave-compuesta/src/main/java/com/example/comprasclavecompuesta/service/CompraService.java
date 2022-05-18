package com.example.comprasclavecompuesta.service;

import com.example.comprasclavecompuesta.model.Compra;
import com.example.comprasclavecompuesta.repository.ICompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraService implements ICompraService{

    private ICompraRepository compraRepository;
    public CompraService(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void save(Compra compra) {
        compraRepository.save(compra);
    }
}
