package com.youtuber.spring.repository;

import com.youtuber.spring.dto.EntradaBlog;
import com.youtuber.spring.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {



    List<EntradaBlog> entradas = new ArrayList<>();

    public BlogRepository() {

        initdata();
    }

    private void initdata() {

        entradas.add(new EntradaBlog(1,"entrada1"));
    }

    public List<EntradaBlog> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<EntradaBlog> entradas) {
        this.entradas = entradas;
    }

    public void addEntrada(EntradaBlog entrada){
        this.entradas.add(entrada);
    }


}
