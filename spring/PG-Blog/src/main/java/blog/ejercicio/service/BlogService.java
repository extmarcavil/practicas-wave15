package blog.ejercicio.service;

import blog.ejercicio.exceptions.BlogAlreadyExist;
import blog.ejercicio.model.BlogEntry;
import blog.ejercicio.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public int createNewBlogEntry(BlogEntry newBlogEntry) {
        if( repository.containsBlogID(newBlogEntry.getBlogID()) )
            throw new BlogAlreadyExist("El blog con id :" + newBlogEntry.getBlogID() + "ya existe");
        else
            return repository.createNewBlogEntry(newBlogEntry);
    }

    @Override
    public BlogEntry getBlogEntry(int id) {
        if( repository.containsBlogID(id) )
            return repository.getBlogEntry(id);
        else
            throw new BlogAlreadyExist("El blog con id :" + id + "no existe");
    }

    @Override
    public List<BlogEntry> getAllBlogs() {
        return repository.getAllSavedBlogs();
    }


}
