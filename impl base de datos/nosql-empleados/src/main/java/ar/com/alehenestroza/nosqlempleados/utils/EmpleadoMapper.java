package ar.com.alehenestroza.nosqlempleados.utils;

import ar.com.alehenestroza.nosqlempleados.dto.request.NewEmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.entities.Empleado;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmpleadoFromDTO(NewEmpleadoDTO dto, @MappingTarget Empleado entity);
}
