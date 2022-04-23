package ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.mapper;


import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request.IngredienteDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.model.Ingrediente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Ingrediente ingredienteDtoToIngrediente(IngredienteDTO ingredienteDTO){
        return modelMapper.map(ingredienteDTO,Ingrediente.class);
    }

}
