package blog.ejercicio.dto;

import blog.ejercicio.model.BlogEntry;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogEntryDTO {

    int id;
    String title;
    String author;
    String publicationDate;

    public BlogEntryDTO(int id, String blogTitle, String author, String publicationDate) {
        this.id = id;
        this.title = blogTitle;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public BlogEntryDTO(BlogEntry aBlogToMap) {
        aBlogToMap.mapToDto(this);
    }
}
