package ejerpracticosp2vivo.calculadora.calculadoradecalorias.service;

import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.mapper.Mapper;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request.IngredienteDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.response.ComidaInfoDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.model.Ingrediente;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.repository.IRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InfoComidaService implements IService{

    private final Mapper mapper;
    private final IRepository repository;


    @Override
    public ComidaInfoDTO getInfoComida(List<IngredienteDTO> ingredientesDto) {

        ComidaInfoDTO comidaInfoDTO = new ComidaInfoDTO();

        Map<String,Ingrediente> ingredientes = ingredientesDto.stream()
                .map(ingredienteDTO -> mapper.ingredienteDtoToIngrediente(ingredienteDTO))
                .map(ingrediente -> repository.findByName(ingrediente) )
                .collect(Collectors.toMap(Ingrediente::getNombre, Function.identity()));

        ingredientesDto.forEach(
                ingredienteDTO -> ingredienteDTO.setCalorias(ingredientes.get(ingredienteDTO.getNombre()).getCalorias())
        );

        comidaInfoDTO.setIngredientes(ingredientesDto);

        comidaInfoDTO.setIngredienteConMayorCantidadCalorias(
                ingredientesDto.stream()
                        .max(Comparator.comparing(IngredienteDTO::getTotal))
                        .get()
        );

        comidaInfoDTO.setCantidadTotalCalorias(
                ingredientesDto.stream()
                        .mapToDouble(IngredienteDTO::getTotal)
                        .sum()
        );


        return comidaInfoDTO;
    }

}
