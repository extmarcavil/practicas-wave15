package sprint1.socialmeli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import sprint1.socialmeli.dto.Requests.PromoPostDTO;
import sprint1.socialmeli.dto.Requests.PostDTO;
import sprint1.socialmeli.dto.Responses.PostListDTO;
import sprint1.socialmeli.dto.Responses.PromoPostCountDTO;
import sprint1.socialmeli.service.IProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    //US 0005
    @PostMapping("/post")
    public ResponseEntity<?> save(@RequestBody PostDTO post) {
        return ResponseEntity.ok().body("Creado post: " + productService.save(post));
    }

    // US 0006 - US 0009
    @GetMapping("/followed/{followerUserID}/list")
    public ResponseEntity<PostListDTO> get2WeeksProductsOfFollowed(@PathVariable int followerUserID, @RequestParam @Nullable String order){
        return ResponseEntity.ok(productService.get2WeeksProductsOfFollowed(followerUserID, order));
    }

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<Integer> save(@RequestBody PromoPostDTO post) {
        return ResponseEntity.ok(productService.saveWithDiscount(post));
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostsCount(@RequestParam(name = "user_id") Integer userId) {
        return ResponseEntity.ok(productService.getPromoPostCount(userId));
    }
}
