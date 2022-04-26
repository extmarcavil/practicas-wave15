package blog.ejercicio.dto;


import blog.ejercicio.model.BlogEntry;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogCreationResponseDTO {

    String message;
    int id;

    public BlogCreationResponseDTO(int idOfNewBlog, String message) {
        this.id = idOfNewBlog;
        this.message = message;
    }
}
