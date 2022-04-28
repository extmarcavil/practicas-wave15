package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dtos.PromoPostRequestDTO;
import sprint1.socialmeli.model.Post;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PromoPostConverter extends Converter<PromoPostRequestDTO, Post> {
    public PromoPostConverter() {
        super(PromoPostConverter::convertToEntity, PromoPostConverter::convertToDto);
    }
    private static PromoPostRequestDTO convertToDto(Post post) {
        throw new RuntimeException("Unimplemented method");
    }

    private static Post convertToEntity(PromoPostRequestDTO dto) {
        return new Post(dto.getUserId(),
                LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                dto.getDetail(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getHasPromo(),
                dto.getDiscount()
                );
    }
}
