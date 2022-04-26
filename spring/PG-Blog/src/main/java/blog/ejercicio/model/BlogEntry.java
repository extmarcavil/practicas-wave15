package blog.ejercicio.model;

import blog.ejercicio.dto.BlogEntryDTO;

public class BlogEntry {

    // Se debe crear una entidad llamada “BlogEntry” con los siguientes atributos:
    //Id del blog.
    //Título del blog.
    //Nombre del autor.
    //Fecha de publicación.

    int idBlog;
    String blogTitle;
    String author;
    String publicationDate;


    public BlogEntry(BlogEntryDTO newEntryDTO) {
        this.blogTitle = newEntryDTO.getTitle();
        this.author = newEntryDTO.getAuthor();
        this.publicationDate = newEntryDTO.getPublicationDate();
        this.idBlog = newEntryDTO.getId();
    }

    public void mapToDto(BlogEntryDTO blogEntryDTO) {
        blogEntryDTO.setTitle(this.blogTitle);
        blogEntryDTO.setAuthor(this.author);
        blogEntryDTO.setPublicationDate(this.publicationDate);
        blogEntryDTO.setId(this.idBlog);
    }

    public int getBlogID() {
        return this.idBlog;
    }
}
