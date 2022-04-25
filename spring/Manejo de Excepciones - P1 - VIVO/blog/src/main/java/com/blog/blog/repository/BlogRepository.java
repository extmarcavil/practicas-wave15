package com.blog.blog.repository;

import com.blog.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository{
    private HashMap<Long, EntradaBlog> mapaBlogs = new HashMap<>();

    @Override
    public EntradaBlog crearBlog(EntradaBlog entradaBlog) {
        Long id = entradaBlog.getId();
        mapaBlogs.put(id,entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog buscarBlogPorId(Long id) {
        return mapaBlogs.get(id);
    }

    @Override
    public List<EntradaBlog> listarBlogs() {
        return this.mapaBlogs.entrySet().stream()
                                        .map(x -> {x.getValue()
                                                    .setId(x.getKey());
                                                     return x.getValue();
                                                  }
                                            ).collect(Collectors.toList());
    }
}
