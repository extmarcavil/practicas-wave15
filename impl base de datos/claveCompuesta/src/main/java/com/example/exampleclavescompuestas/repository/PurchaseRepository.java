package com.example.exampleclavescompuestas.repository;

import com.example.exampleclavescompuestas.model.Purchase;
import com.example.exampleclavescompuestas.model.PurchaseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseKey> {
}
