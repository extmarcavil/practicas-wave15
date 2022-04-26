package blog.ejercicio.controller;

import blog.ejercicio.dto.BlogCreationResponseDTO;
import blog.ejercicio.dto.BlogDTOConverter;
import blog.ejercicio.dto.BlogEntryDTO;
import blog.ejercicio.model.BlogEntry;
import blog.ejercicio.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IBlogService service;
    BlogDTOConverter converter;

    public BlogController(IBlogService service,BlogDTOConverter converter) {
        this.converter = converter;
        this.service = service;
    }

    @PostMapping("/blog/create")
    public ResponseEntity<BlogCreationResponseDTO> createNewBlogEntry(@RequestBody BlogEntryDTO newBlogEntryDTO ){
        BlogEntry aNewBlogEntry = this.converter.convertFromDto(newBlogEntryDTO);
        int idOfNewBlog = service.createNewBlogEntry(aNewBlogEntry);
        return new ResponseEntity<>(new BlogCreationResponseDTO(idOfNewBlog,"Blog creado satifactoriamente"), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDTO> getBlogEntry(@PathVariable int id ){
        BlogEntryDTO aBlogDTO = this.converter.convertFromEntity(this.service.getBlogEntry(id));
        return new ResponseEntity<>(aBlogDTO, HttpStatus.OK);
    }

    @RequestMapping ("/blogs")
    public ResponseEntity<List<BlogEntryDTO>> getAllBlogEntries(){
        List<BlogEntryDTO> aListOfBlogDTO = this.converter.createFromEntities(this.service.getAllBlogs());
        return new ResponseEntity<>(aListOfBlogDTO, HttpStatus.OK);
    }

}
