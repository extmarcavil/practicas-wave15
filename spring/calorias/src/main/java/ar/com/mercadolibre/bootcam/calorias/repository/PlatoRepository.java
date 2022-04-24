package ar.com.mercadolibre.bootcam.calorias.repository;

import ar.com.mercadolibre.bootcam.calorias.model.Plato;

import java.util.List;

public interface PlatoRepository {
    List<Plato> findAll();
}
