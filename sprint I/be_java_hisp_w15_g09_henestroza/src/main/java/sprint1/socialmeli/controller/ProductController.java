package sprint1.socialmeli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dto.*;
import sprint1.socialmeli.model.Post;
import sprint1.socialmeli.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    //US 0005
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody PostRequestDTO post) {
        return ResponseEntity.ok().body("Creado post: " + productService.save(post));
    }

    // US 0006 - US 0009
    @GetMapping("/followed/{followerUserID}/list")
    public ResponseEntity<ResponsePostListDTO> get2WeeksProductsOfFollowed(@PathVariable int followerUserID, @RequestParam @Nullable String order){
        return ResponseEntity.ok(productService.get2WeeksProductsOfFollowed(followerUserID, order));
    }

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<Integer> save(@RequestBody PromoPostRequestDTO post) {
        return ResponseEntity.ok(productService.saveWithDiscount(post));
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostsCount(@RequestParam(name = "user_id") Integer userId) {
        return ResponseEntity.ok(productService.getPromoPostCount(userId));
    }

    // US 0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDTO> getPromoPosts(@RequestParam(name = "user_id") Integer userId) {
        return ResponseEntity.ok(productService.getPromoPosts(userId));
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
