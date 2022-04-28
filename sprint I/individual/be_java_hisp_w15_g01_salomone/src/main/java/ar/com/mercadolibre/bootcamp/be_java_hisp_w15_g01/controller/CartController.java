package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.controller;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private PostService service;

    public CartController(PostService service) {
        this.service = service;
    }

    @PostMapping("/addProducts/{userId}/{productId}")
    public ResponseEntity<ResponseDTO> addProductToPurchase(@PathVariable Long userId, @PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.addProductToPurchase(userId, productId));
    }

    @GetMapping("/showProducts/{userId}")
    public ResponseEntity<List<Product>> addProductToPurchase(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.showAllProductsOfPurchase(userId));
    }
}
