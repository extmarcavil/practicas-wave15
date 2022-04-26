package blog.ejercicio.repository;

import blog.ejercicio.exceptions.BlogAlreadyExist;
import blog.ejercicio.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    HashMap<Integer,BlogEntry> listaDeBlogs;

    public BlogRepository() {
        this.listaDeBlogs = new HashMap<>();
    }

    @Override
    public boolean containsBlogID(int id){
        return this.listaDeBlogs.containsKey(id);
    }

    @Override
    public List<BlogEntry> getAllSavedBlogs() {
        return new ArrayList<>(listaDeBlogs.values());
    }

    @Override
    public int createNewBlogEntry(BlogEntry newBlogID) {
        int id = newBlogID.getBlogID();
        this.listaDeBlogs.put(id,newBlogID);
        return id;
    }

    @Override
    public BlogEntry getBlogEntry(int id) {
        return this.listaDeBlogs.get(id);
    }
}
