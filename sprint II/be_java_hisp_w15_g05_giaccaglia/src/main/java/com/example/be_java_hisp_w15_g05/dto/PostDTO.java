package com.example.be_java_hisp_w15_g05.dto;

import com.example.be_java_hisp_w15_g05.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDTO {

    @Min(value = 1, message = "El ID del usuario no puede ser menor a 0")
    @NotNull(message = "El ID del usuario no puede estar vacio")
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "El campo fecha no puede estar vacio")
    private LocalDate date;
    @Valid
    private ProductDTO detail;@GetMapping("/api/v1/fresh-products/{idProduct}/batch/list")
    public ResponseEntity<AlgunDTO> searchBatchStock(@PathVariable Integer id, @RequestParam(required = false) String order){
        return new ResponseEntity<>(algunService.algunMetodo(id, order), HttpStatus.OK);
    }
    @NotNull(message = "La categoria no puede estar vacia")
    private int category;
    @NotNull(message = "El precio no puede ser 0")
    @Max(value = 10000000, message = "El precio no puede superar los 10000000")
    private double price;

}
