package sprint1.socialmeli.utils;

import org.springframework.stereotype.Component;
import sprint1.socialmeli.dto.Requests.PromoPostDTO;
import sprint1.socialmeli.model.Post;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PromoPostConverter extends Converter<PromoPostDTO, Post> {
    public PromoPostConverter() {
        super(PromoPostConverter::convertToEntity, PromoPostConverter::convertToDto);
    }
    private static PromoPostDTO convertToDto(Post post) {
        throw new RuntimeException("Conversion no implementada");

    }

    private static Post convertToEntity(PromoPostDTO dto) {
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
