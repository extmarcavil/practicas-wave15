package ar.com.mercadolibre.bootcam.calorias.service;

import ar.com.mercadolibre.bootcam.calorias.dto.request.PlatoRequestDTO;
import ar.com.mercadolibre.bootcam.calorias.dto.response.PlatoResponseDTO;
import ar.com.mercadolibre.bootcam.calorias.model.Ingrediente;
import ar.com.mercadolibre.bootcam.calorias.model.Plato;
import ar.com.mercadolibre.bootcam.calorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServiceImple implements IPlatoService {
    private IPlatoRepository platoRepository;

    public PlatoServiceImple(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoResponseDTO getDataPlato(PlatoRequestDTO dto) {
        PlatoResponseDTO resDto = new PlatoResponseDTO();
        resDto.setIngredientes(this.findIngredientes(dto));
        resDto.setCantidadTotalCalorias(this.findCantidadTotalCalorias(dto));
        resDto.setIngredienteMayorCalorias(this.findIngredienteMayorCalorias(dto));
        return resDto;
    }

    @Override
    public List<Ingrediente> findIngredientes(PlatoRequestDTO dto) {
        return platoRepository
                .findAll()
                .stream()
                .filter(p -> p.getNombre().equals(dto.getNombre()))
                .findFirst()
                .map(Plato::getIngredientes)
                .orElseGet(ArrayList::new);
    }

    @Override
    public Integer findCantidadTotalCalorias(PlatoRequestDTO dto) {
        return platoRepository
                .findAll()
                .stream()
                .filter(p -> p.getNombre().equals(dto.getNombre()))
                .findFirst()
                .map(p -> p.getIngredientes()
                        .stream()
                        .map(Ingrediente::getCalorias)
                        .reduce(0, Integer::sum))
                .orElseGet(() -> 0);
    }

    @Override
    public Ingrediente findIngredienteMayorCalorias(PlatoRequestDTO dto) {
        return platoRepository
                .findAll()
                .stream()
                .filter(p -> p.getNombre().equals(dto.getNombre()))
                .findFirst()
                .map(p -> p.getIngredientes()
                .stream()
                .reduce(null, (acc, i) -> {
                    if (acc == null) {
                        return i;
                    } else {
                        return masCaloriasEntre(acc, i);
                    }
                }))
                .orElseGet(null);
    }

    private Ingrediente masCaloriasEntre(Ingrediente i1, Ingrediente i2) {
        if (i1.getCalorias() > i2.getCalorias()) {
            return i1;
        } else {
            return i2;
        }
    }
}
