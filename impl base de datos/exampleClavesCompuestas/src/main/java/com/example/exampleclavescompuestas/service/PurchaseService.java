package com.example.exampleclavescompuestas.service;

import com.example.exampleclavescompuestas.model.Purchase;
import com.example.exampleclavescompuestas.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements IPurchaseService {
    private final PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Purchase save(Purchase data) {
        return repository.save(data);
    }
}
