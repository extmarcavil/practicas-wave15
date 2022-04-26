package blog.ejercicio.dto;

import blog.ejercicio.model.BlogEntry;
import org.springframework.stereotype.Component;

@Component
public class BlogDTOConverter extends Converter<BlogEntryDTO, BlogEntry> {

    public BlogDTOConverter() {
        super(BlogDTOConverter::convertToEntity, BlogDTOConverter::convertToDto);
    }

    private static BlogEntryDTO convertToDto(BlogEntry user) {
        return new BlogEntryDTO(user);
    }

    private static BlogEntry convertToEntity(BlogEntryDTO dto) {
        return new BlogEntry(dto);
    }

}