package com.example.hqlejerciciopractico.service;

import com.example.hqlejerciciopractico.dto.ResGetOrderMakinDTO;
import com.example.hqlejerciciopractico.entity.Vehiculo;
import com.example.hqlejerciciopractico.repository.IAutosRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutosService implements IAutosService{
    private IAutosRepo autosRepo;

    public AutosService(IAutosRepo autosRepo) {
        this.autosRepo = autosRepo;
    }

    @Override
    public List<String> getAllPatentes() {
        List<Vehiculo> vehiculos = autosRepo.findAll();
        List<String> toRet = new ArrayList<>();

        for (Vehiculo v : vehiculos){
            toRet.add(v.getPatente());
        }

        return toRet;
    }

    @Override
    public List<ResGetOrderMakinDTO> getAllOrderMakin() {
        ModelMapper mapper = new ModelMapper();
        //Student student = mapper.map(studentDTO, Student.class);

        List<ResGetOrderMakinDTO> vehiculos =
                autosRepo
                        .findAllOrderByMaking()
                        .stream()
                        .map(v -> mapper.map(v, ResGetOrderMakinDTO.class))
                        .collect(Collectors.toList());

        return vehiculos;
    }
}
