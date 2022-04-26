package blog.ejercicio.service;

import blog.ejercicio.dto.BlogCreationResponseDTO;
import blog.ejercicio.model.BlogEntry;

import java.util.Collection;
import java.util.List;

public interface IBlogService {

    int createNewBlogEntry(BlogEntry nuevaEntrada);
    BlogEntry getBlogEntry(int id);
    List<BlogEntry> getAllBlogs();
}
