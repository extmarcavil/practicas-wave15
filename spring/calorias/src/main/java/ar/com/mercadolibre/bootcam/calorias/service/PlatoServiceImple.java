package ar.com.mercadolibre.bootcam.calorias.service;

import ar.com.mercadolibre.bootcam.calorias.dto.PlatoRequestDTO;
import ar.com.mercadolibre.bootcam.calorias.dto.PlatoResponseDTO;
import ar.com.mercadolibre.bootcam.calorias.model.Ingrediente;
import ar.com.mercadolibre.bootcam.calorias.model.Plato;
import ar.com.mercadolibre.bootcam.calorias.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServiceImple implements PlatoService {

    /**
     * Injection By Constructor
     */
    private PlatoRepository platoRepository;

    public PlatoServiceImple(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    /**
     * Metodos
     *
     * @param dto
     * @return
     */
    @Override
    public PlatoResponseDTO getDataPlato(PlatoRequestDTO dto) {

        PlatoResponseDTO resDto = new PlatoResponseDTO();

        //Buscando los ingrediente del PlatoRequestDto(Nombre y Peso) y setiandolos en el ResponseDto
        resDto.setIngredientes(this.findIngredientes(dto));
        //Buscando las calorias del plato que corresponde al nombre del PlatoRequestDto
        resDto.setCantidadTotalCalorias(this.findCantidadTotalCalorias(dto));
        //Buscando el ingrediente con mayor calotrias.
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
