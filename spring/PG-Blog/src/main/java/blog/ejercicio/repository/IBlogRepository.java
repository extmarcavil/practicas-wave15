package blog.ejercicio.repository;

import blog.ejercicio.model.BlogEntry;

import java.util.List;

public interface IBlogRepository {

    int createNewBlogEntry(BlogEntry newBlogID);
    BlogEntry getBlogEntry(int id);
    boolean containsBlogID(int id);
    List<BlogEntry> getAllSavedBlogs();
}
