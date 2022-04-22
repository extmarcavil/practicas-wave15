package com.apiblog.controller;

import com.apiblog.dto.request.EntradaBlogRequestDTO;
import com.apiblog.dto.response.EntradaBlogResponseDTO;
import com.apiblog.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradablog")
public class EntradaBlogController {
    //region Variables
    private IEntradaBlogService _entradaBlogService;
    //endregion

    //region Constructor

    public EntradaBlogController(IEntradaBlogService entradaBlogService) {
        this._entradaBlogService = entradaBlogService;
    }

    //endregion

    //region end points
    @PostMapping
    public ResponseEntity<Integer> agregarEntradaBlog(@RequestBody EntradaBlogRequestDTO entradaDTO)
    {
        return new ResponseEntity<>(_entradaBlogService.insertarEntradaBlog(entradaDTO),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogResponseDTO> buscarEntradaBlog(@PathVariable int id)
    {
        return new ResponseEntity<>(_entradaBlogService.entradaBlogId(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogResponseDTO>> entradasBlog()
    {
        return new ResponseEntity<>(_entradaBlogService.todoEntradaBlog(),HttpStatus.OK);
    }

    //endregion
}
