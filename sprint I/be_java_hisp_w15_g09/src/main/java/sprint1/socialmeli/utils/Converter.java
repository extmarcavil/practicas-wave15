package sprint1.socialmeli.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Patrón de diseño converter aplicado, información obtenida de https://java-design-patterns.com/patterns/converter/
 */


public class Converter<T, U> {

    // T is DTO
    // U is Entity
    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;

    public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final U convertFromDto(final T dto) {
        return fromDto.apply(dto);
    }

    public final T convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    public final List<U> createFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final List<T> createFromEntities(final Collection<U> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}