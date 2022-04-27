package com.youtuber.spring.service;

import com.youtuber.spring.dto.EntradaBlog;
import com.youtuber.spring.exepciones.BlogExepciones;
import com.youtuber.spring.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BlogServiceImpl {

    @Autowired
    BlogRepository blogRepository;

    public ResponseEntity<EntradaBlog> crearEntrada(EntradaBlog entradaBlog){

        if(blogRepository.getEntradas().stream().filter(entradaBlog1 -> entradaBlog1.getId()==entradaBlog.getId()).findFirst().isPresent()){
            throw new BlogExepciones("ya existe un blog con ese id");
        }
        else{
            blogRepository.addEntrada(entradaBlog);
            return new ResponseEntity<>(entradaBlog, HttpStatus.CREATED);

        }
    }

    public ResponseEntity<EntradaBlog> getBlog(Integer idBlog) {
try{
    EntradaBlog entrada=blogRepository.getEntradas().stream().filter((entradaBlog -> entradaBlog.getId()==idBlog)).findFirst().get();
    if(entrada!=null){
        return new ResponseEntity<EntradaBlog>(entrada,HttpStatus.FOUND);
    }

}catch (NoSuchElementException e){
    throw new BlogExepciones("no encontramos el bloc");
}
//throw new BlogExepciones("No encontramos un blog con ese id");

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<List<EntradaBlog>> getAll() {
        List<EntradaBlog> entradas=blogRepository.getEntradas();
        return new ResponseEntity<List<EntradaBlog>>(entradas,HttpStatus.FOUND);
    }
}



