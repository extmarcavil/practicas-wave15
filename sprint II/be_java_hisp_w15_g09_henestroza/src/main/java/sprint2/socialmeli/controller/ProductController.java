package sprint2.socialmeli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint2.socialmeli.dto.post.request.RequestPostDTO;
import sprint2.socialmeli.dto.post.response.ResponsePostListDTO;
import sprint2.socialmeli.service.IProductService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    //US 0005
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody @Valid RequestPostDTO post) {
        return ResponseEntity.ok().body("Creado post: " + productService.save(post));
    }

    // US 0006 - US 0009
    @GetMapping("/followed/{followerUserID}/list")
    public ResponseEntity<ResponsePostListDTO> get2WeeksProductsOfFollowed(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero")
            @NotNull(message = "El  id no puede estar vacío.") int followerUserID, @RequestParam @Nullable String order){
        return ResponseEntity.ok(productService.get2WeeksProductsOfFollowed(followerUserID, order));
    }

}
