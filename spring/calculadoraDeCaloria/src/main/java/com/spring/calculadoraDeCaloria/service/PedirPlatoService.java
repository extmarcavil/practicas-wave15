package com.spring.calculadoraDeCaloria.service;

import com.spring.calculadoraDeCaloria.DTO.InfoComidaDTO;
import com.spring.calculadoraDeCaloria.DTO.IngredientesClienteDTO;
import com.spring.calculadoraDeCaloria.repository.IIngredientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedirPlatoService implements IPedirPlatoService{

    private IIngredientesRepository repo;

    public PedirPlatoService(IIngredientesRepository repo) {
        this.repo = repo;
    }

    @Override
    public InfoComidaDTO getInfoPlato(String name, int peso, List<IngredientesClienteDTO> listaIngredientes) {
        return null;
    }
}
